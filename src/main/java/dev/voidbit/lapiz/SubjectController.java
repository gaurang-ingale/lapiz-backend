package dev.voidbit.lapiz;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
public class SubjectController {
    @Autowired
    private SubjectService subjectService;

    @GetMapping("/subject/{id}")
    private Subject getSubjectById(@PathVariable Long id){
        return subjectService.getSubjectById(id);
    }

    @ExceptionHandler
    @ResponseStatus(HttpStatus.NOT_FOUND)
    private void subjectNotFoundHanlder(SubjectNotFoundException ex){

    }
}
