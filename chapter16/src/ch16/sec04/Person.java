package ch16.sec04;

public class Person {

    public void action(Calcuable calcuable) {
        double result = calcuable.culc(10, 4);
        System.out.println("result: " + result);
    }
}
