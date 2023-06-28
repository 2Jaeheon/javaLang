package ch06.sec08.exam01;

public class CalculatorExample {

    public static void main(String[] args) {
        //Calculator 객체 생성
        Calculator myCal = new Calculator();

        //리턴 값이 없는 powerOn() 메소드 출력
        myCal.powerOn();

        //plus 메소드 호출 시 인자 두개를 더해 반환해준다.
        int result = myCal.plus(5, 6);
        System.out.println("result = " + result);

        int x = 10;
        int y = 4;

        //divide 메소드 호출 시 인자 두 개를 나눠서 리턴한다.
        double result2 = myCal.divide(x, y);
        System.out.println("result2 = " + result2);

        //리턴 값이 없는 powerOff 출력
        myCal.powerOff();
    }
}
