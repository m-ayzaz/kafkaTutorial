package com.ayzaz.kafkaTutorial.controller;

import com.ayzaz.kafkaTutorial.producer.KafkaProducer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

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

    @PostMapping("/produce")
    public ResponseEntity<Map<String,String>> sendMessage(@RequestBody Map<String, String> data){
        HashMap<String, String> response = new HashMap<>();
        try{
            producer.sendMessage(data);
            response.put("Status","Sent");
            return ResponseEntity.ok(response);
        }
        catch (Exception e){
            e.printStackTrace();
        }
        response.put("Status","Fail");
        return ResponseEntity.badRequest().body(response);
    }
}
