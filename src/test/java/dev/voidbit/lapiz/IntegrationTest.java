package dev.voidbit.lapiz;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.annotation.DirtiesContext;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class IntegrationTest {
    @Autowired
    private TestRestTemplate restTemplate;

    @Autowired
    private StudentRepository studentRepository;

    @Autowired
    private SubjectRepository subjectRepository;

    @Autowired
    private TeacherRepository teacherRepository;

    @Test
    @DirtiesContext
    public void getStudentByID_returnsStudent() throws Exception{
        //arrange
        studentRepository.saveAndFlush(new Student(1L, "Abra Cadabra"));

        //act
        ResponseEntity<Student> response = restTemplate.getForEntity("/student/1", Student.class);

        //assert
        Assertions.assertThat(response.getStatusCode()).isEqualTo(HttpStatus.OK);
        Assertions.assertThat(response.getBody().getName()).isEqualTo("Abra Cadabra");
        Assertions.assertThat(response.getBody().getId()).isEqualTo(1L);
    }

    @Test
    @DirtiesContext
    public void getSubjectById_returnsSubject() throws Exception{
        subjectRepository.saveAndFlush(new Subject(1L, "Computer Science"));

        //act
        ResponseEntity<Subject> response = restTemplate.getForEntity("/subject/1", Subject.class);

        //assert
        Assertions.assertThat(response.getStatusCode()).isEqualTo(HttpStatus.OK);
        Assertions.assertThat(response.getBody().getName()).isEqualTo("Computer Science");
        Assertions.assertThat(response.getBody().getId()).isEqualTo(1L);
    }

    @Test
    @DirtiesContext
    public void getTeacherById_returnsTeacher() throws Exception{
        teacherRepository.saveAndFlush(new Teacher(1L, "Merlin Magic"));

        //act
        ResponseEntity<Teacher> response = restTemplate.getForEntity("/teacher/1", Teacher.class);

        Assertions.assertThat(response.getStatusCode()).isEqualTo(HttpStatus.OK);
        Assertions.assertThat(response.getBody().getName()).isEqualTo("Merlin Magic");
        Assertions.assertThat(response.getBody().getId()).isEqualTo(1L);
    }
}
