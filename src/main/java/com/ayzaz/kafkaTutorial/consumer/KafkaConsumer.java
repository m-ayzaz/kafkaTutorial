package com.ayzaz.kafkaTutorial.consumer;

import com.ayzaz.kafkaTutorial.utility.Utitlity;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class KafkaConsumer {

    private Logger logger = LoggerFactory.getLogger(KafkaConsumer.class);

    @KafkaListener(topics = Utitlity.TOPIC_NAME,groupId = "myGroup")
    private void consume(String message){
        logger.info("KAFKA CONSUMER send to TOPIC :: "+ Utitlity.TOPIC_NAME + " MESSAGE ::"+ message);
    }
}
