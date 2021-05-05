package dev.voidbit.lapiz;

import org.assertj.core.api.Assert;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

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
}
