package com.tokopedia.assignment.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.tokopedia.assignment.models.Payment;

@Repository
public interface PaymentRepository extends JpaRepository<Payment, Integer> {
    
    Page<Payment> findAll(Specification<Payment> specs, Pageable pageable);
}
