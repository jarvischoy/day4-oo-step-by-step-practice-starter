package oo;

import java.util.Objects;

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
    public void notifyAssignLeader(Person person, Klass klass) {
        System.out.printf("I am %s, student of Class %d. I know %s become Leader.%n", klass.getAttachedPerson().getName(), klass.getNumber(), person.getName());
    }

    @Override
    public String introduce() {
        String classSpeech = "";
        if (!Objects.isNull(klass)) {
            classSpeech = String.format(
                    this.klass.isLeader(this) ?
                            " I am the leader of class %d."
                            : " I am in class %d.",
                    this.klass.getNumber());
        }

        return super.introduce()
                .concat(" I am a student.")
                .concat(classSpeech);
    }
}
