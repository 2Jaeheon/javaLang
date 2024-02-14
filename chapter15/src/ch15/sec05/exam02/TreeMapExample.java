package ch15.sec05.exam02;

import java.util.*;
import java.util.Map.Entry;

public class TreeMapExample {

    public static void main(String[] args) {
        TreeMap<String, Integer> treeMap = new TreeMap<>();

        //엔트리저장
        treeMap.put("apple", 10);
        treeMap.put("forever", 60);
        treeMap.put("description", 40);
        treeMap.put("ever", 50);
        treeMap.put("zoo", 80);
        treeMap.put("base", 20);
        treeMap.put("guess", 70);
        treeMap.put("cherry", 30);

        //정렬된 엔트리를 하나씩 가져오기
        Set<Entry<String, Integer>> entrySet = treeMap.entrySet();
        for (Entry<String, Integer> entry : entrySet) {
            System.out.println(entry.getKey() + "-" + entry.getValue());
        }
        System.out.println();

        //특정 키에 대한 값 가져오기
        Entry<String, Integer> entry = null;
        entry = treeMap.firstEntry();
        System.out.println("제일 앞 단어 : " + entry.getKey() + "-" + entry.getValue());
        entry = treeMap.lastEntry();
        System.out.println("제일 뒤 단어 : " + entry.getKey() + "-" + entry.getValue());
        entry = treeMap.lowerEntry("ever");
        System.out.println("ever 아래 단어 : " + entry.getKey() + "-" + entry.getValue());

        //내림차순으로 정렬하기
        NavigableMap<String, Integer> descendingMap = treeMap.descendingMap();
        Set<Entry<String, Integer>> descendingEntrySet = descendingMap.entrySet();
        for (Entry<String, Integer> entry2 : descendingEntrySet) {
            System.out.println(entry2.getKey() + "-" + entry2.getValue());
        }

        //범위 검색
        System.out.println("range search : c ~ h");
        NavigableMap<String, Integer> rangeMap = treeMap.subMap("c", true, "h", true);
        for (Entry<String, Integer> entry3 : rangeMap.entrySet()) {
            System.out.println(entry3.getKey() + "-" + entry3.getValue());
        }

    }

}
