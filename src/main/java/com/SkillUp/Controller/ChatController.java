package com.SkillUp.Controller;

import com.SkillUp.Service.ChatService;
import com.SkillUp.model.ChatMessage;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;

@Controller
public class ChatController {

    private final ChatService chatService;

    // ✅ Constructor Injection (NO @Autowired needed)
    public ChatController(ChatService chatService) {
        this.chatService = chatService;
    }

    @MessageMapping("/chat.send")
    @SendTo("/topic/public")
    public ChatMessage sendMessage(ChatMessage message) {
        chatService.saveMessage(message);
        return message;
    }

    @MessageMapping("/chat.join")
    @SendTo("/topic/public")
    public ChatMessage join(ChatMessage message) {
        message.setContent(message.getSender() + " joined the chat");
        message.setType("JOIN");
        chatService.saveMessage(message);
        return message;
    }
}
