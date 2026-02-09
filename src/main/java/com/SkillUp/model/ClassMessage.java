package com.SkillUp.model;

import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ClassMessage {

    private String classId;
    private String sender;
    private String content;
    private String type; // JOIN, CHAT, LEAVE
}
