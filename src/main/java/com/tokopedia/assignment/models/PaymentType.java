package com.tokopedia.assignment.models;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "payment_type")
public class PaymentType {
    
    @Id @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer paymentTypeId;
    private String typeName;
    
    public PaymentType() {
    }

    public PaymentType(String typeName) {
        this.typeName = typeName;
    }

    public Integer getPaymentTypeId() {
        return paymentTypeId;
    }

    public void setPaymentTypeId(Integer paymentTypeId) {
        this.paymentTypeId = paymentTypeId;
    }

    public String getTypeName() {
        return typeName;
    }

    public void setTypeName(String typeName) {
        this.typeName = typeName;
    }

    
}
