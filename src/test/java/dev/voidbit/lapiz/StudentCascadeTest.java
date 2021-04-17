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
public class StudentCascadeTest {
    @Autowired
    private StudentRepository studentRepository;

    @Autowired
    private CalendarRepository calendarRepository;

    @Autowired
    private SubjectRepository subjectRepository;

    @Autowired
    private TestEntityManager testEntityManager;

    @Test
    @DirtiesContext
    public void student_whenRemoved_doesNotRemoveSubject() throws Exception{
        //arrange
        Student student = new Student("Abra Cadabra");
        Subject subject = new Subject("Computer Science");
        student.getSubjects().add(subject);
        testEntityManager.persistFlushFind(student);
        Long subjectId = testEntityManager.getId(subject, Long.class);
        Long studentId = testEntityManager.getId(student, Long.class);

        //act and assert
        Student retrievedStudent = studentRepository.getStudentById(studentId);
        Subject retrievedSubject = subjectRepository.getSubjectById(subjectId);
        Assertions.assertThat(retrievedSubject).isNotNull();
        Assertions.assertThat(retrievedStudent).isNotNull();
        Assertions.assertThat(retrievedStudent.getSubjects().contains(retrievedSubject));
        Assertions.assertThat(Objects.deepEquals(student, retrievedStudent));
        Assertions.assertThat(Objects.deepEquals(subject, retrievedSubject));

        studentRepository.delete(student);
        retrievedStudent = studentRepository.getStudentById(studentId);
        retrievedSubject = subjectRepository.getSubjectById(subjectId);
        Assertions.assertThat(retrievedStudent).isNull();
        Assertions.assertThat(retrievedSubject).isNotNull();
        Assertions.assertThat(Objects.deepEquals(retrievedSubject,subject));
    }

    @Test
    @DirtiesContext
    public void student_whenRemoved_removesAssociatedCalendar() {
        //arrange
        Student student = new Student("Abra Cadabra");
        testEntityManager.persistFlushFind(student);
        Long studentId = testEntityManager.getId(student, Long.class);
        Long calendarId = testEntityManager.getId(student.getCalendar(), Long.class);

        //act and assert
        Student retrievedStudent = studentRepository.getStudentById(studentId);
        Calendar retrievedCalendar = calendarRepository.getCalendarById(calendarId);
        Assertions.assertThat(retrievedStudent).isNotNull();
        Assertions.assertThat(retrievedCalendar).isNotNull();
        Assertions.assertThat(Objects.deepEquals(student, retrievedStudent));

        studentRepository.delete(student);
        retrievedStudent = studentRepository.getStudentById(studentId);
        retrievedCalendar = calendarRepository.getCalendarById(calendarId);
        Assertions.assertThat(retrievedStudent).isNull();
        Assertions.assertThat(retrievedCalendar).isNull();
    }

}
