package com.whatsappapi.api.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.whatsappapi.api.model.chatroom;

@Repository
public interface chatroomRepository extends JpaRepository<chatroom, Long> {
    List<Chatroom> findByName(String name);

    List<Chatroom> findByCreator(User creator);

    List<Chatroom> findByParticipantsContaining(User participant);

    List<Chatroom> findByNameAndCreator(String name, User creator);

    List<Chatroom> findByNameContaining(String keyword);

    long countByCreator(User creator);

    boolean existsByName(String name);

    void deleteByCreator(User creator);

    void deleteByName(String name);
}
 
