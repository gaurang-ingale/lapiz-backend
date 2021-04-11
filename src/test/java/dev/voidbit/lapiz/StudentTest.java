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
}
