package ch07.sec02;

public class SmartPhoneExample {

    public static void main(String[] args) {
        SmartPhone myPhone = new SmartPhone("갤럭시", "은색");
        //자식 객체를 생성하면 부모 객체도 함께 생성됨.
        //그렇기 때문에 model과 color는 부모 클래스의 필드인데도 초기화가 가능함.

        System.out.println("모델: " + myPhone.model);
        System.out.println("색상: " + myPhone.color);
        System.out.println("와이파이 상태: " + myPhone.wifi);

        //Phone으로부터 상속받은 메소드 호출
        myPhone.bell();
        myPhone.sendVoice("여보세요");
        myPhone.receiveVoice("안녕하세요! 저는 홍길동인데요");
        myPhone.sendVoice("아 네 반가워요");
        myPhone.hangUp();

        //SmartPhone의 메소드 호출
        myPhone.setWifi(true);
        myPhone.internet();
    }
}
