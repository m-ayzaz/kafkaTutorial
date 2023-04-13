package com.ayzaz.kafkaTutorial.config;

import com.ayzaz.kafkaTutorial.utility.Utitlity;
import org.apache.kafka.clients.admin.NewTopic;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.config.TopicBuilder;

@Configuration
public class KafkaTopicConfig {

    @Bean
    public NewTopic topic(){
        return TopicBuilder.name(Utitlity.TOPIC_NAME).build();
    }
}
