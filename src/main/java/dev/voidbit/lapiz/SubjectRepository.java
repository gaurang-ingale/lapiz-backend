package dev.voidbit.lapiz;

import org.springframework.data.jpa.repository.JpaRepository;

public interface SubjectRepository extends JpaRepository<Subject, Long> {
    public Subject getSubjectById(Long id);
}
