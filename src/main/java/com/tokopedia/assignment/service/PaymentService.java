package com.tokopedia.assignment.service;

import org.springframework.stereotype.Component;

import com.tokopedia.assignment.payloads.request.CreatePaymentRequest;
import com.tokopedia.assignment.payloads.request.UpdatePaymentRequest;
import com.tokopedia.assignment.payloads.response.MessageResponse;
import com.tokopedia.assignment.payloads.response.PaymentPageResponse;
import com.tokopedia.assignment.payloads.response.PaymentResponse;

@Component
public interface PaymentService {
    PaymentResponse createPayment(CreatePaymentRequest createPaymentRequest);
    PaymentResponse getPayment(Integer paymentId);
    PaymentResponse updatePayment(UpdatePaymentRequest updatePaymentRequest);
    MessageResponse deletePayment(Integer paymentId);
    PaymentPageResponse getPayments(Integer page, Integer size, Integer customerId, Integer paymentTypeId, Integer amount);
}
