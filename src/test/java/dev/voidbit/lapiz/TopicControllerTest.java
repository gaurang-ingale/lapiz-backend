package dev.voidbit.lapiz;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.BDDMockito.given;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@ExtendWith(SpringExtension.class)
@WebMvcTest(TopicController.class)
public class TopicControllerTest {
    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private TopicService topicService;

    @Test
    public void getTopicId_returnsTopic() throws Exception{
        //arrange
        given(topicService.getTopicById(anyLong()))
                .willReturn(new Topic(1L));
        //act and assert
        mockMvc.perform(MockMvcRequestBuilders.get("/topic/1"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("id").value(1L));
    }

    @Test
    public void getTopicById_notFound() throws Exception{
        //arrange
        given(topicService.getTopicById(anyLong()))
                .willThrow(new TopicNotFoundException());

        //act and assert
        mockMvc.perform(MockMvcRequestBuilders.get("/topic/1"))
                .andExpect(status().isNotFound());
    }
}
