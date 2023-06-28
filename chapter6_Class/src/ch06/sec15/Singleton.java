package ch06.sec15;

public class Singleton {

    private static Singleton singleton = new Singleton();

    //private 접근 권한을 갖는 생성자 선언
    private Singleton() {
    }

    //public 접근 권한을 갖는 정적 메소드 선언
    public static Singleton getInstance(){
        return singleton;
    }
}
