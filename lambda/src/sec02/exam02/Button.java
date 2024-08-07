package sec02.exam02;

public class Button {

    @FunctionalInterface
    public static interface ClickListener {

        //추상메서드
        void onClick();
    }

    //필드
    private ClickListener clickListener;

    //메소드
    public void setClickListener(ClickListener clickListener) {
        this.clickListener = clickListener;
    }

    public void click() {
        this.clickListener.onClick();
    }

}
