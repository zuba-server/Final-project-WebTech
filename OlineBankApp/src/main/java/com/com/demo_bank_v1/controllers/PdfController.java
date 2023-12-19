//package com.com.demo_bank_v1.controllers;
//import com.com.demo_bank_v1.models.TransactionHistory;
//import com.com.demo_bank_v1.service.TransactionHistoryService;
//import com.com.demo_bank_v1.service.TransactionsHistoryService;
//import com.itextpdf.text.Document;
//import com.itextpdf.text.DocumentException;
//import com.itextpdf.text.Paragraph;
//import com.itextpdf.text.pdf.PdfWriter;
//import org.springframework.stereotype.Controller;
//import org.springframework.web.bind.annotation.GetMapping;
//
//import javax.servlet.http.HttpServletResponse;
//import java.io.IOException;
//import java.util.List;
//
//@Controller
//public class PdfController {
//
//    private TransactionsHistoryService transactionsHistoryService;
//
//    public PdfController(TransactionHistoryService transactionHistoryService) {
//        this.transactionsHistoryService = transactionsHistoryService;
//    }
//
//    @GetMapping("/download-transaction-history-pdf")
//    public void downloadTransactionHistoryPdf(HttpServletResponse response) throws IOException, DocumentException {
//        response.setContentType("application/pdf");
//        response.setHeader("Content-Disposition", "attachment; filename=transaction_history.pdf");
//
//        List<TransactionHistory> transactionHistoryList = transactionsHistoryService.getAllTransactions();
//
//        Document document = new Document();
//        PdfWriter.getInstance(document, response.getOutputStream());
//
//        document.open();
//
//        for (TransactionHistory transaction : transactionHistoryList) {
//            document.add(new Paragraph("User ID: " + transaction.getUser_id()));
//            document.add(new Paragraph("Transaction Type: " + transaction.getTransaction_type()));
//            document.add(new Paragraph("Amount: " + transaction.getAmount()));
//            document.add(new Paragraph("Source: " + transaction.getSource()));
//            document.add(new Paragraph("Status: " + transaction.getStatus()));
//            document.add(new Paragraph("Reason Code: " + transaction.getReason_code()));
//            document.add(new Paragraph("Created at: " + transaction.getCreated_at()));
//            document.add(new Paragraph("")); // Add an empty line between transactions
//        }
//
//        document.close();
//    }
//}
