package com.subrahmanya.lifedecision.dto;

public class DecisionResponse {

    private String overview;
    private String factors;
    private String benefits;
    private String risks;
    private String recommendation;

    private int riskScore;
    private int growthScore;
    private int stabilityScore;
    private int skillMatchScore;
    private int confidenceScore;

    public DecisionResponse() {}

    // ===== TEXT FIELDS =====

    public String getOverview() { return overview; }
    public void setOverview(String overview) { this.overview = overview; }

    public String getFactors() { return factors; }
    public void setFactors(String factors) { this.factors = factors; }

    public String getBenefits() { return benefits; }
    public void setBenefits(String benefits) { this.benefits = benefits; }

    public String getRisks() { return risks; }
    public void setRisks(String risks) { this.risks = risks; }

    public String getRecommendation() { return recommendation; }
    public void setRecommendation(String recommendation) { this.recommendation = recommendation; }

    // ===== SCORES =====

    public int getRiskScore() { return riskScore; }
    public void setRiskScore(int riskScore) { this.riskScore = riskScore; }

    public int getGrowthScore() { return growthScore; }
    public void setGrowthScore(int growthScore) { this.growthScore = growthScore; }

    public int getStabilityScore() { return stabilityScore; }
    public void setStabilityScore(int stabilityScore) { this.stabilityScore = stabilityScore; }

    public int getSkillMatchScore() { return skillMatchScore; }
    public void setSkillMatchScore(int skillMatchScore) { this.skillMatchScore = skillMatchScore; }

    public int getConfidenceScore() { return confidenceScore; }
    public void setConfidenceScore(int confidenceScore) { this.confidenceScore = confidenceScore; }
}