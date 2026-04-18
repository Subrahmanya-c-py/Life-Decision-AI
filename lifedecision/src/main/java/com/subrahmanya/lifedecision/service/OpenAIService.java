package com.subrahmanya.lifedecision.service;

import org.springframework.stereotype.Service;
import com.subrahmanya.lifedecision.dto.DecisionResponse;

import java.util.Random;

@Service
public class OpenAIService {

    public DecisionResponse getAdvice(String query) {
        return generateSmartDecision(query);
    }

    private DecisionResponse generateSmartDecision(String query) {

        String lower = query.toLowerCase();
        DecisionResponse response = new DecisionResponse();
        Random random = new Random();

        if (lower.contains("engineering") || lower.contains("college")) {

            response.setOverview(
                    "Choosing the right engineering college is a critical academic decision that affects your career trajectory."
            );

            response.setFactors(
                    "- Placement record\n" +
                            "- Faculty quality\n" +
                            "- Campus infrastructure"
            );

            response.setBenefits(
                    "Good colleges improve career exposure and salary opportunities."
            );

            response.setRisks(
                    "High tuition fees and relocation challenges."
            );

            response.setRecommendation(
                    "Compare placement records, faculty expertise, and long-term ROI before choosing."
            );

        } else {

            response.setOverview(
                    "This decision requires evaluating both short-term risks and long-term benefits. " +
                            "Understanding financial stability, personal readiness, and growth opportunities will help determine the best path."
            );

            response.setFactors(
                    "- Financial impact\n" +
                            "- Emotional readiness\n" +
                            "- Long-term growth potential"
            );

            response.setBenefits(
                    "This decision may create opportunities for growth and improved stability."
            );

            response.setRisks(
                    "Short-term uncertainty and possible adjustment challenges."
            );

            response.setRecommendation(
                    "Evaluate long-term benefits versus immediate risk before making the decision."
            );
        }

        response.setConfidenceScore(70 + random.nextInt(20));
        response.setRiskScore(40 + random.nextInt(30));
        response.setGrowthScore(65 + random.nextInt(25));
        response.setStabilityScore(60 + random.nextInt(25));
        response.setSkillMatchScore(60 + random.nextInt(25));

        return response;
    }
}