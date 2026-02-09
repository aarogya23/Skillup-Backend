package com.SkillUp.Controller;

import com.SkillUp.model.ClassMessage;
import lombok.RequiredArgsConstructor;
import org.springframework.messaging.handler.annotation.*;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Controller;

@Controller
@RequiredArgsConstructor
public class ClassSocketController {

    private final SimpMessagingTemplate messagingTemplate;

    // Create / Join Class
    @MessageMapping("/class/join")
    public void joinClass(@Payload ClassMessage message) {
        messagingTemplate.convertAndSend(
                "/topic/class/" + message.getClassId(),
                message
        );
    }

    // Chat in Class
    @MessageMapping("/class/chat")
    public void sendMessage(@Payload ClassMessage message) {
        messagingTemplate.convertAndSend(
                "/topic/class/" + message.getClassId(),
                message
        );
    }

    // Leave Class
    @MessageMapping("/class/leave")
    public void leaveClass(@Payload ClassMessage message) {
        messagingTemplate.convertAndSend(
                "/topic/class/" + message.getClassId(),
                message
        );
    }
}
