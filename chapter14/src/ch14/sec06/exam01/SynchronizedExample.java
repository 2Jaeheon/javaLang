package ch14.sec06.exam01;

public class SynchronizedExample {

    public static void main(String[] args) {
        Calculator calculator = new Calculator();

        User1Thread user1Thread = new User1Thread(); //스레드 생성
        user1Thread.setCalculator(calculator); //공유 객체인 Calculator를 필드에 저장
        user1Thread.start(); //스레드 시작

        User2Thread user2Thread = new User2Thread(); //스레드 생성
        user2Thread.setCalculator(calculator);//공유 객체인 Calculator를 필드에 저장
        user2Thread.start();//스레드 시작
    }
}
