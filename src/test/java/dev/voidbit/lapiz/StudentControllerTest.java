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
@WebMvcTest(StudentController.class)
public class StudentControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private StudentService studentService;

    @Test
    public void getStudentById_returnsStudentByID() throws Exception{
        given(studentService.getStudentById(anyLong())).willReturn(new Student("Abra Cadabra"));

        mockMvc.perform(MockMvcRequestBuilders.get("/student/1"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("name").value("Abra Cadabra"));
                //.andExpect(jsonPath("id").value(1L));
    }

    @Test
    public void getStudentById_notFound() throws Exception{
        given(studentService.getStudentById(anyLong())).willThrow(new StudentNotFoundException());

        mockMvc.perform(MockMvcRequestBuilders.get("/student/1"))
                .andExpect(status().isNotFound());
    }

}
