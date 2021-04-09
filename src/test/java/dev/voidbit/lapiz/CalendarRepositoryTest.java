package dev.voidbit.lapiz;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ExtendWith(SpringExtension.class)
@DataJpaTest
public class CalendarRepositoryTest {
    @Autowired
    private CalendarRepository calendarRepository;

    @Autowired
    private TestEntityManager testEntityManager;

    @Test
    @DirtiesContext
    public void getCalendarById_returnsCalendar() throws Exception{
        //arrange
        testEntityManager.persistFlushFind(new Calendar());
        //act
        Calendar calendar = calendarRepository.getCalendarById(1L);
        //assert
        Assertions.assertThat(calendar).isNotNull();
    }

    @Test
    @DirtiesContext
    public void getCalendarById_notFound() throws Exception{
        //act
        Calendar calendar = calendarRepository.getCalendarById(1L);

        //assert
        Assertions.assertThat(calendar).isNull();
    }
}
