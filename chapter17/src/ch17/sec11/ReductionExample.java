package ch17.sec11;

import java.util.*;

public class ReductionExample {

    public static void main(String[] args) {
        List<Student> studentList = Arrays.asList(
            new Student("홍길동", 92),
            new Student("신용권", 95),
            new Student("감자바", 88)
        );

        //방법1
        int sum1 = studentList.stream()
            .mapToInt(Student::getScore)
            .sum();

        //방법2
        //reduce() 메소드는 스트림의 요소를 줄여가면서 연산을 수행한다.
        //첫 번째 매개값은 초기값이고, 두 번째 매개값은 BinaryOperator<T> 인터페이스를 구현한 람다식이다.
        int sum2 = studentList.stream()
            .map(Student::getScore)
            .reduce(0, (a, b) -> a + b);

        System.out.println("sum1: " + sum1);
        System.out.println("sum2: " + sum2);

    }
}
