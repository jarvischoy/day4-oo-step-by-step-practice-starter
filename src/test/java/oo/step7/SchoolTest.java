package oo.step7;

import static org.assertj.core.api.Assertions.assertThat;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.List;
import oo.Klass;
import oo.School;
import oo.Student;
import oo.Teacher;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class SchoolTest {

    private ByteArrayOutputStream outContent = new ByteArrayOutputStream();

    @BeforeEach
    public void setup() {
        System.setOut(new PrintStream(outContent));
    }

    private String systemOut() {
        return outContent.toString();
    }

    @Test
    public void should_add_klass_to_school() {
        School school = new School();
        Klass klass = new Klass(1);
        school.addKlass(klass);

        assertThat(school.getKlasses()).contains(klass);
    }

    @Test
    public void should_start_school_and_introduce_all_teachers_and_students() {
        School school = new School();
        Klass klass1 = new Klass(1);
        Klass klass2 = new Klass(2);

        Teacher teacher1 = new Teacher(1, "Mr. Smith", 30);
        Teacher teacher2 = new Teacher(2, "Ms. Johnson", 28);
        Student student1 = new Student(1, "Alice", 15);
        Student student2 = new Student(2, "Bob", 16);

        klass1.addTeacher(teacher1);
        klass1.addStudent(student1);
        klass2.addTeacher(teacher2);
        klass2.addStudent(student2);

        school.addKlass(klass1);
        school.addKlass(klass2);

        school.startSchool();

        String expectedOutput = """
                My name is Mr. Smith. I am 30 years old. I am a teacher. I teach Class 1.
                My name is Alice. I am 15 years old. I am a student. I am in class 1.
                My name is Ms. Johnson. I am 28 years old. I am a teacher. I teach Class 2.
                My name is Bob. I am 16 years old. I am a student. I am in class 2.
                """;

        assertThat(systemOut()).isEqualToNormalizingNewlines(expectedOutput);
    }
}
