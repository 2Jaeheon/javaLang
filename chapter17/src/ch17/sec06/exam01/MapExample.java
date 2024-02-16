package ch17.sec06.exam01;

import java.util.*;

public class MapExample {

    public static void main(String[] args) {
        List<Student> studentList = new ArrayList<>();
        studentList.add(new Student("홍길동", 10));
        studentList.add(new Student("신용권", 20));
        studentList.add(new Student("홍길동", 30));

        studentList.stream()
            .mapToInt(Student::getScore)
            // Student::getScore is a method reference
            // .mapToInt(student -> student.getScore())
            .forEach(score -> System.out.println(score));
    }
}
