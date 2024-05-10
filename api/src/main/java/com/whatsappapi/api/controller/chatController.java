package com.whatsappapi.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
@Api(tags = "Chat API")
public class ChatController {

    @GetMapping("/chat/{roomId}")
    @ApiOperation(value = "Get messages by chat room ID")
    public ResponseEntity<?> getMessagesByChatRoomId(@PathVariable Long roomId) {
        // Implementation to retrieve messages by chat room ID
        return ResponseEntity.ok().build();
    }

    @PostMapping("/chat/{roomId}/message")
    @ApiOperation(value = "Send a message to a chat room")
    public ResponseEntity<?> sendMessageToChatRoom(@PathVariable Long roomId, @RequestBody String message) {
        if (messageContent == null || messageContent.isEmpty()) {
            return ResponseEntity.badRequest().build(); // Invalid request, message content cannot be empty
        }
    
        // Check if the chat room exists
        boolean chatRoomExists = chatRoomService.existsById(roomId);
        
        if (!chatRoomExists) {
            return ResponseEntity.notFound().build(); // Chat room not found
        }
    
        // Send the message to the chat room
        boolean messageSent = chatRoomService.sendMessage(roomId, messageContent);
        
        if (!messageSent) {
            return ResponseEntity.status(HttpStatus.CREATED).build();
        }
    }

    @PostMapping("/chat")
    @ApiOperation(value = "Create a new chat room")
    public ResponseEntity<?> createChatRoom(@RequestBody String chatRoomName) {
        if (chatRoomName == null || chatRoomName.isEmpty()) {
            return ResponseEntity.badRequest().build(); 
        }
        ChatRoom chatRoom = chatRoomService.createChatRoom(chatRoomName);
    
        if (chatRoom == null) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build(); 
        }        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @PostMapping("/chat/{roomId}/participant")
    @ApiOperation(value = "Add a participant to a chat room")
    public ResponseEntity<?> addParticipantToChatRoom(@PathVariable Long roomId, @RequestBody Long participantId) {
        boolean participantExists = userService.existsById(participantId);
    
        if (!participantExists) {
            return ResponseEntity.notFound().build(); 
        }
        boolean participantAdded = chatRoomService.addParticipant(roomId, participantId);
        
        if (!participantAdded) {
            return ResponseEntity.status(HttpStatus.CONFLICT).build(); 
        }
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }


    @DeleteMapping("/chat/{roomId}/participant/{participantId}")
    @ApiOperation(value = "Remove a participant from a chat room")
    public ResponseEntity<?> removeParticipantFromChatRoom(@PathVariable Long roomId, @PathVariable Long participantId) {
        boolean participantExists = chatRoomService.isParticipantInChatRoom(roomId, participantId);
    
    if (!participantExists) {
        return ResponseEntity.notFound().build(); 
    }

    chatRoomService.removeParticipantFromChatRoom(roomId, participantId);
        return ResponseEntity.ok().build();
    }

}
