package dev.voidbit.lapiz;

import org.springframework.stereotype.Service;

@Service
public class CalendarService {
    private CalendarRepository calendarRepository;
    public CalendarService(CalendarRepository calendarRepository){
        this.calendarRepository = calendarRepository;
    }
    public Calendar getCalendarById(Long id) {
        return null;
    }
}
