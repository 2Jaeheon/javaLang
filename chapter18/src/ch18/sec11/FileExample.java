package ch18.sec11;
import java.io.*;
import java.text.SimpleDateFormat;
import java.util.*;
public class FileExample {

    public static void main(String[] args) throws Exception{
        File dir = new File("C:/Temp/images");
        File file1 = new File("C:/Temp/file1.txt");
        File file2 = new File("C:/Temp/file2.txt");
        File file3 = new File("C:/Temp/file3.txt");

        if(dir.exists() == false) dir.mkdirs();
        if(file1.exists() == false) file1.createNewFile();
        if(file2.exists() == false) file2.createNewFile();
        if(file3.exists() == false) file3.createNewFile();

        //Temp 폴더의 내용을 출력
        File temp = new File("C:/Temp");
        File[] contents = temp.listFiles();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd a HH:mm");
        for(File file: contents) {
            System.out.print(sdf.format(new Date(file.lastModified())));
            if(file.isDirectory()) {
                System.out.print("\t<DIR>\t\t" + file.getName());
            } else {
                System.out.print("\t\t\t" + file.length() + "\t" + file.getName());
            }
            System.out.println();
        }
    }
}
