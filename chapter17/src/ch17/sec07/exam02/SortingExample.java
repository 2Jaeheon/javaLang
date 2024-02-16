package ch17.sec07.exam02;

import java.util.*;

public class SortingExample {

    public static void main(String[] args) {
        List<Student> studentList = new ArrayList<>();

        studentList.add(new Student("홍길동", 30));
        studentList.add(new Student("신용권", 10));
        studentList.add(new Student("감자바", 20));

        //점수를 기준으로 오름차순으로 정렬한 새 스트림 얻기
        studentList.stream()
            .sorted((s1, s2) -> Integer.compare(s1.getScore(),
                s2.getScore())) //Comparator에 따라 정렬한 새 스트림 생성
            .forEach(s -> System.out.println(s.getScore()));
        //Student 클래스가 Comparable 인터페이스를 구현하지 않았기 때문에 sorted() 메소드에 Comparator를 매개값으로 제공해야 한다.
        //Integer.compare() 메소드는 두 정수를 매개값으로 받아서 첫 번째 매개값이 작으면 -1, 같으면 0, 크면 1을 리턴한다.
        //따라서 s1.getScore()가 s2.getScore()보다 작으면 -1, 같으면 0, 크면 1을 리턴한다.
        System.out.println();

        studentList.stream().forEach(s -> System.out.println(s.getScore()));
        System.out.println();

        //점수를 기준으로 내림차순으로 정렬한 새 스트림 얻기
        studentList.stream()
            .sorted((s1, s2) -> Integer.compare(s2.getScore(), s1.getScore()))
            .forEach(s -> System.out.println(s.getScore()));
    }
}
