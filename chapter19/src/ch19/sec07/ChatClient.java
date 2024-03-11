package ch19.sec07;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.net.Socket;
import java.io.IOException;
import java.util.Scanner;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;


public class ChatClient {

    Socket socket;
    DataInputStream dis;
    DataOutputStream dos;
    String chatName;


    //메소드: 서버 연결
    public void connect() throws IOException {
        socket = new Socket("localhost", 50001);
        dis = new DataInputStream(socket.getInputStream());
        dos = new DataOutputStream(socket.getOutputStream());
        System.out.println("[클라이언트] 서버에 연결됨");
    }

    //메소드: JSON 받기
    public void receive() {
        //스레드를 사용하는 이유
        //1. 서버로부터 메시지를 받는 작업은 무한히 반복되어야 하기 때문
        //2. 서버로부터 메시지를 받는 작업은 다른 작업과 동시에 수행되어야 하기 때문
        // => 동시에 수행되는 작업을 위해 스레드를 사용
        Thread thread = new Thread(() -> {
            try {
                JSONParser parser = new JSONParser();
                while (true) {
                    String json = dis.readUTF();
                    JSONObject root = (JSONObject) parser.parse(json);
                    String clientIp = (String) root.get("clientIp");
                    String chatName = (String) root.get("chatName");
                    String message = (String) root.get("message");
                    System.out.println("<" + chatName + "@" + clientIp + ">" + message);
                }

            } catch (Exception e1) {
                System.out.println("[클라이언트] 서버 연결 끊김");
                System.exit(0);
            }
        });
        thread.start();
    }

    //메소드: JSON 보내기
    public void send(String json) throws IOException {
        dos.writeUTF(json);
        dos.flush();
    }

    public void unconnect() throws IOException {
        socket.close();
    }

    public static void main(String[] args) throws IOException {
        try {
            ChatClient chatClient = new ChatClient();
            chatClient.connect();

            Scanner scanner = new Scanner(System.in);
            System.out.print("닉네임 입력: ");
            chatClient.chatName = scanner.nextLine();

            JSONObject jsonObject = new JSONObject();
            jsonObject.put("command", "incoming");
            jsonObject.put("data", chatClient.chatName);
            String json = jsonObject.toString();
            chatClient.send(json);
            chatClient.receive();

            System.out.println("------------------------------------------------------------");
            System.out.println("보낼 메시지를 입력하고 Enter를 입력하세요");
            System.out.println("종료하려면 q를 입력하고 Enter를 입력하세요");
            System.out.println("------------------------------------------------------------");

            while (true) {
                String message = scanner.nextLine();
                if (message.toLowerCase().equals("q")) {
                    break;
                } else {
                    jsonObject = new JSONObject();
                    jsonObject.put("command", "message");
                    jsonObject.put("data", message);
                    json = jsonObject.toString();
                    chatClient.send(json);
                }
            }
            scanner.close();
            chatClient.unconnect();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
