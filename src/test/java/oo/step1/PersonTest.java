package oo.step1;

import oo.Person;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class PersonTest {

    @Test
    public void should_return_message_with_name_and_age_when_introduce_given_person() {
        Person tom = new Person(1, "Tom", 18);
        String introduce = tom.introduce();

        assertThat(introduce).isEqualTo("My name is Tom. I am 18 years old.");
    }

    @Test
    public void should_return_message_with_name_and_age_when_introduce_given_another_person() {
        Person jim = new Person(2, "Jim", 19);
        String introduce = jim.introduce();

        assertThat(introduce).isEqualTo("My name is Jim. I am 19 years old.");
    }

    @Test
    public void should_return_true_when_equals_given_two_people_with_same_id() {
        Person person1 = new Person(1, "Tom", 18);
        Person person2 = new Person(1, "Tommy", 18);

        assertThat(person1).isEqualTo(person2);
    }

    @Test
    public void should_return_false_when_equals_given_two_people_with_different_id() {
        Person person1 = new Person(1, "Tom", 18);
        Person person2 = new Person(2, "Tom", 18);

        assertThat(person1).isNotEqualTo(person2);
    }

}
