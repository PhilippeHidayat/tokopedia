package com.tokopedia.assignment.payloads.request;

public class UpdatePaymentRequest {
    private Integer paymentId;
    private Integer amount;
    private Integer paymentTypeId;
    private Integer customerId;

    public UpdatePaymentRequest(Integer paymentId, Integer amount, Integer paymentTypeId,
            Integer customerId) {
        this.paymentId = paymentId;
        this.amount = amount;
        this.paymentTypeId = paymentTypeId;
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

    public Integer getCustomerId() {
        return customerId;
    }

    public void setCustomerId(Integer customerId) {
        this.customerId = customerId;
    }
    
    
}
