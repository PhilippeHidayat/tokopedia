package com.tokopedia.assignment.payloads.request;

public class CreatePaymentRequest {
    private Integer amount;
    private Integer paymentTypeId;
    private Integer customerId;
    
    public CreatePaymentRequest(Integer amount, Integer paymentTypeId, Integer customerId) {
        this.amount = amount;
        this.paymentTypeId = paymentTypeId;
        this.customerId = customerId;
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

    public Integer getCustomerId() {
        return customerId;
    }

    public void setCustomerId(Integer customerId) {
        this.customerId = customerId;
    }

    
}
