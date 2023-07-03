package ch07.sec08.exam01;

public class CarExample {

    public static void main(String[] args) {
        //Car 객체 생성
        Car myCar = new Car();

        //Tire 객체 장착
        myCar.tire = new Tire();
        myCar.run();

        //HankookTire객체 장착
        //자식타입의 객체를 부모타입의 객체에다가 넣어서 자동 형변환
        myCar.tire = new HankookTire();

        myCar.run();

        //KumhoTire 객체 장착
        //자식타입의 객체를 부모타입의 객체에다가 넣어서 자동 형변환
        myCar.tire = new KumhoTire();
        myCar.run();
    }
}
