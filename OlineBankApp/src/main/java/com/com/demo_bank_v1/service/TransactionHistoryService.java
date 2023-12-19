package com.com.demo_bank_v1.service;

import com.com.demo_bank_v1.models.TransactionHistory;
import com.com.demo_bank_v1.repository.TransactHistoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

@Service
public class TransactionHistoryService {

    private final TransactHistoryRepository transactHistoryRepository;

    @Autowired
    public TransactionHistoryService(TransactHistoryRepository transactHistoryRepository) {
        this.transactHistoryRepository = transactHistoryRepository;
    }

    public List<TransactionHistory> getTransactionRecordsById(int userID) {
        return transactHistoryRepository.getTransactionRecordsById(userID);
    }

    public void deleteTransactionRecordsById(int userID) {
        transactHistoryRepository.deleteTransactionRecordsById(userID);
    }



//    public void updateTransactionRecordsById(
//            int userId,
//            String transactionType,
//            BigDecimal amount,
//            String source,
//            String status,
//            String reasonCode,
//            LocalDateTime createdAt
//    ) {
//        transactHistoryRepository.updateTransactionRecordsById(
//                userId,
//                transactionType,
//                amount,
//                source,
//                status,
//                reasonCode,
//                createdAt
//        );
    }

