package ch17.sec12.exam01;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class CollectExample {

    public static void main(String[] args) {
        List<Student> totalList = new ArrayList<>();
        totalList.add(new Student("홍길동", "남", 92));
        totalList.add(new Student("신용권", "남", 95));
        totalList.add(new Student("감자바", "여", 88));
        totalList.add(new Student("박수미", "여", 88));

        //남학생만 묶어서 List 생성
        //List<Stduent> maleList = totalList.stream()
        //    .filter(s -> s.getSex().equals("남")).toList();

        List<Student> maleList = totalList.stream()
            .filter(s -> s.getSex().equals("남"))
            .collect(Collectors.toList()); //자바 8에서는 이렇게

        maleList.stream()
            .forEach(s -> System.out.println(s.getName()));
        System.out.println();

        //학생 이름을 키, 학생의 점수를 값으로 갖는 Map 생성
        Map<String, Integer> map = totalList.stream()
            .collect(
                Collectors.toMap(
                    Student::getName, //Student 객체에서 키가 될 부분인 이름 리턴
                    Student::getScore //Student 객체에서 값이 될 부분인 점수 리턴
                )
            );

        System.out.println(map);
    }
}
