package ch07.sec10.exam01;

public class SmartPhone extends Phone{
    SmartPhone(String owner){
        //Phone 생성자를 호출
        super(owner);
    }

    //method
    void internetSearch() {
        System.out.println("인터넷 검색을 합니다.");
    }
}
