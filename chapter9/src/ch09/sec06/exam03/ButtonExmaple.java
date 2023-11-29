package ch09.sec06.exam03;

public class ButtonExmaple {

    public static void main(String[] args) {
        //OK 버튼 생성
        Button btnOK = new Button();

        //ok 버튼 클릭 이벤트를 처리할 ClickListender 구현 클래스
        class OKListener implements Button.ClickListener {

            @Override
            public void onClick() {
                System.out.println("OK 버튼을 클릭했습니다.");
            }
        }

        //ok버튼 객체에 ClickListener 구현 객체 주입
        btnOK.setClickListener(new OKListener());

        //ok 버튼 클릭하기
        btnOK.click();

        Button btnCancel = new Button();

        //Cancel 버튼 클릭 이벤트를 처리할 ClickListener 구현 클래스
        class CancelListener implements Button.ClickListener {

            @Override
            public void onClick() {
                System.out.println("Cancle 버튼을 클릭했습니다.");
            }
        }

        btnCancel.setClickListener(new CancelListener());

        btnCancel.click();
    }
}
