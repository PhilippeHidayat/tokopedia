package com.tokopedia.assignment.payloads.response;

import com.tokopedia.assignment.models.Payment;

public class PaymentResponse {
    private Boolean result;
    private Payment payment;
    
    public PaymentResponse(Boolean result, Payment payment) {
        this.result = result;
        this.payment = payment;
    }

    public Boolean getResult() {
        return result;
    }

    public void setResult(Boolean result) {
        this.result = result;
    }

    public Payment getPayment() {
        return payment;
    }

    public void setPayment(Payment payment) {
        this.payment = payment;
    }

    
}
