package dev.voidbit.lapiz;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ExtendWith(SpringExtension.class)
@DataJpaTest
public class TeacherRepositoryTest {
    @Autowired
    private TeacherRepository teacherRepository;

    @Autowired
    private TestEntityManager testEntityManager;

    @Test
    @DirtiesContext
    public void getTeacherById_returnsTeacher() throws Exception{
        //arrange
        Teacher tmp = testEntityManager.persistFlushFind(new Teacher(1L, "Merlin Magic"));
        testEntityManager.detach(tmp);

        //act
        Teacher teacher = teacherRepository.getTeacherById(1L);

        //assert
        Assertions.assertThat(teacher.getId()).isEqualTo(1L);
        Assertions.assertThat(teacher.getName()).isEqualTo("Merlin Magic");
    }

    @Test
    @DirtiesContext
    public void getTeacherById_notFound() throws Exception{
        //arrange
        testEntityManager.remove(new Teacher(1L, "Merlin Magic"));
        //act
        Teacher teacher = teacherRepository.getTeacherById(1L);
        //assert
        Assertions.assertThat(teacher).isNull();
    }
}
