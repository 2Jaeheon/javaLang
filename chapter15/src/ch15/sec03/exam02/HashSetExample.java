package ch15.sec03.exam02;

import java.util.*;

public class HashSetExample {

    public static void main(String[] args) {
        Set<Member> set = new HashSet<>();

        //인스턴스가 다르지만 동등객체이므로 객체 1개만 저장
        set.add(new Member("홍길동", 30));
        set.add(new Member("홍길동", 30));

        System.out.println("총 객체 수 : " + set.size());
    }
}
