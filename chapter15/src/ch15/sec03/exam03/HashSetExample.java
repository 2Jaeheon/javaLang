package ch15.sec03.exam03;

import java.util.*;

public class HashSetExample {

    public static void main(String[] args) {
        Set<String> set = new HashSet<>();

        set.add("JAVA");
        set.add("JDBC");
        set.add("JSP");
        set.add("Spring");

        //반복을 돌려서 jsp를 찾았을 때 제거하는 로직
        Iterator<String> iterator = set.iterator();
        while (iterator.hasNext()) {
            String element = iterator.next();
            System.out.println(element);
            if (element.equals("JSP")) {
                iterator.remove();
            }
        }
        System.out.println();

        set.remove("JDBC");
        for (String element : set) {
            System.out.println(element);
        }
    }
}
