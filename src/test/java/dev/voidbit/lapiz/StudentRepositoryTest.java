package dev.voidbit.lapiz;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ExtendWith(SpringExtension.class)
@DataJpaTest
public class StudentRepositoryTest {

    @Autowired
    private StudentRepository studentRepository;

    @Autowired
    private TestEntityManager testEntityManager;

    @Test
    public void getStudentById_returnsStudent(){
        //arrange
        testEntityManager.persistFlushFind(new Student("Abra Cadabra"));

        //act
        Student student = studentRepository.getStudentById(1L);

        //assert
        Assertions.assertThat(student.getName()).isEqualTo("Abra Cadabra");
    }
}
