package dev.voidbit.lapiz;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

public class TeacherTest {
    @Test
    public void teacher_hasAFirstName() throws Exception{
        Assertions.assertThat(Teacher.class).hasDeclaredFields("firstName");
        Assertions.assertThat(new Teacher("some", "teacher").getFirstName())
                .hasSameClassAs(new String());
    }

    @Test
    public void teacher_hasALastName() throws Exception{
        Assertions.assertThat(Teacher.class).hasDeclaredFields("lastName");
        Assertions.assertThat(new Teacher("some", "teacher").getLastName())
                .hasSameClassAs(new String());
    }

    @Test
    public void firstName_isTheFirstSliceOfThe_name() throws Exception{
        Teacher teacher = new Teacher("Merlin Magic");
        Assertions.assertThat(teacher.getFirstName()).isNotNull();
        Assertions.assertThat(teacher.getFirstName()).isEqualTo("Merlin");
    }

    @Test
    public void lastName_isTheLastSliceOfThe_name() throws Exception{
        Teacher teacher = new Teacher("Merlin Wizard Magic");
        Assertions.assertThat(teacher.getLastName()).isNotNull();
        Assertions.assertThat(teacher.getLastName()).isEqualTo("Magic");
    }

    @Test
    public void name_is_lastNameAppendedToFirstNameWithASpace() throws Exception{
        Teacher teacher = new Teacher("Merlin", "Magic");
        Assertions.assertThat(teacher.getName()).isNotNull();
        Assertions.assertThat(teacher.getName()).isEqualTo("Merlin Magic");
    }

    @Test
    public void settersForNames_doNotDevelopInconsistencies() throws Exception{
        Teacher teacher = new Teacher("Merlin", "Magic");
        teacher.setName("wrong name");
        Assertions.assertThat(teacher.getFirstName()).isEqualTo("wrong");
        Assertions.assertThat(teacher.getLastName()).isEqualTo("name");

        teacher = new Teacher("Merlin Magic");
        teacher.setFirstName("wrong");
        teacher.setLastName("name");
        Assertions.assertThat(teacher.getName()).isEqualTo("wrong name");
    }
}