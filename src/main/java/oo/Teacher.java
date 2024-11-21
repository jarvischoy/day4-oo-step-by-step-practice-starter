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
    public void notifyAssignLeader(Person person, Klass klass) {
        System.out.printf("I am %s, teacher of Class %d. I know %s become Leader.%n", klass.getAttachedPerson().getName(), klass.getNumber(), person.getName());
    }

    @Override
    public String introduce() {
        String teachingClasses = this.klasses.stream()
                .map(klass -> klass.getNumber() + "")
                .collect(Collectors.joining(", "));

        String introduction = super.introduce()
                .concat(" I am a teacher.");

        if (teachingClasses.isEmpty()) {
            return introduction;
        }

        return introduction.concat(String.format(" I teach Class %s.", teachingClasses));
    }
}
