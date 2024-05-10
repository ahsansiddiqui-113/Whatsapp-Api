package com.whatsappapi.api.service;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import com.google.auth.oauth2.GoogleCredentials;
import com.google.firebase.FirebaseApp;
import com.google.firebase.FirebaseOptions;
import com.google.firebase.messaging.FirebaseMessaging;
import com.google.firebase.messaging.FirebaseMessagingException;
import com.google.firebase.messaging.Message;

public class FCMService {

    private FirebaseMessaging firebaseMessaging;

    public FCMService() throws FileNotFoundException, IOException {        
         FirebaseOptions options = FirebaseOptions.builder()
                .setCredentials(GoogleCredentials.fromStream(new FileInputStream("E:/whatsapp application/api/srcmain/resources/firebase-credentials.json")))
                .build();
        FirebaseApp.initializeApp(options);
        this.firebaseMessaging = FirebaseMessaging.getInstance();
    }

    public void sendPushNotification(String deviceToken, String message) {
        // Create FCM message
        Message fcmMessage = Message.builder()
                .setToken(deviceToken)
                .putData("message", message)
                .build();

        // Send message
        try {
            firebaseMessaging.send(fcmMessage);
        } catch (FirebaseMessagingException e) {
            // Handle exception
        }
    }
}

