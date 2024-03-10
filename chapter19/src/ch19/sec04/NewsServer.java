package ch19.sec04;

import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.SocketAddress;
import java.util.*;

public class NewsServer {

    private static DatagramSocket datagramSocket = null;

    public static void main(String[] args) {
        System.out.println("------------------------------------------------");
        System.out.println("서버를 종료하시려면 q를 입력하고 Enter키를 눌러주세요");
        System.out.println("------------------------------------------------");

        //UDP 서버 시작
        startServer();

        Scanner scanner = new Scanner(System.in);
        while (true) {
            String key = scanner.nextLine();
            if (key.toLowerCase().equals("q")) {
                break;
            }
        }

        scanner.close();

        //UDP서버 종료
        stopServer();
    }

    public static void startServer() {
        Thread thread = new Thread() {
            @Override
            public void run() {
                try {
                    //DatagramSocket 생성 및 바인딩
                    datagramSocket = new DatagramSocket(50001);
                    System.out.println("서버 시작");

                    while (true) {
                        DatagramPacket receivePacket = new DatagramPacket(new byte[1024], 1024);
                        datagramSocket.receive(receivePacket);
                        String newsKind = new String(receivePacket.getData(), 0,
                            receivePacket.getLength(), "UTF-8");

                        //클라이언트의 IP와 Port 얻기
                        SocketAddress socketAddress = receivePacket.getSocketAddress();

                        //10개의 뉴스를 클라이언트로 전송
                        for (int i = 1; i <= 10; i++) {
                            String data = newsKind + ": 뉴스" + i;
                            byte[] bytes = data.getBytes("UTF-8");
                            //데이터그램 패킷을 만들어서 데이터그램 소켓으로 전송
                            DatagramPacket sendPacket = new DatagramPacket(bytes, 0, bytes.length,
                                socketAddress);
                            datagramSocket.send(sendPacket);
                        }
                    }
                } catch (Exception e) {
                    System.out.println("[서버]" + e.getMessage());
                }
            }
        };
        thread.start();
    }

    public static void stopServer() {
        datagramSocket.close();
        System.out.println("[서버] 종료됨");
    }
}

