package sec03;

import java.util.Arrays;
import java.util.List;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class StreamPipeLineExample {

    public static void main(String[] args) {
        List<Student> list = Arrays.asList(
            new Student("홍길동", 10),
            new Student("신용권", 20),
            new Student("유미선", 30)
        );

        //방법 1
        Stream<Student> studentStream = list.stream();
        //중간처리
        //mapToInt() 메소드는 객체를 int값으로 매핑해서 IntStream으로 전환시키는 것
        IntStream scoreStream = studentStream.mapToInt(student -> student.getScore());



        double avg = list.stream()
            .mapToInt(Student::getScore)
            .average()
            .getAsDouble();

        System.out.println("평균 점수: " + avg);
    }
}
