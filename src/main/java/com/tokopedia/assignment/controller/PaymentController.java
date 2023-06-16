package com.tokopedia.assignment.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.tokopedia.assignment.payloads.request.CreatePaymentRequest;
import com.tokopedia.assignment.payloads.request.UpdatePaymentRequest;
import com.tokopedia.assignment.payloads.response.MessageResponse;
import com.tokopedia.assignment.payloads.response.PaymentPageResponse;
import com.tokopedia.assignment.payloads.response.PaymentResponse;
import com.tokopedia.assignment.service.PaymentService;

@RestController
public class PaymentController {
    
    @Autowired
    PaymentService paymentService;

    @PostMapping("/payment")
    public ResponseEntity<PaymentResponse> createPaymentRecord(@RequestBody CreatePaymentRequest paymentRequest) {
        PaymentResponse paymentResponse = paymentService.createPayment(paymentRequest);
        return new ResponseEntity<PaymentResponse>(paymentResponse, HttpStatus.OK);
    }

    @GetMapping("/payment/{paymentId}")
    public ResponseEntity<PaymentResponse> getPaymentRecordByPaymentId(@PathVariable Integer paymentId) {
        PaymentResponse paymentResponse = paymentService.getPayment(paymentId);
        return new ResponseEntity<PaymentResponse>(paymentResponse, HttpStatus.OK);
    }

    @PutMapping("/payment")
    public ResponseEntity<PaymentResponse> updatePaymentRecord(@RequestBody UpdatePaymentRequest updatePaymentRequest) {
        PaymentResponse paymentResponse = paymentService.updatePayment(updatePaymentRequest);
        return new ResponseEntity<PaymentResponse>(paymentResponse, HttpStatus.OK);
    }

    @DeleteMapping("/payment/{paymentId}")
    public ResponseEntity<MessageResponse> deletePaymentRecord(@PathVariable Integer paymentId) {
        MessageResponse messageResponse = paymentService.deletePayment(paymentId);
        return new ResponseEntity<MessageResponse>(messageResponse, HttpStatus.OK);
    }

    @GetMapping("/payment/{customerId}/{paymentTypeId}")
    public ResponseEntity<PaymentPageResponse> getPaymentRecords(
        @PathVariable Integer customerId,
        @PathVariable Integer paymentTypeId,
        @RequestParam(defaultValue = "1", value = "page") Integer page,
        @RequestParam(defaultValue = "10", value = "page_size") Integer pageSize,
        @RequestParam(required = false, value = "amount") Integer amount
    ) {
        PaymentPageResponse paymentPageResponse = paymentService.getPayments(page, pageSize, customerId, paymentTypeId, amount);

        return new ResponseEntity<PaymentPageResponse>(paymentPageResponse, HttpStatus.OK);
    }
}
