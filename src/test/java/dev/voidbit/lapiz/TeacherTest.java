package dev.voidbit.lapiz;

import net.bytebuddy.implementation.bytecode.Throw;
import org.assertj.core.api.Assert;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.util.ArrayList;

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

    @Test
    public void teacher_hasACalendar() throws Exception{
        Assertions.assertThat(Teacher.class).hasDeclaredFields("calendar");
        Assertions.assertThat(new Teacher().getCalendar()).hasSameClassAs(new Calendar());
    }

    @Test
    public void teacher_hasSubjects() throws Exception{
        Assertions.assertThat(Teacher.class).hasDeclaredFields("subjects");
        Assertions.assertThat(new Teacher().getSubjects()).hasSameClassAs(new ArrayList<Subject>());
    }

    @Test
    public void teachers_subjectsCannotBeReinitialised() throws Exception{
        try{
            Assertions.assertThat(Teacher.class).hasDeclaredMethods("setSubjects");
        }catch(Throwable t){
            return;
        }
        Assertions.fail("Teacher should not have a setSubjects method!");
    }

    @Test
    public void teachers_subjectsShouldNotBeFinal() throws Exception{
        Field subjectsField = Teacher.class.getDeclaredField("subjects");
        Assertions.assertThat(Modifier.isFinal(subjectsField.getModifiers())).isFalse();
    }
}