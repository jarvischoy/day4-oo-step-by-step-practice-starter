package oo;

import java.util.ArrayList;
import java.util.List;

public class School {
    private List<Klass> klasses;

    public School() {
        this.klasses = new ArrayList<>();
    }

    public List<Klass> getKlasses() {
        return klasses;
    }

    public void addKlass(Klass klass) {
        this.klasses.add(klass);
    }

    public void startSchool() {
        for (Klass klass : klasses) {
            klass.getTeachers().stream()
                    .map(Teacher::introduce)
                    .forEach(System.out::println);
            klass.getStudents().stream()
                    .map(Student::introduce)
                    .forEach(System.out::println);
        }
    }
}
