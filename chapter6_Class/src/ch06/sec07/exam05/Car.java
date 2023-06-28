package ch06.sec07.exam05;

public class Car {

    //필드선언
    String company = "현대자동차";
    String model;
    String color;
    int maxSpeed;

    //this()를 통해서 공통 코드를 가지고 있는 생성자를 호출함.

    Car(String model) {
        this(model, "은색", 250);
    }

    Car(String model, String color) {
        this(model, color, 250);
    }

    Car(String model, String color, int maxSpeed) {
        this.model = model;
        this.color = color;
        this.maxSpeed = maxSpeed;
    }
}
