package oo.step3;

import oo.Klass;
import oo.Student;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class StudentTest {

    @Test
    public void should_return_false_when_isIn_given_student_has_joined_a_class() {
        Student tom = new Student(1, "Tom", 18);
        Klass klass = new Klass(1);

        boolean isIn = tom.isIn(klass);
        assertThat(isIn).isFalse();
    }

    @Test
    public void should_return_true_when_isIn_given_student_has_not_joined_a_class() {
        Student tom = new Student(1, "Tom", 18);
        Klass klass = new Klass(1);
        tom.join(klass);

        boolean isIn = tom.isIn(klass);
        assertThat(isIn).isTrue();
    }

    @Test
    public void Should_only_in_the_recently_joined_class_when_isIn_given_student_join_two_classes_in_turn() {
        Student tom = new Student(1, "Tom", 18);
        Klass klass1 = new Klass(1);
        Klass klass2 = new Klass(2);
        tom.join(klass1);
        tom.join(klass2);

        boolean isInKlass1 = tom.isIn(klass1);
        boolean isInKlass2 = tom.isIn(klass2);

        assertThat(isInKlass1).isFalse();
        assertThat(isInKlass2).isTrue();
    }

    @Test
    public void should_return_message_with_name_age_and_class_when_introduce_given_student_is_in_a_class() {
        Student tom = new Student(1, "Tom", 18);
        Klass klass = new Klass(1);
        tom.join(klass);

        String introduce = tom.introduce();

        assertThat(introduce).isEqualTo("My name is Tom. I am 18 years old. I am a student. I am in class 1.");
    }
}
