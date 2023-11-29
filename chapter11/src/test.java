import java.util.*;

public class test {

    public static void main(String[] args) {

        //x를 특정한 수로 나누는 프로그램
        int x = 10;
        int y = -1;
        int op;
        try {
            Scanner sc = new Scanner(System.in);
            op = sc.nextInt();
            y = x / op;
        } catch (ArithmeticException e) {
            System.out.println("0으로 나누는 문제가 발생했습니다.");
        } finally {
            System.out.println("x를 입력받은 값을로 나눈 결과: " + y);
        }
    }

}
