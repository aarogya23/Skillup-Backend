package com.SkillUp.Services;

import com.SkillUp.Repository.MessageRepository;
import com.SkillUp.Websocket.ChatWebSocketHandler;
import com.SkillUp.model.Message;
import org.springframework.stereotype.Service;

import java.io.IOException;

@Service
public class MessageService {

    private final MessageRepository repository;
    private final ChatWebSocketHandler webSocketHandler;

    public MessageService(MessageRepository repository,
                          ChatWebSocketHandler webSocketHandler) {
        this.repository = repository;
        this.webSocketHandler = webSocketHandler;
    }

    public void sendMessage(Message message) throws IOException {
        repository.save(message);
        webSocketHandler.broadcastMessage(
                message.getSender() + ": " + message.getContent()
        );
    }
}

