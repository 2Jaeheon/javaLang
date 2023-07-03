package ch07.sec08.exam02;

public class DriverExample {

    public static void main(String[] args) {
        //Driver 객체 생성
        Driver driver = new Driver();

        //매개값으로 Bus 객체를 제공하고 driver() 메소드 호출
        Bus bus = new Bus();
        driver.drive(bus);

        //매개값으로 Taxi 객체를 제공하고 driver() 메소드 호출
        Taxi taxi = new Taxi(); //driver.drive(new Taxi());와 동일
        //drive 메소드를 호출할 때 오버라이딩된 자식 객체를 매개변수로 전달하면 부모객체로 자동 형변환 -> 오버라이딩 된 자식객체의 메소드가 실행됨
        driver.drive(taxi);
    }
}
