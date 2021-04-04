package dev.voidbit.lapiz;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class IntegrationTest {
    @Autowired
    private TestRestTemplate restTemplate;

    @Autowired
    private StudentRepository studentRepository;

    @AfterEach
    private void afterEach(){
        studentRepository.deleteAll();
    }

    @Test
    public void getStudentByID_returnsStudent() throws Exception{
        //arrange
        studentRepository.save(new Student(1L, "Abra Cadabra"));

        //act
        ResponseEntity<Student> response = restTemplate.getForEntity("/student/1", Student.class);

        //assert
        Assertions.assertThat(response.getStatusCode()).isEqualTo(HttpStatus.OK);
        Assertions.assertThat(response.getBody().getName()).isEqualTo("Abra Cadabra");
        Assertions.assertThat(response.getBody().getId()).isEqualTo(1L);
    }

    @Test
    public void getSubjectById() throws Exception{
        //arrange

        //act
        ResponseEntity<Subject> response = restTemplate.getForEntity("/subject/1", Subject.class);

        //assert
        Assertions.assertThat(response.getStatusCode()).isEqualTo(HttpStatus.OK);
        Assertions.assertThat(response.getBody().getName()).isEqualTo("Computer Science");
        Assertions.assertThat(response.getBody().getId()).isEqualTo(1L);
    }
}
