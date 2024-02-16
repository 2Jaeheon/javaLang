package ch16.sec03;

public class Person {

    public void action1(Workable workable) {
        workable.work("Tom", "programmer");
    }

    public void action2(Speakable speakable) {
        speakable.speak("Hello, world!");
    }
}
