package ch16.sec05.exam01;

public class MethodReferenceExample {

    public static void main(String[] args) {
        Person person = new Person();

        //정적메소드경우
        //람다식
        //perosn.action((x,y)->Computer.staticMethod(x, y));
        //메소드 참조
        person.action(Computer::staticMethod); //클래스::메소드

        //인스턴스 메소드인 경우
        Computer com = new Computer();
        //람다식
        //perosn.action((x,y)->com.instanceMethod(x, y));
        //메소드 참조
        person.action(com::instanceMethod); //참조변수::메소드
    }
}
