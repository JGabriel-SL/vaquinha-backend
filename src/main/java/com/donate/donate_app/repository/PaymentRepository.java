package com.donate.donate_app.repository;

import com.donate.donate_app.entity.Payment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface PaymentRepository extends JpaRepository<Payment, Long> {
    @Query("SELECT p FROM Payment p WHERE p.id_payment = :id_payment")
    Payment findByIdPayment(@Param("id_payment") String id_payment);
}
