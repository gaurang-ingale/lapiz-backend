package dev.voidbit.lapiz;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TopicController {
    @Autowired
    TopicService topicService;

    @GetMapping("/topic/{id}")
    private Topic getTopicById(@PathVariable Long id){
        return topicService.getTopicById(id);
    }
}
