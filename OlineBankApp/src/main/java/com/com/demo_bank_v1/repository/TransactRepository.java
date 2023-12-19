package com.com.demo_bank_v1.repository;

import com.com.demo_bank_v1.models.Transact;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.UUID;

@Repository
public interface TransactRepository extends CrudRepository<Transact, Integer> {

    @Modifying
    @Transactional
    @Query(value = "INSERT INTO v_transaction_history(account_id, transaction_type, amount, source, status, reason_code, created_at)" +
            "VALUES(:account_id, :transact_type, :amount, :source, :status, :reason_code, :created_at)", nativeQuery = true)
    void logTransaction(@Param("account_id")int account_id,
                        @Param("transact_type")String transact_type,
                        @Param("amount")double amount,
                        @Param("source")String source,
                        @Param("status")String status,
                        @Param("reason_code")String reason_code,
                        @Param("created_at") LocalDateTime created_at);


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



