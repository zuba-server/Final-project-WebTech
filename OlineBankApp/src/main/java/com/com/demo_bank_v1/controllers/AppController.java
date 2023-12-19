package com.com.demo_bank_v1.controllers;

import com.com.demo_bank_v1.models.Account;
import com.com.demo_bank_v1.models.PaymentHistory;
import com.com.demo_bank_v1.models.TransactionHistory;
import com.com.demo_bank_v1.models.User;
import com.com.demo_bank_v1.repository.AccountRepository;
import com.com.demo_bank_v1.repository.PaymentHistoryRepository;
import com.com.demo_bank_v1.repository.TransactHistoryRepository;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import javax.servlet.http.HttpSession;

import java.math.BigDecimal;
import java.util.List;

@Controller
@RequestMapping("/app")
public class AppController {

    private final AccountRepository accountRepository;

    private final PaymentHistoryRepository paymentHistoryRepository;

    private final TransactHistoryRepository transactHistoryRepository;

    User user;

    public AppController(AccountRepository accountRepository, PaymentHistoryRepository paymentHistoryRepository, TransactHistoryRepository transactHistoryRepository) {
        this.accountRepository = accountRepository;
        this.paymentHistoryRepository = paymentHistoryRepository;
        this.transactHistoryRepository = transactHistoryRepository;
    }

    @GetMapping("/dashboard")
    public String getDashboard(HttpSession session, Model model) {
        // Get the details of the logged-in user:
        user = (User) session.getAttribute("user");

        // Get The Accounts Of The Logged In User:
        List<Account> getUserAccounts = accountRepository.getUserAccountsById(user.getUser_id());

        // Get Balance:
        BigDecimal totalAccountsBalance = accountRepository.getTotalBalance(user.getUser_id());

        // Set Objects:
        model.addAttribute("userAccounts", getUserAccounts);
        model.addAttribute("totalBalance", totalAccountsBalance);

        return "dashboard";
    }

    @GetMapping("/payment_history")
    public String getPaymentHistory(HttpSession session, Model model) {
        // Get Logged In User:
        user = (User) session.getAttribute("user");

        // Get Payment History / Records:
        List<PaymentHistory> userPaymentHistory = paymentHistoryRepository.getPaymentRecordsById(user.getUser_id());

        model.addAttribute("payment_history", userPaymentHistory);

        return "paymentHistory";
    }

    @GetMapping("/transact_history")
    public String getTransactHistory(HttpSession session, Model model) {
        // Get Logged In User:
        user = (User) session.getAttribute("user");

        // Get Payment History / Records:
        List<TransactionHistory> userTransactHistory = transactHistoryRepository.getTransactionRecordsById(user.getUser_id());

        model.addAttribute("transact_history", userTransactHistory);

        return "transactHistory";
    }

}
