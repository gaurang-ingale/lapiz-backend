package dev.voidbit.lapiz;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
public class TopicController {
    @Autowired
    TopicService topicService;

    @GetMapping("/topic/{id}")
    private Topic getTopicById(@PathVariable Long id){
        return topicService.getTopicById(id);
    }

    @ExceptionHandler
    @ResponseStatus(HttpStatus.NOT_FOUND)
    private void TopicNotFoundExceptionHandler(TopicNotFoundException e){

    }
}
