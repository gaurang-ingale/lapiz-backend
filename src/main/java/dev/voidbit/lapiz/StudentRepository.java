package dev.voidbit.lapiz;

import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentRepository extends JpaRepository<Student, Long>{

    public Student getStudentById(Long id);
}
