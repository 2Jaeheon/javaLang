package ch13.sec04;

public class ThreadNameExample {

    //스레드 이름은 디버깅할 때 어떤 스레드가 작업을 하는지 조사할 목적으로 주로 사용됨.
    public static void main(String[] args) {
        Thread mainThread = Thread.currentThread(); //현재 코드가 어떤 스레드가 실행하고 있는지를 확인하기 위해 스레드 객체의 참조를 얻음.
        System.out.println(mainThread.getName() + " 실행");

        for (int i = 0; i < 3; i++) {
            Thread threadA = new Thread() {
                @Override
                public void run() {
                    //getName() 메소드는 Thread의 인스턴스 메소드로 스레드의 이름을 리턴
                    System.out.println(getName() + " 실행");
                }
            };
            threadA.start();
        }

        Thread chatThread = new Thread() {
            @Override
            public void run() {
                System.out.println(getName() + " 실행");
            }
        };
        chatThread.setName("chat-thread");
        chatThread.start();
    }
}
