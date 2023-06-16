package com.tokopedia.assignment.payloads.response;

import java.util.List;

import com.tokopedia.assignment.models.PaymentType;

public class PaymentTypeResponse {
    private Boolean result;
    private List<PaymentType> paymentTypeList;
    
    public PaymentTypeResponse(Boolean result, List<PaymentType> paymentTypeList) {
        this.result = result;
        this.paymentTypeList = paymentTypeList;
    }

    public Boolean getResult() {
        return result;
    }

    public void setResult(Boolean result) {
        this.result = result;
    }

    public List<PaymentType> getPaymentTypeList() {
        return paymentTypeList;
    }

    public void setPaymentTypeList(List<PaymentType> paymentTypeList) {
        this.paymentTypeList = paymentTypeList;
    }

    
}
