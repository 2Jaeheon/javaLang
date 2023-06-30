package ch07.sec03.exam01;

public class SmartPhone extends Phone {

    //매개변수가 있는 SmartPhone 생성자 생성
    public SmartPhone(String model, String color) {
        super(); //컴파일러에서 기본적으로 생성
        this.model = model;
        this.color = color;
        System.out.println("SmartPhone 생성자 실행됨");
    }
}
