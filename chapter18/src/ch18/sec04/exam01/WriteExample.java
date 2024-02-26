package ch18.sec04.exam01;

import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;

public class WriteExample {

    public static void main(String[] args) {
        try {
            //문자 기반 출력 스트림 생성
            Writer writer = new FileWriter("C:/Temp/test.txt");

            char a = 'A';
            writer.write(a);
            char b = 'B';
            writer.write(b);

            char[] arr = {'a', 'b', 'c'};
            writer.write(arr);

            writer.write("FGH");

            writer.flush();

            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
