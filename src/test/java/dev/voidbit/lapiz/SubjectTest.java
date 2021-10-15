package dev.voidbit.lapiz;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.util.ArrayList;

public class SubjectTest {
    @Test
    public void subject_hasAName() throws Exception{
        Assertions.assertThat(Subject.class).hasDeclaredFields("name");
        Assertions.assertThat(new Subject("Computer Science").getName()).hasSameClassAs(new String());
    }

    @Test
    public void subject_hasTeachers() throws Exception{
        Assertions.assertThat(Subject.class).hasDeclaredFields("teachers");
        Assertions.assertThat(new Subject().getTeachers()).hasSameClassAs(new ArrayList<Teacher>());
    }

    @Test
    public void subject_hasStudents() throws Exception{
        Assertions.assertThat(Subject.class).hasDeclaredFields("students");
        Assertions.assertThat(new Subject().getStudents()).hasSameClassAs(new ArrayList<Student>());
    }

    @Test
    public void subject_hasADescription() throws Exception {
        Assertions.assertThat(Subject.class).hasDeclaredFields("description");
        Assertions.assertThat(new Subject("Computer Science", "The study of computers and mathematics")
                .getDescription()).hasSameClassAs(new String());
    }

    @Test
    public void subject_hasAListOfTopics() throws Exception{
        Assertions.assertThat(Subject.class).hasDeclaredFields("topics");
        Assertions.assertThat(new Subject().getTopics()).hasSameClassAs(new ArrayList<Topic>());
    }

    @Test
    public void subjects_topicsCannotBeReinitialised() throws Exception{
        try{
            Assertions.assertThat(Subject.class).hasDeclaredMethods("setTopics");
        }catch(Exception e){
            return;
        }
        Assertions.fail("Subject should not have a setTopics method!");
    }

    @Test
    public void subjects_topicsShouldBeFinal() throws Exception{
        Field topicsField = Subject.class.getDeclaredField("topics");
        Assertions.assertThat(Modifier.isFinal(topicsField.getModifiers())).isTrue();
    }

    @Test
    public void subjects_studentsCannotBeReinitialised() throws Exception{
        try{
            Assertions.assertThat(Subject.class).hasDeclaredMethods("setStudents");
        }catch (Exception e){
            return;
        }
        Assertions.fail("Subject should not have a setStudents method!");
    }

    @Test
    public void subjects_studentsShouldBeFinal() throws Exception{
        Field studentsField = Subject.class.getDeclaredField("students");
        Assertions.assertThat(Modifier.isFinal(studentsField.getModifiers())).isTrue();
    }

    @Test
    public void subjects_teachersCannotBeReinitialised() throws Exception{
        try{
            Assertions.assertThat(Subject.class).hasDeclaredMethods("setTeachers");
        }catch(Exception e){
            return;
        }
        Assertions.fail("Subject should not have a setTeachers method!");
    }

    @Test
    public void subjects_teachersShouldBeFinal() throws Exception{
        Field teachersField = Subject.class.getDeclaredField("teachers");
        Assertions.assertThat(Modifier.isFinal(teachersField.getModifiers())).isTrue();
    }
}
