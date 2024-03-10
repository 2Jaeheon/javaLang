package ch19.sec03.exam01;

import java.io.IOException;
import java.net.Socket;
import java.net.UnknownHostException;

public class ClientExample {

    public static void main(String[] args) {
        try {
            //Socket 생성과 동시에 local host의 50001 Port 로 연결 요청
            Socket socket = new Socket("localhost", 50001);
            System.out.println("[클라이언트] 연결 성공");

            //Socket 닫기
            socket.close();
            System.out.println("[클라이언트] 연결 끊기");
        } catch (UnknownHostException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
