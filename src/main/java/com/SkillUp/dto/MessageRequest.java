package com.SkillUp.dto;


public class MessageRequest {

    private String sender;
    private String receiver;
    private String content;

    // No-args constructor (required for JSON binding)
    public MessageRequest() {
    }

    // Getters & Setters
    public String getSender() {
        return sender;
    }

    public void setSender(String sender) {
        this.sender = sender;
    }

    public String getReceiver() {
        return receiver;
    }

    public void setReceiver(String receiver) {
        this.receiver = receiver;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}

