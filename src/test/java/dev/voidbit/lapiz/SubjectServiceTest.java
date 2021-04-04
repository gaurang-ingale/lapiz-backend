package dev.voidbit.lapiz;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.BDDMockito.given;

@ExtendWith(MockitoExtension.class)
public class SubjectServiceTest {

    @Mock
    private SubjectRepository subjectRepository;

    private SubjectService subjectService;

    @BeforeEach
    private void beforeEach(){
        subjectService = new SubjectService(subjectRepository);
    }

    @Test
    public void getSubjectById_returnsSubject() throws Exception{
        //arrange
        given(subjectRepository.getSubjectById(anyLong()))
                .willReturn(new Subject("Computer Science"));

        //act and assert
        assertThat(subjectService.getSubjectById(1L).getName())
                .isEqualTo("Computer Science");
    }
}
