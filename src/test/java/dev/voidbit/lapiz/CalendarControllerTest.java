package dev.voidbit.lapiz;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.BDDMockito.given;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@ExtendWith(SpringExtension.class)
@WebMvcTest(CalendarController.class)
public class CalendarControllerTest {
    @MockBean
    private CalendarService calendarService;

    @Autowired
    private MockMvc mockMvc;

    @Test
    public void getCalendarById_returnsCalendar() throws Exception{
        //arrange
        given(calendarService.getCalendarById(anyLong()))
                .willReturn(new Calendar(1L));
        //act and assert
        mockMvc.perform(MockMvcRequestBuilders.get("/calendar/1"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("id").value(1L));
    }

    @Test
    public void getCalendarById_notFound() throws Exception{
        //arrange
        given(calendarService.getCalendarById(anyLong()))
                .willThrow(new CalendarNotFoundException());

        //act and assert
        mockMvc.perform(MockMvcRequestBuilders.get("/calendar/1"))
                .andExpect(status().isNotFound());
    }
}
