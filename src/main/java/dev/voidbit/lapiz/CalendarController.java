package dev.voidbit.lapiz;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
public class CalendarController {
    private final CalendarService calendarService;

    public CalendarController(CalendarService calendarService){
        this.calendarService = calendarService;
    }

    @GetMapping("/calendar/{id}")
    private Calendar getCalendarById(@PathVariable Long id){
        return calendarService.getCalendarById(id);
    }

    @ExceptionHandler
    @ResponseStatus(HttpStatus.NOT_FOUND)
    private void handleCalendarNotFoundException(CalendarNotFoundException ex){

    }
}
