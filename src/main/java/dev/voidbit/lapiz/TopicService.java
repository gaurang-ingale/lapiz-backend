package dev.voidbit.lapiz;

import org.springframework.stereotype.Service;

@Service
public class TopicService {
    private TopicRepository topicRepository;

    public TopicService(TopicRepository topicRepository) {
        this.topicRepository = topicRepository;
    }

    public Topic getTopicById(Long id) {
        Topic topic = this.topicRepository.getTopicById(id);
        if(topic == null){
            throw new TopicNotFoundException();
        }else{
            return topic;
        }
    }
}
