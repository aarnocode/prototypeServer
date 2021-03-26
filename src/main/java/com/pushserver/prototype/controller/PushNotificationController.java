package com.pushserver.prototype.controller;

import com.google.api.Http;
import com.google.firebase.messaging.FirebaseMessaging;
import com.google.firebase.messaging.FirebaseMessagingException;
import com.google.firebase.messaging.TopicManagementResponse;
import com.pushserver.prototype.model.PushNotificationRequest;
import com.pushserver.prototype.model.PushNotificationResponse;
import com.pushserver.prototype.service.PushNotificationService;
import org.apache.coyote.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
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

    @PostMapping("/subscribe")
    public String subscribe(@RequestBody PushNotificationRequest request) throws FirebaseMessagingException {
        List<String> tkn = new ArrayList<String>();
        tkn.add(request.getToken());
        try{
            TopicManagementResponse response = FirebaseMessaging.getInstance().subscribeToTopic(tkn,"all");
            return "Subscribed to ALL";
        }catch(Exception e){
            return e.getMessage();
        }

    }
}
