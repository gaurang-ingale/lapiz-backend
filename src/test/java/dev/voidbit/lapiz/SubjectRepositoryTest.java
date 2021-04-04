package dev.voidbit.lapiz;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import static org.assertj.core.api.Assertions.assertThat;

@ExtendWith(SpringExtension.class)
@DataJpaTest
public class SubjectRepositoryTest {

    @Autowired
    private SubjectRepository subjectRepository;

    @Autowired
    private TestEntityManager testEntityManager;

    @Test
    @DirtiesContext
    public void getSubjectById_returnsSubject() throws Exception{
        //arrange
        Subject subject = testEntityManager.persistFlushFind(new Subject("Computer Science"));
        testEntityManager.detach(subject);

        //act
        Subject response = subjectRepository.getSubjectById(1L);

        //assert
        assertThat(response.getName()).isEqualTo("Computer Science");
        assertThat(response.getId()).isEqualTo(1L);
    }

    @Test
    @DirtiesContext
    public void getSubjectById_notFound() throws Exception{
        //act
        Subject subject = subjectRepository.getSubjectById(1L);

        //assert
        assertThat(subject).isNull();
    }
}
