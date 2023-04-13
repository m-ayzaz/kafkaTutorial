package com.ayzaz.kafkaTutorial.controller;

import com.ayzaz.kafkaTutorial.producer.KafkaProducer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("kafka")
public class MessageController {

    @Autowired
    private KafkaProducer producer;

    @GetMapping("/produce")
    public ResponseEntity<String> sendMessage(@RequestParam("message") String message){
        try{
            producer.sendMessage(message);
            return ResponseEntity.ok("Message sent");
        }
        catch (Exception e){
            e.printStackTrace();
        }
        return ResponseEntity.badRequest().body("System Failure");
    }
}
