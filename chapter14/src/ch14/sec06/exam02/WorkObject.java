package ch14.sec06.exam02;

public class WorkObject {

    public synchronized void methodA() { //동기화 메소드 A
        Thread thread = Thread.currentThread();
        System.out.println(thread.getName() + ": method A 작업 실행");
        notify();
        try {
            wait();
        } catch (InterruptedException e) {

        }
    }

    public synchronized void methodB() { //동기화 메소드 B
        Thread thread = Thread.currentThread();
        System.out.println(thread.getName() + ": method B 작업 실행");
        notify(); //다른 스레드를 실행 대기 상태로 만듦
        try {
            wait(); //자신의 스레드는 일시정지 상태로 만듦
        } catch (InterruptedException e) {

        }
    }
}
