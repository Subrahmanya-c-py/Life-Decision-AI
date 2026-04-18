package com.subrahmanya.lifedecision.dto;

public class ChatRequest {

    private String message;
    private String name;
    private String lifeStage;
    private String riskTolerance;
    private String email;

    public ChatRequest() {}

    public String getMessage() { return message; }
    public void setMessage(String message) { this.message = message; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public String getLifeStage() { return lifeStage; }
    public void setLifeStage(String lifeStage) { this.lifeStage = lifeStage; }

    public String getRiskTolerance() { return riskTolerance; }
    public void setRiskTolerance(String riskTolerance) { this.riskTolerance = riskTolerance; }

    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }
}