package ch11.sec02.exam01;

public class ExceptionHandlingExample1 {

    public static void printLength(String data) {
        int result = data.length(); //데이터가 null일 경우 NullPointerException 발생
        System.out.println("문자수: " + result);
    }

    public static void main(String[] args) {
        System.out.println("프로그램 시작");
        printLength("this is JAVA");
        printLength(null); //NullPointerException 발생
        System.out.println("프로그램 종료");
    }
}

