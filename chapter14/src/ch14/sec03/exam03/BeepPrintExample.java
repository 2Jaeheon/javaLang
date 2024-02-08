package ch14.sec03.exam03;

import java.awt.Toolkit;

public class BeepPrintExample {


    public static void main(String[] args) {
        //Runnable 구현 객체를 매개값으로 갖는 생성자를 호출
        Thread thread = new Thread() {
            @Override
            //작업 스레드가 실행할 코드
            public void run() {
                Toolkit toolkit = Toolkit.getDefaultToolkit();
                for (int i = 0; i < 5; i++) {
                    toolkit.beep();
                    try {
                        Thread.sleep(500);
                    } catch (Exception e) {
                    }
                }
            }
        };

        thread.start();

        for (int i = 0; i < 5; i++) {
            System.out.println("띵");
            try {
                Thread.sleep(500);
            } catch (Exception e) {

            }
        }

    }
}
