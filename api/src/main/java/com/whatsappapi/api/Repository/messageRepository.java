package com.whatsappapi.api.Repository;
import com.whatsappapi.api.model.message;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface messageRepository extends JpaRepository<message, Long> {
    
    List<Message> findBySender(User sender);

   List<Message> findByReceiver(User receiver);

    List<Message> findBySenderAndReceiver(User sender, User receiver);

    List<Message> findByChatroom(Chatroom chatroom);

    List<Message> findBySenderAndChatroom(User sender, Chatroom chatroom);

    List<Message> findByReceiverAndChatroom(User receiver, Chatroom chatroom);

    List<Message> findBySenderAndReceiverAndChatroom(User sender, User receiver, Chatroom chatroom);

    List<Message> findByTimestampGreaterThan(long timestamp);

    List<Message> findByTimestampLessThan(long timestamp);

    List<Message> findByTimestampBetween(long startTimestamp, long endTimestamp);

    Message findTopByChatroomOrderByTimestampDesc(Chatroom chatroom);
}

