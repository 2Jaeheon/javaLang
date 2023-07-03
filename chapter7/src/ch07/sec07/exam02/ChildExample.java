package ch07.sec07.exam02;

public class ChildExample {

    public static void main(String[] args) {
        //자식 객체 생성
        Child child = new Child();

        //자동 타입 변환
        Parent parent = child;

        //method
        parent.method1();
        parent.method2();
        //부모타입으로 형변환 이후에는 부모 클래스에 선언된 필드와 메소드만 접근이 가능하다.
        //그러나 자식 클래스에서 오버라이딩된 메소드가 있다면 부모 메소드 대신 오버라이딩된 메소드가 호출된다.
        //Parent.method3();
    }
}
