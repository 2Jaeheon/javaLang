package ch19.sec07;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.Socket;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class SocketClient {

    // field
    ChatServer chatServer;
    Socket socket;
    DataInputStream dis;
    DataOutputStream dos;
    String chatName;
    String clientIp;

    // 생성자
    public SocketClient(ChatServer chatServer, Socket socket) {
        try {
            this.chatServer = chatServer;
            this.socket = socket;
            this.dis = new DataInputStream(socket.getInputStream());
            this.dos = new DataOutputStream(socket.getOutputStream());
            InetSocketAddress isa = (InetSocketAddress) socket.getRemoteSocketAddress();
            this.clientIp = isa.getHostName();
            receive();
        } catch (IOException e) {
        }
    }

    // 메소드: json 받기
    public void receive() {
        // 스레드를 사용하는 이유
        // 1. 서버로부터 메시지를 받는 작업은 무한히 반복되어야 하기 때문
        // 2. 서버로부터 메시지를 받는 작업은 다른 작업과 동시에 수행되어야 하기 때문
        // => 동시에 수행되는 작업을 위해 스레드를 사용

        //chatServer.threadPool.execute가 무엇이고 어떻게 사용?
        //chatServer.threadPool.execute는 ExecutorService의 메소드로, Runnable 객체를 받아서 스레드를 실행한다.
        //Runnable 객체는 스레드가 실행할 작업을 정의하는 객체이다.
        //chatServer.threadPool.execute(() -> { ... });는 람다식을 사용하여 Runnable 객체를 생성한다.
        //람다식은 Runnable 객체의 run 메소드를 구현한다.
        //chatServer.threadPool.execute(() -> { ... });는 스레드 풀에서 스레드를 실행하고, 람다식으로 정의된 run 메소드를 실행한다.

        chatServer.threadPool.execute(() -> {
            try {
                JSONParser parser = new JSONParser();
                while (true) {
                    String receiveJson = dis.readUTF(); //chatClient가 보낸 JSON을 읽는다.
                    JSONObject jsonObject;
                    jsonObject = (JSONObject) parser.parse(
                        receiveJson); //JSON을 읽고 JSONObject로 파싱해서 command 값을 얻어낸다.
                    String command = (String) jsonObject.get("command");
                    System.out.println("command: " + command);

                    if (command != null) {
                        switch (command) {
                            case "incoming":
                                this.chatName = (String) jsonObject.get("data");
                                chatServer.sendToAll(this, "들어오셨습니다.");
                                chatServer.addSocketClient(this);
                                break;
                            case "message":
                                String message = (String) jsonObject.get("data");
                                chatServer.sendToAll(this, message);
                                break;
                        }
                    }
                }
            } catch (Exception e) {
                // 연결 오류 또는 다른 I/O 예외 처리
                try {
                    close();
                } catch (Exception ex) {
                    ex.printStackTrace();
                }
            }
        });
    }

    // 메소드 JSON 보내기
    public void send(String json) {
        try {
            dos.writeUTF(json);
            dos.flush();
        } catch (IOException e) {
        }
    }

    // 메소드: 연결 종료
    public void close() {
        try {
            if (dis != null) {
                dis.close();
            }
            if (dos != null) {
                dos.close();
            }
            if (socket != null) {
                socket.close();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
