package ch14.sec02.exam02;

public class HomeAgency implements Rentable<Home> {

    @Override
    public Home rent() {
        return new Home(); //Home 객체를 생성해서 반환해주는 메소드
    }
}
