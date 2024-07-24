package sec02.exam02;

public class ButtonExample {

    public static void main(String[] args) {
        Button btnOK = new Button();

        btnOK.setClickListener(() -> {
            System.out.println("OK 버튼을 클릭하였습니다.");
        });

        btnOK.click();

        Button btnCancel = new Button();

        //Cancel버튼 객체에 람다식 주입
        btnCancel.setClickListener(() -> {
            System.out.println("Cancel 버튼을 클릭하였습니다.");
        });
        //클릭하기
        btnCancel.click();
    }
}
