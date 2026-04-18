package com.subrahmanya.lifedecision.model;

import jakarta.persistence.*;

@Entity
public class ChatHistory {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String userEmail;

    private String userMessage;

    @Column(columnDefinition = "LONGTEXT")
    private String aiResponse;

    public ChatHistory() {}

    public ChatHistory(String userEmail, String userMessage, String aiResponse) {
        this.userEmail = userEmail;
        this.userMessage = userMessage;
        this.aiResponse = aiResponse;
    }

    public Long getId() { return id; }

    public String getUserEmail() { return userEmail; }
    public void setUserEmail(String userEmail) { this.userEmail = userEmail; }

    public String getUserMessage() { return userMessage; }
    public void setUserMessage(String userMessage) { this.userMessage = userMessage; }

    public String getAiResponse() { return aiResponse; }
    public void setAiResponse(String aiResponse) { this.aiResponse = aiResponse; }
}