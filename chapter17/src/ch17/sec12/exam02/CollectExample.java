package ch17.sec12.exam02;

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

        Map<String, List<Student>> map = totalList.stream()
            .collect(
                Collectors.groupingBy(Student::getSex)
            );

        List<Student> maleList = map.get("남");
        maleList.stream().forEach(s -> System.out.println(s.getName()));
        System.out.println();

        List<Student> femaleList = map.get("여");
        femaleList.stream().forEach(s -> System.out.println(s.getName()));
    }
}
