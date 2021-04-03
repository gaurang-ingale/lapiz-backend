package dev.voidbit.lapiz;

import org.springframework.stereotype.Service;

@Service
public class StudentService {

    private final StudentRepository studentRepository;

    public StudentService(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    public Student getStudentById(Long id) throws StudentNotFoundException{
        Student student =  studentRepository.getStudentById(id);
        if(student == null){
            throw new StudentNotFoundException();
        }
        return student;
    }
}
