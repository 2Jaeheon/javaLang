package ch13.sec05;

public class Course {
    //모든 사람이면 등록 가능
    public static void registerCourse1(Applicant<?> applicant){
        System.out.println(applicant.kind.getClass().getSimpleName() + "이(가) Course1을 등록함");
    }

    //학생만 등록 가능
    //Student의 하위 타입만 매개변수로 받을 수 있음
    public static void registerCourse2(Applicant<? extends Student> applicant){
        System.out.println(applicant.kind.getClass().getSimpleName() + "이(가) Course2를 등록함");
    }

    //직장인 및 일반인만 등록가능
    //Worker와 부모 타입만 매개변수로 가능
    public static void registerCourse3(Applicant<? super Worker> applicant){
        System.out.println(applicant.kind.getClass().getSimpleName() + "이(가) Course3를 등록함");
    }
}
