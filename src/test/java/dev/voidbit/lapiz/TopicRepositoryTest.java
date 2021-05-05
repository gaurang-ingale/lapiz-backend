package dev.voidbit.lapiz;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.Objects;

@ExtendWith(SpringExtension.class)
@DataJpaTest
public class TopicRepositoryTest {
    @Autowired
    private TopicRepository topicRepository;

    @Autowired
    private TestEntityManager testEntityManager;

    @Test
    @DirtiesContext
    public void getTopicById_returnsId(){
        //arrange
        Topic topic = new Topic();
        testEntityManager.persistFlushFind(topic);
        //act
        Topic response = topicRepository.getTopicById(1L);
        //assert
        Assertions.assertThat(response).isNotNull();
        Assertions.assertThat(Objects.deepEquals(topic, response));
    }

    @Test
    @DirtiesContext
    public void getTopicById_notFound() throws Exception{
        //act
        Topic response = topicRepository.getTopicById(1L);
        //assert
        Assertions.assertThat(response).isNull();
    }
}
