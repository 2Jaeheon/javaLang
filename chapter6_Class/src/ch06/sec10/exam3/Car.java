package ch06.sec10.exam3;

public class Car {

    int speed;

    void run(){
        System.out.println(speed + "으로 달립니다.");
    }
    //정적 멤버는 인스턴스 멤버를 사용할 수 없다. 또한 객체의 자신 참조인 this도 사용할 수 없다.
    //만약 인스턴스 멤버를 사용하고 싶다면 객체를 생성한 후 참조변수로 접근해야한다.
    static void simulate(){
        Car myCar = new Car();
        myCar.speed = 200;
        myCar.run();
    }

    public static void main(String[] args) {
        simulate();

        Car myCar = new Car();
        myCar.speed = 600;
        myCar.run();
    }
}
