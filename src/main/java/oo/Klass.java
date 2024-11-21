package oo;

import java.util.Objects;

public class Klass {
    private int number;
    private int leaderId;

    public Person getAttachedPerson() {
        return attachedPerson;
    }

    private Person attachedPerson;

    public Klass(int number) {
        this.number = number;
    }

    public void assignLeader(Student student) {
        if (!student.isIn(this)) {
            System.out.println("It is not one of us.");
            return;
        }

        if (attachedPerson != null) {
            attachedPerson.notifyAssignLeader(student, this);
        }


        this.leaderId = student.hashCode();
    }

    public boolean isLeader(Student student) {
        return student.hashCode() == this.leaderId;
    }

    public void attach(Person person) {
        attachedPerson = person;
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

    public int getNumber() {
        return number;
    }
}
