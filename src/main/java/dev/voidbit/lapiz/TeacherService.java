package dev.voidbit.lapiz;

import org.springframework.stereotype.Service;

@Service
public class TeacherService {
    private final TeacherRepository teacherRepository;

    public TeacherService(TeacherRepository teacherRepository) {
        this.teacherRepository = teacherRepository;
    }

    public Teacher getTeacherById(Long id) {
        Teacher teacher = teacherRepository.getTeacherById(id);
        if(teacher != null){
            return teacher;
        }
        throw new TeacherNotFoundException();
    }
}
