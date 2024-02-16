package ch16.sec05.exam02;

public class Person {

    public void ordering(Comparable comparable) {
        String a = "홍길동";
        String b = "김길동";

        int result = comparable.compare(a, b);

        if (result < 0) {
            System.out.println(a + "이 " + b + "보다 먼저 옵니다.");
        } else if (result == 0) {
            System.out.println(a + "과 " + b + "은 같습니다.");
        } else {
            System.out.println(b + "이 " + a + "보다 먼저 옵니다.");
        }
    }
}
