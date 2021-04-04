package dev.voidbit.lapiz;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class SubjectService {
    private SubjectRepository subjectRepository;

    public Subject getSubjectById(Long id) {
        Subject subject = subjectRepository.getSubjectById(id);
        if(subject == null){
            throw new SubjectNotFoundException();
        }
        return subject;
    }
}
