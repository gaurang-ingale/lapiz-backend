package dev.voidbit.lapiz;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.Objects;

@ExtendWith(SpringExtension.class)
@DataJpaTest
public class CalendarCascadeTest {
    @Autowired
    private CalendarRepository calendarRepository;

    @Autowired
    private StudentRepository studentRepository;

    @Autowired
    private TeacherRepository teacherRepository;

    @Autowired
    private TestEntityManager testEntityManager;

    @Test
    @DirtiesContext
    public void calendarWhenRemoved_doesNotRemoveAssociatedStudent() throws Exception{
        //arrange
        Student student = new Student("Abra Cadabra");
        Calendar calendar = new Calendar(student);
        testEntityManager.persistFlushFind(calendar);
        Long studentId = testEntityManager.getId(student, Long.class);
        Long calendarId = testEntityManager.getId(calendar, Long.class);
        //act and assert
        Calendar retrievedCalendar = calendarRepository.getCalendarById(1L);
        Assertions.assertThat(Objects.deepEquals(retrievedCalendar, calendar));

        Student associatedStudent = retrievedCalendar.getStudent();
        Assertions.assertThat(Objects.deepEquals(associatedStudent, student));

        calendarRepository.delete(retrievedCalendar);
        calendarRepository.flush();
        retrievedCalendar = calendarRepository.getCalendarById(calendarId);
        Assertions.assertThat(retrievedCalendar).isNull();
        associatedStudent = studentRepository.getStudentById(studentId);
        Assertions.assertThat(associatedStudent).isNotNull();
    }

    @Test
    @DirtiesContext
    public void calendarWhenRemoved_doesNotRemoveAssociatedTeacher() throws Exception{
        //arrange
        Teacher teacher = new Teacher("Merlin Magic");
        Calendar calendar = new Calendar(teacher);
        testEntityManager.persistFlushFind(calendar);
        Long teacherId = testEntityManager.getId(teacher, Long.class);
        Long calendarId = testEntityManager.getId(calendar, Long.class);
        //act and assert
        Calendar retrievedCalendar = calendarRepository.getCalendarById(1L);
        Assertions.assertThat(Objects.deepEquals(retrievedCalendar, calendar));

        Teacher associatedTeacher = retrievedCalendar.getTeacher();
        Assertions.assertThat(Objects.deepEquals(associatedTeacher, teacher));

        calendarRepository.delete(retrievedCalendar);
        calendarRepository.flush();
        retrievedCalendar = calendarRepository.getCalendarById(calendarId);
        Assertions.assertThat(retrievedCalendar).isNull();
        associatedTeacher = teacherRepository.getTeacherById(teacherId);
        Assertions.assertThat(associatedTeacher).isNotNull();
    }
}
