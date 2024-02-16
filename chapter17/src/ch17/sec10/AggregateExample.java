package ch17.sec10;

import java.util.*;

public class AggregateExample {

    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5};

        //counting
        long count = Arrays.stream(arr)
            .filter(n -> n % 2 == 0)
            .count();
        System.out.println("2의 배수의 개수: " + count);

        //sum
        long sum = Arrays.stream(arr)
            .filter(n -> n % 2 == 0)
            .sum();
        System.out.println("2의 배수의 합: " + sum);

        //average
        double avg = Arrays.stream(arr)
            .filter(n -> n % 2 == 0)
            .average()
            .getAsDouble();
        System.out.println("2의 배수의 평균: " + avg);

        //max
        int max = Arrays.stream(arr)
            .filter(n -> n % 2 == 0)
            .max()
            .getAsInt();
        System.out.println("2의 배수의 최대값: " + max);

        //min
        int min = Arrays.stream(arr)
            .filter(n -> n % 2 == 0)
            .min()
            .getAsInt();
        System.out.println("2의 배수의 최소값: " + min);

        //firstElement
        int first = Arrays.stream(arr)
            .filter(n -> n % 2 == 0)
            .findFirst()
            .getAsInt();
        System.out.println("첫 번째 3의 배수: " + first);
    }
}
