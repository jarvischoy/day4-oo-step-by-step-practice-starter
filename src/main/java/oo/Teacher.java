package oo;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Teacher extends Person {

    private List<Klass> klasses;

    public Teacher(int id, String name, int age) {
        super(id, name, age);
        this.klasses = new ArrayList<>();
    }

    public void assignTo(Klass klass) {
        this.klasses.add(klass);
    }

    public boolean belongsTo(Klass klass) {
        return this.klasses.contains(klass);
    }

    public boolean isTeaching(Student student) {
        return klasses.stream()
                .anyMatch(student::isIn);
    }

    @Override
    public String introduce() {
        String teachingClasses = this.klasses.stream()
                .map(klass -> klass.getNumber() + "")
                .collect(Collectors.joining(", "));

        return super.introduce()
                .concat(" I am a teacher. ")
                .concat(String.format("I teach Class %s.", teachingClasses));
    }
}
