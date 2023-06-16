package com.tokopedia.assignment.payloads.response;

import java.util.List;

import com.tokopedia.assignment.models.Payment;

public class PaymentPageResponse {
    private Boolean result;
    private List<Payment> paymentList;
    private Integer currentPage;
    private Integer totalItems;
    private Integer totalPages;
    
    public PaymentPageResponse(Boolean result, List<Payment> paymentList, Integer currentPage, Integer totalItems,
            Integer totalPages) {
        this.result = result;
        this.paymentList = paymentList;
        this.currentPage = currentPage;
        this.totalItems = totalItems;
        this.totalPages = totalPages;
    }

    public Boolean getResult() {
        return result;
    }

    public void setResult(Boolean result) {
        this.result = result;
    }

    public List<Payment> getPaymentList() {
        return paymentList;
    }

    public void setPaymentList(List<Payment> paymentList) {
        this.paymentList = paymentList;
    }

    public Integer getCurrentPage() {
        return currentPage;
    }

    public void setCurrentPage(Integer currentPage) {
        this.currentPage = currentPage;
    }

    public Integer getTotalItems() {
        return totalItems;
    }

    public void setTotalItems(Integer totalItems) {
        this.totalItems = totalItems;
    }

    public Integer getTotalPages() {
        return totalPages;
    }

    public void setTotalPages(Integer totalPages) {
        this.totalPages = totalPages;
    }
    
    
}
