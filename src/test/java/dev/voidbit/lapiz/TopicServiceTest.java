package dev.voidbit.lapiz;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.BDDMockito.given;

@ExtendWith(MockitoExtension.class)
public class TopicServiceTest {
    @Mock
    private TopicRepository topicRepository;

    private TopicService topicService;

    @BeforeEach
    private void beforeEach(){
        topicService = new TopicService(this.topicRepository);
    }

    @Test
    public void getTopicById_returnsTopic(){
        //arrange
        given(topicRepository.getTopicById(anyLong()))
                .willReturn(new Topic(1L));

        //act
        Topic topic = topicService.getTopicById(1L);

        //assert
        Assertions.assertThat(topic).isNotNull();
        Assertions.assertThat(topic.getId()).isEqualTo(1L);
    }

    @Test
    public void getTopicById_notFound(){
        //arrange
        given(topicRepository.getTopicById(anyLong()))
                .willThrow(new TopicNotFoundException());

        //act and assert
        org.junit.jupiter.api.Assertions.assertThrows(TopicNotFoundException.class,
                () -> {
                    topicService.getTopicById(1L);
                });
    }

}
