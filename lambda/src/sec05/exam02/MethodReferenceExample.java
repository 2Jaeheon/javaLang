package sec05.exam02;

public class MethodReferenceExample {

    public static void main(String[] args) {
        Person person = new Person();
        //person.ordering((s, str) -> s.compareToIgnoreCase(str));
        person.ordering(String::compareToIgnoreCase);
    }
}
