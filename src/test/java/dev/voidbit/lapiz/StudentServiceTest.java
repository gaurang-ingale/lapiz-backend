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
public class StudentServiceTest {

    @Mock
    private StudentRepository studentRepository;

    private StudentService studentService;

    @BeforeEach
    public void testSetUp(){
        studentService = new StudentService(studentRepository);
    }

    @Test
    public void getStudentById_returnsStudent(){
        given(studentRepository.getStudentById(anyLong()))
                .willReturn(new Student("Abra Cadabra"));

        Assertions.assertThat(studentService.getStudentById(1L).getName()).isEqualTo("Abra Cadabra");
    }

}
