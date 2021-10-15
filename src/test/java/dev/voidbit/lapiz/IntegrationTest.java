package dev.voidbit.lapiz;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.annotation.DirtiesContext;

import java.util.Objects;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@DirtiesContext
public class IntegrationTest {
    @Autowired
    private TestRestTemplate restTemplate;

    @Autowired
    private StudentRepository studentRepository;

    @Autowired
    private SubjectRepository subjectRepository;

    @Autowired
    private TeacherRepository teacherRepository;

    @Autowired
    private CalendarRepository calendarRepository;

    @Autowired
    private TopicRepository topicRepository;

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
        //arrange
        teacherRepository.saveAndFlush(new Teacher(1L, "Merlin Magic"));

        //act
        ResponseEntity<Teacher> response = restTemplate.getForEntity("/teacher/1", Teacher.class);

        //assert
        Assertions.assertThat(response.getStatusCode()).isEqualTo(HttpStatus.OK);
        Assertions.assertThat(response.getBody().getName()).isEqualTo("Merlin Magic");
        Assertions.assertThat(response.getBody().getId()).isEqualTo(1L);
    }

    @Test
    @DirtiesContext
    public void getCalendarById_returnsCalendar() throws Exception{
        calendarRepository.saveAndFlush(new Calendar());

        //act
        ResponseEntity<Calendar> response = restTemplate.getForEntity("/calendar/1", Calendar.class);

        //assert
        Assertions.assertThat(response.getStatusCode()).isEqualTo(HttpStatus.OK);
    }

    @Test
    @DirtiesContext
    public void getCalendarById_returnsStudentsCalendarWithCorrectProperties() throws Exception{
        //arrange
        Student student = new Student("Abra Cadabra");
        Calendar calendar = new Calendar(1L, student);
        calendarRepository.saveAndFlush(calendar);

        //act
        ResponseEntity<Calendar> response = restTemplate.getForEntity("/calendar/1", Calendar.class);

        //assert
        Assertions.assertThat(response.getStatusCode()).isEqualTo(HttpStatus.OK);
        Assertions.assertThat(Objects.deepEquals(response.getBody(), calendar));
    }

    @Test
    @DirtiesContext
    public void getCalendarById_returnsTeachersCalendarWithCorrectProperties() throws Exception{
        //arrange
        Teacher teacher = new Teacher(1L, "Merlin Magic");
        Calendar calendar = new Calendar(1L, teacher);
        //act
        ResponseEntity<Calendar> response = restTemplate.getForEntity("/calendar/1", Calendar.class);

        //assert
        Assertions.assertThat(response.getStatusCode()).isEqualTo(HttpStatus.OK);
        Assertions.assertThat(Objects.deepEquals(calendar, response.getBody()));

    }

    @Test
    @DirtiesContext
    public void calendarsUserCanOnlyEitherBeATeacherOrAStudent() throws Exception{
        //arrange
        Calendar calendar1 = new Calendar(1L, new Teacher());
        Calendar calendar2 = new Calendar(2L, new Student());

        //assert
        Assertions.assertThat(calendar1.getStudent()).isNull();
        Assertions.assertThat(calendar2.getTeacher()).isNull();
    }

    @Test
    @DirtiesContext
    public void getTopicById_returnsTopic() throws Exception{
        //arrange
        Topic topic = new Topic();
        topicRepository.saveAndFlush(topic);
        //act
        ResponseEntity<Topic> response = restTemplate.getForEntity("/topic/1", Topic.class);
        //assert
        Assertions.assertThat(response.getStatusCode()).isEqualTo(HttpStatus.OK);
    }

}
