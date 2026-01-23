package com.SkillUp.Service;


import com.SkillUp.Repository.ChatMessageRepository;
import com.SkillUp.model.ChatMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ChatService {


    @Autowired
    private ChatMessageRepository repository;

    public ChatMessage saveMessage(ChatMessage message){
        return repository.save(message);
    }



}
