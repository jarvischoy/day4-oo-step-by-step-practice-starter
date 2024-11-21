package oo.step2;

import oo.Person;
import oo.Student;
import oo.Teacher;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class PersonTest {

    @Test
    public void should_return_message_with_name_and_age_when_introduce_given_student() {
        Person tom = new Student(1, "Tom", 18);
        String introduce = tom.introduce();

        assertThat(introduce).isEqualTo("My name is Tom. I am 18 years old. I am a student.");
    }

    @Test
    public void should_return_message_with_name_and_age_when_introduce_given_teacher() {
        Person jerry = new Teacher(1, "Jerry", 21);
        String introduce = jerry.introduce();

        assertThat(introduce).isEqualTo("My name is Jerry. I am 21 years old. I am a teacher.");
    }
}
