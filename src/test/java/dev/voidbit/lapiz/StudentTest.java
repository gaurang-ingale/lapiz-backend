package dev.voidbit.lapiz;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

public class StudentTest {
    @Test
    public void student_hasAFirstName() throws Exception{
        Assertions.assertThat(Student.class).hasDeclaredFields("firstName");
        Assertions.assertThat(new Student("some", "thing").getFirstName()).hasSameClassAs(new String());
    }

    @Test
    public void student_hasALastName() throws Exception{
        Assertions.assertThat(Student.class).hasDeclaredFields("lastName");
        Assertions.assertThat(new Student("some", "thing").getLastName()).hasSameClassAs(new String());
    }

    @Test
    public void firstName_isTheFirstSliceOfThe_name() throws Exception{
        Student student = new Student("Abra Cadabra");
        Assertions.assertThat(student.getFirstName()).isNotNull();
        Assertions.assertThat(student.getFirstName()).isEqualTo("Abra");
    }

    @Test
    public void lastName_isTheLastSliceOfThe_name() throws Exception{
        Student student = new Student("Abra Cadabra Simsalabim");
        Assertions.assertThat(student.getLastName()).isNotNull();
        Assertions.assertThat(student.getLastName()).isEqualTo("Simsalabim");
    }

    @Test
    public void name_is_lastNameAppendedToFirstNameWithASpace() throws Exception{
        Student student = new Student("Abra", "Cadabra");
        Assertions.assertThat(student.getName()).isNotNull();
        Assertions.assertThat(student.getName()).isEqualTo("Merlin Magic");
    }
}
