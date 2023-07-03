package ch07.sec07.exam03;

public class ChildExample {

    public static void main(String[] args) {
        //객체 생성 및 자동 타입 변환
        //자식 -> 부모
        Parent parent = new Child();

        //Parent 타입으로 필드와 메소드 사용
        parent.field1 = "data1";
        //method1 와 method2는 부모메서드에 포함
        parent.method1();
        parent.method2();

        /*
        불가능
            field2와 method3는 자식메소드
        * parent.field2 = "data2";
        * parent.method3();
        */


        //자식 타입의 멤버에 접근하기 위해서 cating시도
        //강제 타입 변환
        Child child = (Child) parent;

        //Child 타입으로 필드와 메소드 사용
        child.field2 = "data";
        child.method3();
    }
}
