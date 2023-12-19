package com.com.demo_bank_v1.models;


import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.UUID;

@Entity
@Table(name = "v_payments")
public class PaymentHistory {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
//    @Column(name = "payment_id", nullable = false, columnDefinition = "BIGINT DEFAULT 1")
    private int payment_id;
    private int account_id;
    private int user_id;
    private String beneficiary;
    private String beneficiary_acc_no;
    private double amount;
    private String status;
    private String reference_no;
    private String reason_code;
    private LocalDateTime created_at;

    public PaymentHistory(int payment_id, int account_id, int user_id, String beneficiary, String beneficiary_acc_no, double amount, String status, String reference_no, String reason_code, LocalDateTime created_at) {
        this.payment_id = payment_id;
        this.account_id = account_id;
        this.user_id = user_id;
        this.beneficiary = beneficiary;
        this.beneficiary_acc_no = beneficiary_acc_no;
        this.amount = amount;
        this.status = status;
        this.reference_no = reference_no;
        this.reason_code = reason_code;
        this.created_at = created_at;
    }

    public int getPayment_id() {
        return payment_id;
    }

    public void setPayment_id(int payment_id) {
        this.payment_id = payment_id;
    }

    public int getAccount_id() {
        return account_id;
    }

    public void setAccount_id(int account_id) {
        this.account_id = account_id;
    }

    public int getUser_id() {
        return user_id;
    }

    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }

    public String getBeneficiary() {
        return beneficiary;
    }

    public void setBeneficiary(String beneficiary) {
        this.beneficiary = beneficiary;
    }

    public String getBeneficiary_acc_no() {
        return beneficiary_acc_no;
    }

    public void setBeneficiary_acc_no(String beneficiary_acc_no) {
        this.beneficiary_acc_no = beneficiary_acc_no;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getReference_no() {
        return reference_no;
    }

    public void setReference_no(String reference_no) {
        this.reference_no = reference_no;
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
