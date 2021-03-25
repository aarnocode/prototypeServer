package com.pushserver.prototype.controller;

import com.google.api.Http;
import com.pushserver.prototype.model.PushNotificationRequest;
import com.pushserver.prototype.model.PushNotificationResponse;
import com.pushserver.prototype.service.PushNotificationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin("*")
public class PushNotificationController {
    @Autowired
    private PushNotificationService pushNotificationService;

    public PushNotificationController(PushNotificationService pushNotificationService) {
        this.pushNotificationService = pushNotificationService;
    }

    @PostMapping("/push/user")
    public ResponseEntity sendTokenNotification(@RequestBody PushNotificationRequest request){
        pushNotificationService.sendPushNotificationToToken(request);
        return new ResponseEntity<>(
                new PushNotificationResponse(HttpStatus.OK.value(),
                "Notification has been sent to a user"),
                HttpStatus.OK);
    }

    @PostMapping("/push/topic")
    public ResponseEntity sendTopicNotification(@RequestBody PushNotificationRequest request){
        pushNotificationService.sendPushNotificationToTopic(request);
        return new ResponseEntity<>(
                new PushNotificationResponse(HttpStatus.OK.value(),
                        "Notification has been sent to " + request.getTopic()),
                HttpStatus.OK);
    }
}
