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
public class TeacherServiceTest {
    @Mock
    private TeacherRepository teacherRepository;

    private TeacherService teacherService;

    @BeforeEach
    private void beforeEach(){
        teacherService = new TeacherService(this.teacherRepository);
    }

    @Test
    public void getTeacherById_returnsTeacher() throws Exception{
        //arrange
        given(teacherRepository.getTeacherById(anyLong()))
                .willReturn(new Teacher(1L, "Merlin Magic"));
        //act
        Teacher teacher = teacherService.getTeacherById(1L);
        //assert
        Assertions.assertThat(teacher).isNotNull();
        Assertions.assertThat(teacher.getName()).isEqualTo("Merlin Magic");
        Assertions.assertThat(teacher.getId()).isEqualTo(1L);
    }

    @Test
    public void getTeacherById_notFound(){
        //act and assert
        org.junit.jupiter.api.Assertions.assertThrows(TeacherNotFoundException.class, () -> {
            teacherService.getTeacherById(1L);
        });
    }
}
