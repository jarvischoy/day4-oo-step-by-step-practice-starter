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
        String classSpeech = String.format(
                this.klass.isLeader(this) ?
                        "I am the leader of class %d."
                        : "I am in class %d.",
                this.klass.getNumber());

        return super.introduce()
                .concat(" I am a student. ")
                .concat(classSpeech);
    }
}
