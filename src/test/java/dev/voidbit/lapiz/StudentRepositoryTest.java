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
public class StudentRepositoryTest {

    @Autowired
    private StudentRepository studentRepository;

    @Autowired
    private TestEntityManager testEntityManager;

    @Test
    @DirtiesContext
    public void getStudentById_returnsStudent(){
        //arrange
        Student tmp = testEntityManager.persistFlushFind(new Student("Abra Cadabra"));
        testEntityManager.detach(tmp);

        //act
        Student student = studentRepository.getStudentById(1L);

        //assert
        Assertions.assertThat(student.getName()).isEqualTo("Abra Cadabra");
        Assertions.assertThat(student.getId()).isEqualTo(1L);
    }

    @Test
    @DirtiesContext
    public void getStudentById_notFound(){
        //act
        Student student = studentRepository.getStudentById(1L);

        //assert
        Assertions.assertThat(student).isEqualTo(null);
    }
}
