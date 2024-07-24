package sec01;

public class LambdaExample {

    public static void main(String[] args) {
        action((x, y) -> {
            int result = x + y;
            System.out.println("result: " + result);
        });

        action((x, y) -> {
            int result = x - y;
            System.out.println("result: " + result);
        });
    }

    public static void action(CalCulable calCulable) {
        int x = 10;
        int y = 4;
        //데이터 처리
        calCulable.calculate(x, y);
    }
}
