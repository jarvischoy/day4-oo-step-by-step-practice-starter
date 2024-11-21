package oo;

public class Teacher extends Person {

    public Teacher(int id, String name, int age) {
        super(id, name, age);
    }

    @Override
    public String introduce() {
        return super.introduce().concat(" I am a teacher.");
    }
}
