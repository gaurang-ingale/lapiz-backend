package dev.voidbit.lapiz;

import org.springframework.data.jpa.repository.JpaRepository;

public interface CalendarRepository extends JpaRepository<Calendar, Long> {
    public Calendar getCalendarById(Long id);
}
