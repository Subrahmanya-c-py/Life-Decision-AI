package com.subrahmanya.lifedecision.service;

import com.subrahmanya.lifedecision.dto.DecisionResponse;
import com.itextpdf.text.*;
import com.itextpdf.text.pdf.*;

import org.springframework.stereotype.Service;

import java.io.ByteArrayOutputStream;

@Service
public class PdfService {

    public byte[] generatePdf(DecisionResponse response) throws Exception {

        Document document = new Document(PageSize.A4);
        ByteArrayOutputStream out = new ByteArrayOutputStream();

        PdfWriter.getInstance(document, out);
        document.open();

        Font titleFont = new Font(Font.FontFamily.HELVETICA, 20, Font.BOLD);
        Font sectionFont = new Font(Font.FontFamily.HELVETICA, 14, Font.BOLD);
        Font textFont = new Font(Font.FontFamily.HELVETICA, 12);

        // Title
        Paragraph title = new Paragraph("Life Decision AI - Decision Report", titleFont);
        title.setAlignment(Element.ALIGN_CENTER);
        document.add(title);

        document.add(Chunk.NEWLINE);

        // Sections
        addSection(document, "Executive Summary", response.getOverview(), sectionFont, textFont);
        addSection(document, "Key Factors", response.getFactors(), sectionFont, textFont);
        addSection(document, "Benefits", response.getBenefits(), sectionFont, textFont);
        addSection(document, "Risks", response.getRisks(), sectionFont, textFont);
        addSection(document, "Recommendation", response.getRecommendation(), sectionFont, textFont);

        document.add(Chunk.NEWLINE);

        // Score Table
        PdfPTable table = new PdfPTable(2);
        table.setWidthPercentage(60);

        addScoreRow(table, "Confidence Score", response.getConfidenceScore() + "%");
        addScoreRow(table, "Risk Score", response.getRiskScore() + "%");
        addScoreRow(table, "Growth Score", response.getGrowthScore() + "%");
        addScoreRow(table, "Stability Score", response.getStabilityScore() + "%");
        addScoreRow(table, "Skill Match Score", response.getSkillMatchScore() + "%");

        document.add(table);

        document.close();

        return out.toByteArray();
    }

    private void addSection(Document document, String title, String content,
                            Font titleFont, Font textFont) throws Exception {

        document.add(new Paragraph(title, titleFont));
        document.add(new Paragraph(content != null ? content : "", textFont));
        document.add(Chunk.NEWLINE);
    }

    private void addScoreRow(PdfPTable table, String label, String value) {

        table.addCell(new PdfPCell(new Phrase(label)));
        table.addCell(new PdfPCell(new Phrase(value)));

    }
}