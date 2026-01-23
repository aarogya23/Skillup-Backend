package com.SkillUp.Controller;

import com.SkillUp.Service.ChatService;
import com.SkillUp.model.ChatMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;

public class ChatController {

    @Autowired
    //implementation of service class implementation
    //using Autowired annotation
    private ChatService chatService;


    @MessageMapping("/chat.send")
    // Client send a meesage to /app/chat.send
    //why i use the app
    //this is we defined
    //registry.setApplicationDestinationPrefixes("/app")
    @SendTo("/topic/public")
    public ChatMessage sendMessage(ChatMessage message){
        chatService.saveMessage(message);
        return message;
    }

    @MessageMapping("/chat.join")
    @SendTo("/topic/public")
    public ChatMessage join(ChatMessage message){
        message.setContent(message.getSender() + "joined the chat");
        message.setType("JOIN");
        chatService.saveMessage(message);
        return message;
    }
}
