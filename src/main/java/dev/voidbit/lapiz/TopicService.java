package dev.voidbit.lapiz;

import org.springframework.stereotype.Service;

@Service
public class TopicService {
    private TopicRepository topicRepository;

    public TopicService(TopicRepository topicRepository) {
        this.topicRepository = topicRepository;
    }

    public Topic getTopicById(long anyLong) {
        return null;
    }
}
