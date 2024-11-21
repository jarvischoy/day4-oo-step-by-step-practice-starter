package oo;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Teacher extends Person {

    private List<Klass> klasses;

    public Teacher(int id, String name, int age) {
        super(id, name, age);
        klasses = new ArrayList<>();
    }

    public void assignTo(Klass klass) {
        klasses.add(klass);
    }

    public boolean belongsTo(Klass klass) {
        return klasses.contains(klass);
    }

    public boolean isTeaching(Student student) {
        return klasses.stream()
                .anyMatch(student::isIn);
    }

    @Override
    public String introduce() {
        String teachingClasses = klasses.stream()
                .map(klass -> klass.getNumber() + "")
                .collect(Collectors.joining(", "));

        return super.introduce()
                .concat(String.format(" I am a teacher. I teach Class %s.", teachingClasses));
    }
}
