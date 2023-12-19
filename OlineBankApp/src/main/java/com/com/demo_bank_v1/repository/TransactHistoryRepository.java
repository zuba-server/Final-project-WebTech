package com.com.demo_bank_v1.repository;

import com.com.demo_bank_v1.models.TransactionHistory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

@Repository
public interface TransactHistoryRepository extends JpaRepository<TransactionHistory, Integer> {

    @Query(value = "SELECT * FROM v_transaction_history", nativeQuery = true)
    List<TransactionHistory> getTransactionRecordsById(@Param("user_id") int userID);

    @Transactional
    @Modifying
    @Query(value = "DELETE FROM v_transaction_history WHERE user_id = :user_id", nativeQuery = true)
    void deleteTransactionRecordsById(@Param("user_id") int userID);
//    @Transactional
//    @Modifying
//    @Query(value = "UPDATE v_transaction_history SET transaction_type = :transactionType, amount = :amount, source = :source, status = :status, reason_code = :reasonCode, created_at = :createdAt WHERE user_id = :userId", nativeQuery = true)
//    void updateTransactionRecordsById(
//            @Param("account_id") int account_id,
//            @Param("transaction_type") String transactionType,
//            @Param("amount") BigDecimal amount,
//            @Param("source") String source,
//            @Param("status") String status,
//            @Param("reason_code") String reasonCode,
//            @Param("created_at") LocalDateTime createdAt
//    );


}