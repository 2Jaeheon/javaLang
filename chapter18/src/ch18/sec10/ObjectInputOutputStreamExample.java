package ch18.sec10;
import java.io.*;
import java.util.Arrays;

public class ObjectInputOutputStreamExample {

    public static void main(String[] args) throws Exception {
        //FileOutputStream 에 ObjectOutputStream 연결
        FileOutputStream fos = new FileOutputStream("C:/Temp/Object.dat");
        ObjectOutputStream oos = new ObjectOutputStream(fos);

        Member m1 = new Member("fall", "단풍이");
        Product p1 = new Product("노트북", 150000);
        int[] arr1 = {1, 2, 3};

        //객체를 역직렬화해서 파일에 저장
        oos.writeObject(m1);
        oos.writeObject(p1);
        oos.writeObject(arr1);

        oos.flush();
        oos.close();
        fos.close();

        //FileInputStream 에 ObjectInputStream 연결
        FileInputStream fis = new FileInputStream("C:/Temp/Object.dat");
        ObjectInputStream ois = new ObjectInputStream(fis);

        //객체를 역직렬화해서 객체로 복원
        Member m2 = (Member) ois.readObject();
        Product p2 = (Product) ois.readObject();
        int[] arr2 = (int[]) ois.readObject();

        System.out.println(m2);
        System.out.println(p2);
        System.out.println(Arrays.toString(arr2));

    }
}
