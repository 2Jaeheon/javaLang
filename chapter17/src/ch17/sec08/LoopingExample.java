package ch17.sec08;

import java.util.*;

public class LoopingExample {

    public static void main(String[] args) {
        int[] intArr = {1, 2, 3, 4, 5};

        //잘못 된 코드
        Arrays.stream(intArr)
            .filter(a -> a % 2 == 0)
            .peek(n -> System.out.println(n));
        //peek() 메소드는 중간 처리 메소드로서 최종 처리 메소드가 호출되기 전까지 동작하지 않는다.

        //중간 처리 메소드 peek()을 이용해서 반복처리
        int total = Arrays.stream(intArr)
            .filter(a -> a % 2 == 0)
            .peek(n -> System.out.println(n))
            .sum();
        System.out.println("총합: " + total);

        //최종 처리 메소드 forEach()를 사용하여 반복 처리
        Arrays.stream(intArr)
            .filter(a -> a % 2 == 0)
            .forEach(n -> System.out.println(n));
    }
}
