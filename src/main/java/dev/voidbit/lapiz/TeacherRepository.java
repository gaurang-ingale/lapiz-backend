package dev.voidbit.lapiz;

import org.springframework.data.jpa.repository.JpaRepository;

public interface TeacherRepository extends JpaRepository<Teacher, Long> {
    public Teacher getTeacherById(Long id);
}
