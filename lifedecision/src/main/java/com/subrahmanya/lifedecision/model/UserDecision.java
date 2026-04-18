package com.subrahmanya.lifedecision.model;

import jakarta.persistence.*;

@Entity
public class UserDecision {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    @Column(columnDefinition = "LONGTEXT")
    private String situation;

    @Column(columnDefinition = "LONGTEXT")
    private String recommendation;

    private String confidence;

    // ===== GETTERS AND SETTERS =====

    public Long getId() { return id; }

    public void setId(Long id) { this.id = id; }

    public String getName() { return name; }

    public void setName(String name) { this.name = name; }

    public String getSituation() { return situation; }

    public void setSituation(String situation) { this.situation = situation; }

    public String getRecommendation() { return recommendation; }

    public void setRecommendation(String recommendation) { this.recommendation = recommendation; }

    public String getConfidence() { return confidence; }

    public void setConfidence(String confidence) { this.confidence = confidence; }
}