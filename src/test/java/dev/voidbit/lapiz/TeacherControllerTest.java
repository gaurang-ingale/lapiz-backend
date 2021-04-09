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
@WebMvcTest(TeacherController.class)
public class TeacherControllerTest {
    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private TeacherService teacherService;

    @Test
    public void getTeacherById_returnsTeacher() throws Exception{
        //arrange
        given(teacherService.getTeacherById(anyLong()))
                .willReturn(new Teacher(1L, "Merlin Magic"));
        //act and assert
        mockMvc.perform(MockMvcRequestBuilders.get("/teacher/1"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("name").value("Merlin Magic"))
                .andExpect(jsonPath("id").value(1L));
    }

    @Test
    public void getTeacherById_notFound() throws Exception{
        //arrange
        given(teacherService.getTeacherById(anyLong()))
                .willThrow(new TeacherNotFoundException());

        //act and assert
        mockMvc.perform(MockMvcRequestBuilders.get("/teacher/1"))
                .andExpect(status().isNotFound());
    }
}
