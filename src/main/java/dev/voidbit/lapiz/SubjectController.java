package dev.voidbit.lapiz;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SubjectController {
    @Autowired
    private SubjectService subjectService;

    @GetMapping("/subject/{id}")
    private Subject getSubjectById(@PathVariable Long id){
        return subjectService.getSubjectById(id);
    }
}
