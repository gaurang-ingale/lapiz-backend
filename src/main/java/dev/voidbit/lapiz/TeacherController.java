package dev.voidbit.lapiz;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@RestController
public class TeacherController {
    private TeacherService teacherService;

    public TeacherController(TeacherService teacherService){
        this.teacherService = teacherService;
    }

    @GetMapping("/teacher/{id}")
    private Teacher getTeacherById(@PathVariable Long id){
        return teacherService.getTeacherById(id);
    }

    @ExceptionHandler
    @ResponseStatus(HttpStatus.NOT_FOUND)
    private void handleTeacherNotFoundException(TeacherNotFoundException ex){

    }
}
