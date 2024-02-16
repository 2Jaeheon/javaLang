package ch17.sec03;

import java.util.Arrays;
import java.util.List;

public class StreamPipeLineExample {

    public static void main(String[] args) {
        List<Student> list = Arrays.asList(
            new Student("홍길동", 92),
            new Student("신용권", 95),
            new Student("감자바", 88)
        );

        //방법 1
        //Stream<Student> studentStream = list.stream();
        //중간처리
        //IntStream scoreStream = studentStream.mapToInt(student -> student.getScore());
        //최종처리
        //double avg = scoreStream.average().getAsDouble();

        //방법2
        double avg = list.stream()
            .mapToInt(student -> student.getScore())
            .average()
            .getAsDouble();

        System.out.println("평균 점수: " + avg);
    }
}
