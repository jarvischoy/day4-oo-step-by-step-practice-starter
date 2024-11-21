package oo;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Klass {
    private int number;
    private int leaderId;
    private List<Student> students;
    private List<Teacher> teachers;
    private Person attachedPerson;

    public Klass(int number) {
        this.number = number;
        this.students = new ArrayList<>();
        this.teachers = new ArrayList<>();
    }

    public Person getAttachedPerson() {
        return attachedPerson;
    }

    public void addStudent(Student student) {
        this.students.add(student);
        student.join(this);
    }

    public void addTeacher(Teacher teacher) {
        this.teachers.add(teacher);
        teacher.assignTo(this);
    }

    public List<Student> getStudents() {
        return students;
    }

    public List<Teacher> getTeachers() {
        return teachers;
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