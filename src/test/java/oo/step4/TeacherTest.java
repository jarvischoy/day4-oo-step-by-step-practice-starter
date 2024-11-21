package oo.step4;

import oo.Klass;
import oo.Student;
import oo.Teacher;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class TeacherTest {

    @Test
    public void should_return_false_when_belongsTo_given_teacher_does_not_teach_the_class() {
        Teacher jerry = new Teacher(1, "Jerry", 21);
        Klass klass = new Klass(1);

        boolean belongsTo = jerry.belongsTo(klass);

        assertThat(belongsTo).isFalse();
    }

    @Test
    public void should_return_true_when_belongsTo_given_teacher_teaches_in_the_class() {
        Teacher jerry = new Teacher(1, "Jerry", 21);
        Klass klass = new Klass(1);
        jerry.assignTo(klass);

        boolean belongsTo = jerry.belongsTo(klass);

        assertThat(belongsTo).isTrue();
    }

    @Test
    public void should_all_return_true_when_belongsTo_given_teacher_teaches_multiple_classes() {
        Teacher jerry = new Teacher(1, "Jerry", 21);
        Klass klass1 = new Klass(1);
        Klass klass2 = new Klass(2);
        jerry.assignTo(klass1);
        jerry.assignTo(klass2);

        boolean belongsToKlass1 = jerry.belongsTo(klass1);
        boolean belongsToKlass2 = jerry.belongsTo(klass2);

        assertThat(belongsToKlass1).isTrue();
        assertThat(belongsToKlass2).isTrue();
    }

    @Test
    public void should_return_message_with_name_age_and_class_when_introduce_given_teacher_teaches_one_class() {
        Teacher jerry = new Teacher(1, "Jerry", 21);
        Klass klass1 = new Klass(1);
        jerry.assignTo(klass1);

        String introduce = jerry.introduce();

        assertThat(introduce).isEqualTo("My name is Jerry. I am 21 years old. I am a teacher. I teach Class 1.");
    }

    @Test
    public void should_return_message_with_name_age_and_class_when_introduce_given_teacher_teaches_multiple_classes() {
        Teacher jerry = new Teacher(1, "Jerry", 21);
        Klass klass2 = new Klass(2);
        Klass klass3 = new Klass(3);
        jerry.assignTo(klass2);
        jerry.assignTo(klass3);

        String introduce = jerry.introduce();

        assertThat(introduce).isEqualTo("My name is Jerry. I am 21 years old. I am a teacher. I teach Class 2, 3.");
    }

    @Test
    public void should_return_false_when_isTeaching_given_student_not_in_the_class_taught_by_teacher() {
        Klass klass1 = new Klass(1);
        Klass klass2 = new Klass(2);
        Student tom = new Student(1, "Tom", 18);
        tom.join(klass1);
        Teacher jerry = new Teacher(1, "Jerry", 21);
        jerry.assignTo(klass2);

        boolean isTeaching = jerry.isTeaching(tom);

        assertThat(isTeaching).isFalse();
    }

    @Test
    public void should_return_true_when_isTeaching_given_student_in_the_class_taught_by_teacher() {
        Klass klass1 = new Klass(1);
        Student tom = new Student(1, "Tom", 18);
        tom.join(klass1);
        Teacher jerry = new Teacher(1, "Jerry", 21);
        jerry.assignTo(klass1);

        boolean isTeaching = jerry.isTeaching(tom);

        assertThat(isTeaching).isTrue();
    }

    @Test
    public void should_return_true_when_isTeaching_given_student_in_any_class_taught_by_teacher() {
        Klass klass1 = new Klass(1);
        Klass klass2 = new Klass(2);
        Student tom = new Student(1, "Tom", 18);
        tom.join(klass2);
        Teacher jerry = new Teacher(1, "Jerry", 21);
        jerry.assignTo(klass1);
        jerry.assignTo(klass2);

        boolean isTeaching = jerry.isTeaching(tom);

        assertThat(isTeaching).isTrue();
    }
}
