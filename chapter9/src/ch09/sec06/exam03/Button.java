package ch09.sec06.exam03;

public class Button {

    //정적 멤버 인터페이스
    public static interface ClickListener {
        //추상 메소드
        void onClick();
    }

    private ClickListener clickListener; //레퍼런스 변수

    //method
    public void setClickListener(ClickListener clickListener) {
        this.clickListener = clickListener;
    }

    public void click() {
        this.clickListener.onClick();
    }
}
