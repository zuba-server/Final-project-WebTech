//package com.com.demo_bank_v1.implementation;
//
//import com.com.demo_bank_v1.models.TransactionHistory;
//import com.com.demo_bank_v1.repository.TransactionsHistoryRepo;
//import com.com.demo_bank_v1.service.TransactionsHistoryService;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Service;
//
//import java.util.List;
//
//@Service
//public class TransactionsHistoryServiceImpl implements TransactionsHistoryService {
//
//    private final TransactionsHistoryRepo transactionsHistoryRepo;
//
//    @Autowired
//    public TransactionsHistoryServiceImpl(TransactionsHistoryRepo transactionHistoryRepo) {
//        this.transactionsHistoryRepo = transactionHistoryRepo;
//    }
//
//    @Override
//    public List<TransactionHistory> getAllTransactions() {
//        return transactionsHistoryRepo.findAll();
//    }
//}
