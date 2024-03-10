package ch19.sec05.exam01;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.io.InputStream;
import java.io.OutputStream;

public class EchoServer {

    private static ServerSocket serverSocket = null; //서버 소켓 생성
    private static ExecutorService executorService = Executors.newFixedThreadPool(
        10); //10개의 스레드로 요청을 처리하는 스레드풀 생성

    public static void main(String[] args) {
        System.out.println("---------------------------------------------------");
        System.out.println("서버를 종료하려면 q를 입력하고 Enter키를 입력하세요. ");
        System.out.println("---------------------------------------------------");

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
        //작업 스레드 정의
        Thread thread = new Thread() {
            @Override
            public void run() {
                try {
                    //ServerSocket 생성 및 포트 바인딩
                    serverSocket = new ServerSocket(50001);
                    System.out.println("[서버] 시작됨");

                    while (true) {
                        Socket socket = serverSocket.accept();

                        executorService.execute(() -> {
                            try {
                                //연결된 클라이언트 정보 얻기
                                InetSocketAddress isa = (InetSocketAddress) socket.getRemoteSocketAddress();
                                System.out.println("[서버] " + isa.getHostName() + "의 연결 요청을 수락함.");

                                //데이터 받기
                                InputStream is = socket.getInputStream();
                                byte[] bytes = new byte[1024];
                                int num = is.read(bytes);
                                String message = new String(bytes, 0, bytes.length, "UTF-8");

                                //데이터 보내기
                                OutputStream os = socket.getOutputStream();
                                bytes = message.getBytes("UTF-8");
                                os.write(bytes);
                                os.flush();
                                System.out.println("[서버] 받은 데이터를 다시 보냄: " + message);

                                //연결 끊기
                                socket.close();
                                System.out.println("[서버]" + isa.getHostName() + "의 연결을 끊음\n");
                            } catch (IOException e) {

                            }
                        });
                    }
                } catch (IOException e) {

                }
            }

        };
        thread.start();
    }

    public static void stopServer() {

    }
}
