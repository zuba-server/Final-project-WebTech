package com.com.demo_bank_v1.controllers;

import com.com.demo_bank_v1.models.TransactionHistory;
import com.com.demo_bank_v1.service.TransactionHistoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Controller
@RequestMapping("/transaction")
public class TransactionController {

    private final TransactionHistoryService transactHistoryService;

    @Autowired
    public TransactionController(TransactionHistoryService transactHistoryService) {
        this.transactHistoryService = transactHistoryService;
    }
    @GetMapping("/delete/{userId}")
    public ResponseEntity<String> deleteTransactionRecords(@PathVariable("userId") String userId) {
        try {
            int userIdInt = Integer.parseInt(userId);
            transactHistoryService.deleteTransactionRecordsById(userIdInt);
            return ResponseEntity.ok("Transaction records deleted successfully!");
        } catch (NumberFormatException e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Invalid user ID format");
        }
    }
}

