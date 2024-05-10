package com.whatsappapi.api.service;


import com.whatsappapi.api.Repository.messageRepository;
import com.whatsappapi.api.model.message;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;
import java.util.Optional;

@Service
public class messageService {

    @Value("${attachment.maxSize}")
    private long maxAttachmentSize;

    private messageRepository messagerepository;

    @Autowired
    public messageService(messageRepository messagerepository) {
        this.messagerepository = messagerepository;
    }

    public List<message> getAllMessages() {
        return messagerepository.findAll();
    }

    public Optional<message> getMessageById(Long id) {
        return messagerepository.findById(id);
    }

    public void uploadAttachment(Long messageId, MultipartFile file) {
        // Validate attachment size
        if (file.getSize() > maxAttachmentSize) {
            throw new RuntimeException("Attachment size exceeds the maximum allowed size.");
        }

        // Save attachment to storage
        // Update message with attachment details
    }

    public byte[] downloadAttachment(Long messageId) {
        return null;
        // Retrieve attachment from storage
        // Return attachment as byte array
    }
}

