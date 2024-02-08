package ch14.sec07.exam02;

public class InterruptExample {

    public static void main(String[] args) {
        Thread thread = new PrintThread();
        thread.start();

        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {

        }
        thread.interrupt();
        //interrupt()메소드를 실행하면 Thread가 일시정지상태가 될 때 InterruptedException이 발생해서 에외처리 블록으로 이동시킨다.
        //이렇게 해서 스레드를 종료할 수 있다.
    }
}
