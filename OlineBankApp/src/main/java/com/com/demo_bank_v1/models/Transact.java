package com.com.demo_bank_v1.models;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.UUID;

@Entity
public class Transact {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
//    @Column(name = "transaction_id", nullable = false, columnDefinition = "BIGINT DEFAULT 1")
    private int transaction_id;
    private int account_id;
    private String transaction_type;
    private double amount;
    private String source;
    private String status;
    private String reason_code;
    private LocalDateTime created_at;

    public Transact(int transaction_id, int account_id, String transaction_type, double amount, String source, String status, String reason_code, LocalDateTime created_at) {
        this.transaction_id = transaction_id;
        this.account_id = account_id;
        this.transaction_type = transaction_type;
        this.amount = amount;
        this.source = source;
        this.status = status;
        this.reason_code = reason_code;
        this.created_at = created_at;
    }

    public int getTransaction_id() {
        return transaction_id;
    }

    public void setTransaction_id(int transaction_id) {
        this.transaction_id = transaction_id;
    }

    public int getAccount_id() {
        return account_id;
    }

    public void setAccount_id(int account_id) {
        this.account_id = account_id;
    }

    public String getTransaction_type() {
        return transaction_type;
    }

    public void setTransaction_type(String transaction_type) {
        this.transaction_type = transaction_type;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public String getSource() {
        return source;
    }

    public void setSource(String source) {
        this.source = source;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getReason_code() {
        return reason_code;
    }

    public void setReason_code(String reason_code) {
        this.reason_code = reason_code;
    }

    public LocalDateTime getCreated_at() {
        return created_at;
    }

    public void setCreated_at(LocalDateTime created_at) {
        this.created_at = created_at;
    }
}
