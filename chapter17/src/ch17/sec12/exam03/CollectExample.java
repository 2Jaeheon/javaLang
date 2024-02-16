package ch17.sec12.exam03;

import ch17.sec12.exam01.Student;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class CollectExample {

    public static void main(String[] args) {
        List<Student> totalList = Arrays.asList(
            new Student("홍길동", "남", 92),
            new Student("신용권", "남", 95),
            new Student("감자바", "여", 88),
            new Student("박수미", "여", 88)
        );

        Map<String, Double> map = totalList.stream()
            .collect(
                Collectors.groupingBy( //성별로 그룹화
                    s -> s.getSex(),
                    Collectors.averagingDouble(s -> s.getScore()) //성별로 그룹화한 후, 평균값을 구한다.
                )
            );

        System.out.println(map);

    }
}
