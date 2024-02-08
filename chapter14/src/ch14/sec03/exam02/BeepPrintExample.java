package ch14.sec03.exam02;

import java.awt.Toolkit;

public class BeepPrintExample {


    public static void main(String[] args) {
        //Runnable 구현 객체를 매개값으로 갖는 생성자를 호출
        Thread thread = new Thread(new Runnable() {
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
        });

        thread.start();

        for (int i = 0; i < 5; i++) {
            System.out.println("띵");
            try {
                Thread.sleep(500);
            } catch (Exception e) {

            }
        }

        //위의 코드들을 익명객체를 사용하지 않고 따로 Runnable 구현 클래스를 작성하는 코드로 변환
        //Runnable 구현 클래스를 작성
        class SoundRunnable implements Runnable {

            @Override
            public void run() {
                Toolkit toolkit = Toolkit.getDefaultToolkit();

                for (int i = 0; i < 6; i++) {
                    toolkit.beep();
                    try {
                        Thread.sleep(1000);
                    } catch (Exception e) {
                    }
                }
            }
        }
        Runnable runnable = new SoundRunnable();
        Thread thread2 = new Thread(runnable);
        thread2.start();
    }
}
