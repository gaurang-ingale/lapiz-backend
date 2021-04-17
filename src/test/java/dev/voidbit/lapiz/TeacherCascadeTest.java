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
public class TeacherCascadeTest {
    @Autowired
    private TeacherRepository teacherRepository;

    @Autowired
    private CalendarRepository calendarRepository;

    @Autowired
    private SubjectRepository subjectRepository;

    @Autowired
    private TestEntityManager testEntityManager;

    @Test
    @DirtiesContext
    public void teacher_whenRemoved_doesNotRemoveSubject() throws Exception{
        //arrange
        Teacher teacher = new Teacher("Merlin Magic");
        Subject subject = new Subject("Computer Science");
        teacher.getSubjects().add(subject);
        testEntityManager.persistFlushFind(teacher);
        Long subjectId = testEntityManager.getId(subject, Long.class);
        Long teacherId = testEntityManager.getId(teacher, Long.class);

        //act and assert
        Teacher retrievedTeacher = teacherRepository.getTeacherById(teacherId);
        Subject retrievedSubject = subjectRepository.getSubjectById(subjectId);
        Assertions.assertThat(retrievedSubject).isNotNull();
        Assertions.assertThat(retrievedTeacher).isNotNull();
        Assertions.assertThat(retrievedTeacher.getSubjects().contains(retrievedSubject));
        Assertions.assertThat(Objects.deepEquals(teacher, retrievedTeacher));
        Assertions.assertThat(Objects.deepEquals(subject, retrievedSubject));

        teacherRepository.delete(teacher);
        retrievedTeacher = teacherRepository.getTeacherById(teacherId);
        retrievedSubject = subjectRepository.getSubjectById(subjectId);
        Assertions.assertThat(retrievedTeacher).isNull();
        Assertions.assertThat(retrievedSubject).isNotNull();
        Assertions.assertThat(Objects.deepEquals(retrievedSubject,subject));
    }

    @Test
    @DirtiesContext
    public void teacher_whenRemoved_removesAssociatedCalendar() {
        //arrange
        Teacher teacher = new Teacher("Merlin Magic");
        testEntityManager.persistFlushFind(teacher);
        Long teacherId = testEntityManager.getId(teacher, Long.class);
        Long calendarId = testEntityManager.getId(teacher.getCalendar(), Long.class);

        //act and assert
        Teacher retrievedTeacher = teacherRepository.getTeacherById(teacherId);
        Calendar retrievedCalendar = calendarRepository.getCalendarById(calendarId);
        Assertions.assertThat(retrievedTeacher).isNotNull();
        Assertions.assertThat(retrievedCalendar).isNotNull();
        Assertions.assertThat(Objects.deepEquals(teacher, retrievedTeacher));

        teacherRepository.delete(teacher);
        retrievedTeacher = teacherRepository.getTeacherById(teacherId);
        retrievedCalendar = calendarRepository.getCalendarById(calendarId);
        Assertions.assertThat(retrievedTeacher).isNull();
        Assertions.assertThat(retrievedCalendar).isNull();
    }
}
