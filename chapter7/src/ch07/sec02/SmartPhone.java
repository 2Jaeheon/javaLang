package ch07.sec02;

public class SmartPhone extends Phone {
    //SmartPhone 클래스가 Phone클래스를 상속받음.

    //feild
    public boolean wifi;

    //constructor
    public SmartPhone(String model, String color) {
        this.model = model; //Phone으로부터 상속받은 필드
        this.color = color; //Phone으로부터 상속받은 필드
    }

    //method
    public void setWifi(boolean wifi) {
        this.wifi = wifi;
        System.out.println("와이파이 상태를 변경했습니다.");
    }

    public void internet() {
        System.out.println("인터넷에 연결합니다.");
    }
}
