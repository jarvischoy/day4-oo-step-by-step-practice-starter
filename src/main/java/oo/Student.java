package oo;

public class Student extends Person {
    private Klass klass;

    public Student(int id, String name, int age) {
        super(id, name, age);
    }

    public void join(Klass klass) {
        this.klass = klass;
    }

    public boolean isIn(Klass klass) {
        return klass.equals(this.klass);
    }

    @Override
    public String introduce() {
        return super.introduce().concat(String.format(" I am a student. I am in class %d.", klass.getNumber()));
    }
}
