package com.SkillUp.Controller;

import com.SkillUp.Websocket.ChatWebSocketHandler;
import com.SkillUp.dto.MessageRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;

@RestController
@RequestMapping("/api/messages")
@CrossOrigin("*")
public class MessageController {

    private final ChatWebSocketHandler chatWebSocketHandler;

    public MessageController(ChatWebSocketHandler chatWebSocketHandler) {
        this.chatWebSocketHandler = chatWebSocketHandler;
    }

    /**
     * Send message via REST API and push via WebSocket
     */
    @PostMapping("/send")
    public ResponseEntity<String> sendMessage(
            @RequestBody MessageRequest request) throws IOException {

        // Simple message format
        String message =
                request.getSender() + ": " + request.getContent();

        // Broadcast to WebSocket clients
        chatWebSocketHandler.broadcastMessage(message);

        return ResponseEntity.ok("Message sent successfully");
    }
}

