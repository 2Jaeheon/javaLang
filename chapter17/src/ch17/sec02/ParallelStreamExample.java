package ch17.sec02;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

public class ParallelStreamExample {

    public static void main(String[] args) {
        List<String> list = new ArrayList<>();
        list.add("홍길동");
        list.add("신용권");
        list.add("감자바");
        list.add("람다식");
        list.add("박병렬");

        //병렬처리
        Stream<String> parallelStream = list.parallelStream();
        //Java8에서 등장한 Stream은 병렬 처리를 쉽게 할 수 있도록 메소드를 제공해 준다.
        // 개발자가 직접 스레드 혹은 스레드풀을 생성하거나 관리할 필요 없이 parallelStream(), parallel()만 사용하면 알아서 ForkJoinFramework 관리 방식을 이용하여 작업들을 분할하고, 병렬적으로 처리하게 된다.

        parallelStream.forEach(name -> {
            System.out.println(name + " : " + Thread.currentThread().getName());
        });
    }
}
