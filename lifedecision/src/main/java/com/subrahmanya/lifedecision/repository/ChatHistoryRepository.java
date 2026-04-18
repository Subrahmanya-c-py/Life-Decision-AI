package com.subrahmanya.lifedecision.repository;

import com.subrahmanya.lifedecision.model.ChatHistory;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface ChatHistoryRepository extends JpaRepository<ChatHistory, Long> {
    List<ChatHistory> findByUserEmailOrderByIdDesc(String userEmail);
}
