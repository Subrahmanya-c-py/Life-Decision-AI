package com.subrahmanya.lifedecision.controller;

import com.subrahmanya.lifedecision.dto.ChatRequest;
import com.subrahmanya.lifedecision.dto.DecisionResponse;
import com.subrahmanya.lifedecision.model.ChatHistory;
import com.subrahmanya.lifedecision.repository.ChatHistoryRepository;
import com.subrahmanya.lifedecision.service.OpenAIService;
import com.subrahmanya.lifedecision.service.PdfService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
@CrossOrigin(origins = "*")
public class ApiController {

    private static final String DEFAULT_HISTORY_EMAIL = "guest@lifedecision.local";

    @Autowired
    private OpenAIService openAIService;

    @Autowired
    private PdfService pdfService;

    @Autowired
    private ChatHistoryRepository chatHistoryRepository;

    // =========================
    // ANALYZE DECISION
    // =========================

    @PostMapping("/analyze")
    public DecisionResponse analyze(@RequestBody ChatRequest request) {

        String userInput = request.getMessage();
        String userEmail = normalizeEmail(request.getEmail());

        if (userInput == null || userInput.trim().isEmpty()) {
            userInput = "General life decision";
        }

        DecisionResponse response = openAIService.getAdvice(userInput);

        ChatHistory history = new ChatHistory(
                userEmail,
                userInput,
                response.getOverview()
        );

        chatHistoryRepository.save(history);

        return response;
    }

    // =========================
    // HISTORY
    // =========================

    @GetMapping("/history/{email}")
    public List<ChatHistory> getHistory(@PathVariable String email) {
        return chatHistoryRepository.findByUserEmailOrderByIdDesc(normalizeEmail(email));
    }

    private String normalizeEmail(String email) {
        if (email == null || email.trim().isEmpty()) {
            return DEFAULT_HISTORY_EMAIL;
        }

        return email.trim().toLowerCase();
    }

    // =========================
    // PDF DOWNLOAD
    // =========================

    @PostMapping("/pdf")
    public ResponseEntity<byte[]> generatePdf(@RequestBody DecisionResponse data) {

        try {

            byte[] pdf = pdfService.generatePdf(data);

            return ResponseEntity.ok()
                    .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=decision-report.pdf")
                    .contentType(MediaType.APPLICATION_PDF)
                    .body(pdf);

        } catch (Exception e) {

            e.printStackTrace();
            return ResponseEntity.internalServerError().build();

        }
    }
}
