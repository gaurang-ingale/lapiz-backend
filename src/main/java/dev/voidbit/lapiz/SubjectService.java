package dev.voidbit.lapiz;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class SubjectService {
    private SubjectRepository subjectRepository;

    public Subject getSubjectById(Long id) {
        return subjectRepository.getSubjectById(id);
    }
}
