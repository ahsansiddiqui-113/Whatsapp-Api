package com.whatsappapi.api.model;

import javax.persistence.*;

@Entity
public class message {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @ManyToOne
    private User sender;
    
    @ManyToOne
    private chatroom chatRoom;
    
    private String content;

    private String text;

    private String attachmentType; 

    private String attachmentUrl; 

    private long attachmentSize;
    
    message(Long id,User sender,chatroom chatRoom,String content){
        this.id=id;
        this.sender=sender;
        this.chatRoom=chatRoom;
        this.content=content;
        this.text=text;
        this.attachmentSize=attachmentSize;
        this.attachmentType=attachmentType;
        this.attachmentUrl=attachmentUrl;
    }
    public message(){}
    public void setChatRoom(chatroom chatRoom) {
        this.chatRoom = chatRoom;
    }
    public void setContent(String content) {
        this.content = content;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public void setSender(User sender) {
        this.sender = sender;
    }
    public chatroom getChatRoom() {
        return chatRoom;
    }
    public String getContent() {
        return content;
    }
    public Long getId() {
        return id;
    }
    public User getSender() {
        return sender;
    }
    public void setAttachmentSize(long attachmentSize) {
        this.attachmentSize = attachmentSize;
    }
    public void setText(String text) {
        this.text = text;
    }
    public void setAttachmentType(String attachmentType) {
        this.attachmentType = attachmentType;
    }
    public void setAttachmentUrl(String attachmentUrl) {
        this.attachmentUrl = attachmentUrl;
    }
    public long getAttachmentSize() {
        return attachmentSize;
    }
    public String getAttachmentType() {
        return attachmentType;
    }
    public String getAttachmentUrl() {
        return attachmentUrl;
    }
    public String getText() {
        return text;
    }
}

