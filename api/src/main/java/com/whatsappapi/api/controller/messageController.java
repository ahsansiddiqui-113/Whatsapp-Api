package com.whatsappapi.api.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import com.whatsappapi.api.service.messageService;

@RestController
@RequestMapping("/api/messages")
public class messageController {

    @Autowired
    private messageService message;

    @PostMapping("/{messageId}/attachments")
    public ResponseEntity<?> uploadAttachment(@PathVariable("messageId") Long messageId, @RequestParam("file") MultipartFile file) {
       
        message.uploadAttachment(messageId, file);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/{messageId}/attachments")
    public ResponseEntity<byte[]> downloadAttachment(@PathVariable("messageId") Long messageId) {
        byte[] attachmentBytes = message.downloadAttachment(messageId);
        return ResponseEntity.ok().body(attachmentBytes);
    }
}

