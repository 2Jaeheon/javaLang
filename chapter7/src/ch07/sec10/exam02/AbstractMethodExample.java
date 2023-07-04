package ch07.sec10.exam02;

public class AbstractMethodExample {

    public static void main(String[] args) {
        Dog dog = new Dog();
        dog.sound();

        Cat cat = new Cat();
        cat.sound();

        //매개변수의 다형성
        //자동 타입변환
        animalSound(new Dog());
        animalSound(new Cat());
    }

    public static void animalSound(Animal animal) {
        animal.sound();
        //자동 타입 변환 이후에는 부모의 메소드 또는 필드에만 접근할 수 있으나
        //자식 객체에서 오버라이딩 된 메소드가 있다면 오버라이딩 된 메소드가 실행
    }
}
