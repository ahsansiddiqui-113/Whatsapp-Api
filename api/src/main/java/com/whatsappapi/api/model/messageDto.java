package com.whatsappapi.api.model;

public class messageDto {
    private Long senderId;
    private Long chatRoomId;
    private String content;

    public messageDto(Long sender,Long chatRoomId,String content){
        this.senderId=senderId;
        this.chatRoomId = chatRoomId;
        this.content = content;
    }
    public void setChatRoomId(Long chatRoomId) {
        this.chatRoomId = chatRoomId;
    }
    public void setContent(String content) {
        this.content = content;
    }
    public void setSenderId(Long senderId) {
        this.senderId = senderId;
    }
    public Long getChatRoomId() {
        return chatRoomId;
    }
    public String getContent() {
        return content;
    }
    public Long getSenderId() {
        return senderId;
    }
    
    
}
