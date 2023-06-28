package ch06.sec10.exam01;

public class CalculatorExample {

    public static void main(String[] args) {
        double result1 = 10 * 10 * Calculator.pi;
        //정적 요소에 접근할 때는 클래스 이름을 ㅗ접근해야한다.


        int result2 = Calculator.plus(10, 5);
        int result3 = Calculator.minus(10, 5);

        System.out.println("result1 = " + result1);
        System.out.println("result2 = " + result2);
        System.out.println("result3 = " + result3);
    }
}
