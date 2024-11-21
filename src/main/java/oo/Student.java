package oo;

public class Student extends Person {

    public Student(int id, String name, int age) {
        super(id, name, age);
    }

    @Override
    public String introduce() {
        return super.introduce().concat(" I am a student.");
    }
}
