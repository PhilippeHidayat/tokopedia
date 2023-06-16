package com.tokopedia.assignment.models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "payment")
public class Payment {
    
    @Id @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "payment_id")
    private Integer paymentId;
    @Column(name = "amount")
    private Integer amount;
    @Column(name = "payment_type_id")
    private Integer paymentTypeId;
    @Column(name = "date")
    private Long date;
    @Column(name = "customer_id")
    private Integer customerId;
    
    public Payment() {
    }

    public Payment(Integer amount, Integer paymentTypeId, Long date, Integer customerId) {
        this.amount = amount;
        this.paymentTypeId = paymentTypeId;
        this.date = date;
        this.customerId = customerId;
    }

    public Integer getPaymentId() {
        return paymentId;
    }

    public void setPaymentId(Integer paymentId) {
        this.paymentId = paymentId;
    }

    public Integer getAmount() {
        return amount;
    }

    public void setAmount(Integer amount) {
        this.amount = amount;
    }

    public Integer getPaymentTypeId() {
        return paymentTypeId;
    }

    public void setPaymentTypeId(Integer paymentTypeId) {
        this.paymentTypeId = paymentTypeId;
    }

    public Long getDate() {
        return date;
    }

    public void setDate(Long date) {
        this.date = date;
    }

    public Integer getCustomerId() {
        return customerId;
    }

    public void setCustomerId(Integer customerId) {
        this.customerId = customerId;
    }

}
