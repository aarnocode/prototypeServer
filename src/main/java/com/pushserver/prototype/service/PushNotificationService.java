package com.pushserver.prototype.service;

import com.pushserver.prototype.firebase.FCMService;
import com.pushserver.prototype.model.PushNotificationRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.concurrent.ExecutionException;

@Service
public class PushNotificationService {
    @Autowired
    private FCMService fcmService;

    public PushNotificationService(FCMService fcmService) {
        this.fcmService = fcmService;
    }

    public void sendPushNotificationToToken(PushNotificationRequest request){
        try{
            fcmService.sendMessageToToken(request);
        } catch (InterruptedException e) {
            System.out.println(e.getMessage());
        } catch (ExecutionException e) {
            System.out.println(e.getMessage());
        }
    }

    public void sendPushNotificationToTopic(PushNotificationRequest request){
        try{
            fcmService.sendMessageToTopic(request);
        } catch (InterruptedException e) {
            System.out.println(e.getMessage());
        } catch (ExecutionException e) {
            System.out.println(e.getMessage());
        }
    }
}
