/*
package ch18.sec11;

import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class FilesExample {

    public static void main(String[] args) {
        try {
            String dat = "" +
                "id: winter\n" +
                "email: winter@mycompany.com\n" +
                "phone: 010-123-4567";

            Path path = Paths.get("C:/Temp/file.txt");

            //파일 생성 및 데이터 저장
            Files.writeString(Paths.get("C:/Temp/file.txt"), dat, Charset.forName("UTF-8"));

            //파일 정보 얻기
            System.out.println("파일 크기: " + Files.size(path));
            System.out.println("파일 유형: " + Files.probeContentType(path));

            //파일 읽기
            //String content = Files.readString(path, Charset.forName("UTF-8"));
            System.out.println(content);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
*/
