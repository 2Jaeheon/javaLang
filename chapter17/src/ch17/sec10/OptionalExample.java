package ch17.sec10;

import java.util.*;

public class OptionalExample {

    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>();
        
        //예외발생
        //double avg = list.stream().mapToInt(Integer::intValue).average().getAsDouble();

        //방법1
        //isPresent() 메소드는 Optional 객체에 값이 있는지 확인한다.
        OptionalDouble optional = list.stream()
            .mapToInt(Integer::intValue)
            .average();
        if (optional.isPresent()) {
            System.out.println("방법1 평균: " + optional.getAsDouble());
        } else {
            System.out.println("방법1 평균: 0.0");
        }

        //방법2
        //orElse() 메소드는 Optional 객체에 값이 없을 때 기본값을 리턴한다.
        double avg = list.stream()
            .mapToInt(Integer::intValue) //Integer::intValue 는 n -> n.intValue()와 같다.
            .average()
            .orElse(0.0);
        System.out.println("방법2 평균: " + avg);

        //방법3
        //ifPresent() 메소드는 Optional 객체에 값이 있을 때만 실행할 작업을 지정할 수 있다.
        list.stream()
            .mapToInt(Integer::intValue)
            .average()
            .ifPresent(a -> System.out.println("방법3 평균: " + a));
    }
}

