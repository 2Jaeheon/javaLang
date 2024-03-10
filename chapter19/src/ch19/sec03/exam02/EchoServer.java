package ch19.sec03.exam02;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.*;

public class EchoServer {

    private static ServerSocket serverSocket = null;

    public static void main(String[] args) {
        System.out.println("----------------------------------------------");
        System.out.println("서버를 종료하려면 q를 입력하시고 enter키를 눌러주세요");
        System.out.println("----------------------------------------------");

        //TCP 서버 시작
        startServer();

        //키보드 입력
        Scanner scanner = new Scanner(System.in);
        while (true) {
            String key = scanner.nextLine();
            if (key.toLowerCase().equals("q")) {
                break;
            }
        }

        scanner.close();
        //TCP 서버 종료
        stopServer();
    }

    public static void startServer() {
        Thread thread = new Thread() {
            @Override
            public void run() {
                try {
                    //ServerSocket 생성 및 port 바인딩
                    serverSocket = new ServerSocket(50001);
                    System.out.println("[서버] 시작됨");

                    //연결 수락 및 데이터 통신
                    while (true) {
                        System.out.println("\n[서버]연결 요청을 기다림");
                        //연결 수락
                        Socket socket = serverSocket.accept();

                        //연결된 클라이언트 정보 얻기
                        InetSocketAddress isa = (InetSocketAddress) socket.getRemoteSocketAddress();
                        System.out.println("[서버] " + isa.getHostName() + "의 연결 요청을 수락함");

                        //서버에서 데이터 받기
                        InputStream is = socket.getInputStream();
                        byte[] bytes = new byte[1024];
                        int readByteCount = is.read(bytes); //읽은 데이터를 bytes에 저장하고 읽은 바이트수를 반환한다.
                        String message = new String(bytes, 0, readByteCount, "UTF-8");

                        //서버로부터 데이터 전송하기
                        OutputStream os = socket.getOutputStream();
                        bytes = message.getBytes("UTF-8");
                        os.write(bytes);
                        os.flush();

                        System.out.println("[서버] 받은 데이터를 다시 보냄");

                        socket.close();
                        System.out.println("[서버] " + isa.getHostName() + "의 연결을 끊음");
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        };
        thread.start();
    }

    public static void stopServer() {
        try {
            //ServerSocket을 닫고 Port 언바인딩
            serverSocket.close();
            System.out.println("[서버] 종료됨");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
