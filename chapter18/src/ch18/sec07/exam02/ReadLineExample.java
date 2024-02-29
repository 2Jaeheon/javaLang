package ch18.sec07.exam02;

import java.io.*;

public class ReadLineExample {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(
            new FileReader(
                "C:/Programming/ProgrammingLanguage/Java/javaLang/chapter18/src/ch18/sec07/exam02/ReadLineExample.java")
            //FileReader에 BufferedReader 보조 스트림 연결
        );

        int lineNo = 1;
        while (true) {
            String str = br.readLine();
            if (str == null) {
                break;
            }
            System.out.println(lineNo + "\t" + str);
            lineNo++;
        }
        br.close();
    }
}
