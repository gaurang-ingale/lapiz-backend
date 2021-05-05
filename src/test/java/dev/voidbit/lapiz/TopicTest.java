package dev.voidbit.lapiz;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

public class TopicTest {
    @Test
    public void topic_hasAName(){
        Assertions.assertThat(Topic.class).hasDeclaredFields("name");
        Assertions.assertThat(new Topic("First Topic").getName()).hasSameClassAs(new String());
    }

    @Test
    public void topic_hasADescription(){
        Assertions.assertThat(Topic.class).hasDeclaredFields("description");
        Assertions.assertThat(new Topic("First Topic", "The very first topic").getDescription())
                .hasSameClassAs(new String());
    }
}
