package com.whatsappapi.api.controller;

import org.springframework.messaging.handler.annotation.DestinationVariable;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;

import com.whatsappapi.api.model.messageDto;

@Controller
public class webSocketController {

    @MessageMapping("/chat/{roomId}")
    @SendTo("/topic/messages/{roomId}")
    public messageDto sendMessage(@DestinationVariable Long roomId, messageDto message) {
        // Save the message to the database and return
        return message;
    }
}

