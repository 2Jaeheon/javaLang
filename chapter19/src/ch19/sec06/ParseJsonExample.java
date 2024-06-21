package ch19.sec06;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
//import java.nio.charset.Charset; // 사용하지 않는 import 문은 제거할 수 있습니다.

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
// JSON 파싱을 위한 JSONParser 클래스를 추가로 import 해야 합니다.

public class ParseJsonExample {

    public static void main(String[] args) {
        JSONParser parser = new JSONParser(); // JSONParser 객체 생성

        try {
            // 파일로부터 JSON 읽기
            BufferedReader br = new BufferedReader(
                new FileReader("/Users/leejaeheon/Desktop/Programming/Temp/member.json")
            );
            String json = br.readLine();
            br.close();

            // JSON 파싱
            JSONObject root = (JSONObject) parser.parse(json); // 파싱된 값을 JSONObject로 캐스팅

            // 속성 정보 읽기
            System.out.println("id: " + (String) root.get("id"));
            System.out.println("name: " + (String) root.get("name")); // "id"를 올바른 "name"으로 수정
            System.out.println(
                "age: " + (Long) root.get("age")); // JSON에서 number는 Java에서 Long과 Double로 처리될 수 있음
            System.out.println("student: " + (Boolean) root.get("student"));

            // 객체 속성 정보 읽기
            JSONObject tel = (JSONObject) root.get("tel"); // 적절한 타입으로 캐스팅
            System.out.println("home: " + (String) tel.get("home"));
            System.out.println("mobile: " + (String) tel.get("mobile"));

            // 배열 속성 정보 읽기
            JSONArray skill = (JSONArray) root.get("skill"); // 적절한 타입으로 캐스팅
            System.out.print("skill: ");
            for (int i = 0; i < skill.size(); i++) { // length() 대신 size() 메서드 사용
                System.out.print(skill.get(i) + ", ");
            }
        } catch (IOException e) {
            e.printStackTrace();
        } catch (org.json.simple.parser.ParseException e) {
            e.printStackTrace(); // JSON 파싱 중 발생하는 예외 처리
        }
    }
}
