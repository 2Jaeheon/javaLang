package ch06.sec08.exam01;

public class Calculator {
    void powerOn(){
        System.out.println("전원을 킵니다.");
    }
    void powerOff(){
        System.out.println("전원을 끕니다.");
    }

    //호출 시 두 정수 값을 전달받고 호출한 곳으로 int형 결과값을 반환하는 메소드 선언
    int plus(int x, int y){
        int result = x + y;
        return result;
    }

    double divide(int x, int y){
        double result = (double) x / y;
        return result;
    }
}
