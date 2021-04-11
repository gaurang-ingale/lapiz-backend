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
}