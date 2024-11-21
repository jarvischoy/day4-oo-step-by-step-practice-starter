package oo;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class Klass {
    private int number;
    private int leaderId;
    private List<Person> people;
    private List<Observer> observers;

    public Klass(int number) {
        this.number = number;
        this.people = new ArrayList<>();
        this.observers = new ArrayList<>();
    }

    public void addPeople(Person person) {
        this.people.add(person);
        if (person instanceof Student) {
            ((Student) person).join(this);
            this.observers.add((Student) person);
        } else if (person instanceof Teacher) {
            ((Teacher) person).assignTo(this);
            this.observers.add((Teacher) person);
        }
    }

    public List<Student> getStudents() {
        return people.stream()
                .filter(person -> person instanceof Student)
                .map(person -> (Student) person)
                .collect(Collectors.toList());
    }

    public List<Teacher> getTeachers() {
        return people.stream()
                .filter(person -> person instanceof Teacher)
                .map(person -> (Teacher) person)
                .collect(Collectors.toList());
    }


    public void assignLeader(Student student) {
        if (!student.isIn(this)) {
            System.out.println("It is not one of us.");
            return;
        }

        this.leaderId = student.hashCode();
        notifyObservers(student);
    }

    public boolean isLeader(Student student) {
        return student.hashCode() == this.leaderId;
    }

    public void attach(Observer observer) {
        this.observers.add(observer);
    }

    private void notifyObservers(Student leader) {
        for (Observer observer : observers) {
            observer.update(leader, this);
        }
    }

    public int getNumber() {
        return number;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Klass klass = (Klass) o;
        return number == klass.number;
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(number);
    }
}