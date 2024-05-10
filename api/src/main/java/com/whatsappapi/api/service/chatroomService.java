package com.whatsappapi.api.service;
import com.whatsappapi.api.Repository.chatroomRepository;
import com.whatsappapi.api.model.chatroom;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class chatroomService {

    private final chatroomRepository chatRoomRepository;

    @Autowired
    public chatroomService(chatroomRepository chatRoomRepository) {
      this.chatRoomRepository = chatRoomRepository;
    }

    public List<chatroom> getAllChatRooms() {
        return chatRoomRepository.findAll();
    }

    public Optional<chatroom> getChatRoomById(Long id) {
        return chatRoomRepository.findById(id);
    }

    // Other CRUD methods for chat room management (create, update, delete) can be added here
}

