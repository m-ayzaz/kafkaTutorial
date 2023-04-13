package com.ayzaz.kafkaTutorial.producer;

import com.ayzaz.kafkaTutorial.utility.Utitlity;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.KafkaHeaders;
import org.springframework.messaging.Message;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service
public class KafkaProducer {

    private Logger logger = LoggerFactory.getLogger(KafkaProducer.class);

    @Autowired
    private KafkaTemplate<String,String> kafkaTemplate;

    public void sendMessage(String message){
        try{
            logger.info("KAFKA PRODUCER send to TOPIC :: "+ Utitlity.TOPIC_NAME + " MESSAGE ::"+ message);
            kafkaTemplate.send(Utitlity.TOPIC_NAME, message);
        }
        catch (Exception e){
            e.printStackTrace();
        }
    }

    public void sendMessage(Map<String,String> data){
        try{
            logger.info("KAFKA PRODUCER send to TOPIC :: "+ Utitlity.TOPIC_NAME + " MESSAGE ::"+ data.toString());
            Message<Map<String,String>> message = MessageBuilder
                    .withPayload(data)
                            .setHeader(KafkaHeaders.TOPIC, Utitlity.TOPIC_NAME).build();
            kafkaTemplate.send(message);
        }
        catch (Exception e){
            e.printStackTrace();
        }
    }
}
