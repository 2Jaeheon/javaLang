package ch16.sec02.exam02;

public class ButtonExample {

    public static void main(String[] args) {
        Button btnOk = new Button();

        //OK 버튼 객체에 람다식(clickListner 익명 구현 객체) 주입
        btnOk.setClickListener(() -> {
            System.out.println("OK 버튼을 클릭했습니다.");
        });

        //Ok 버튼 클릭하기
        btnOk.click();

        Button btnCancel = new Button();
        //Cancle 버튼 객체 생성
        btnCancel.setClickListener(() -> {
            System.out.println("Cancle 버튼을 클릭했습니다.");
        });

        //Cancle 버튼 클릭하기
        btnCancel.click();

    }
}

