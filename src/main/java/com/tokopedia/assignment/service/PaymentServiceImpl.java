package com.tokopedia.assignment.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import com.tokopedia.assignment.models.Payment;
import com.tokopedia.assignment.payloads.request.CreatePaymentRequest;
import com.tokopedia.assignment.payloads.request.UpdatePaymentRequest;
import com.tokopedia.assignment.payloads.response.MessageResponse;
import com.tokopedia.assignment.payloads.response.PaymentPageResponse;
import com.tokopedia.assignment.payloads.response.PaymentResponse;
import com.tokopedia.assignment.repository.PaymentRepository;

import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Predicate;
import jakarta.persistence.criteria.Root;

@Service
public class PaymentServiceImpl implements PaymentService {
    
    @Autowired
    PaymentRepository paymentRepository;

    @Override
    public PaymentResponse createPayment(CreatePaymentRequest createPaymentRequest) {
        Long currentTime = new Date().getTime();
        Payment payment = new Payment(
            createPaymentRequest.getAmount(),
            createPaymentRequest.getPaymentTypeId(),
            currentTime,
            createPaymentRequest.getCustomerId()
        );

        Payment result = paymentRepository.save(payment);
        return new PaymentResponse(true, result);
    }

    @Override
    public MessageResponse deletePayment(Integer paymentId) {
        if(paymentId == null) {
            return new MessageResponse(false, "Payment Id must not be empty");
        }
        paymentRepository.deleteById(paymentId);
        return new MessageResponse(true, "Success deleting payment data");
    }

    @Override
    public PaymentResponse getPayment(Integer paymentId) {
        Payment payment = paymentRepository.findById(paymentId).orElse(null);
        return new PaymentResponse(payment!=null, payment);
    }

    @Override
    public PaymentResponse updatePayment(UpdatePaymentRequest updatePaymentRequest) {
        PaymentResponse paymentResponse = getPayment(updatePaymentRequest.getPaymentId());
        if(!paymentResponse.getResult()) {
            return new PaymentResponse(false, null);
        }

        Long currentTime = new Date().getTime();
        Payment payment = paymentResponse.getPayment();
        payment.setAmount(updatePaymentRequest.getAmount());
        payment.setPaymentTypeId(updatePaymentRequest.getPaymentTypeId());
        payment.setDate(currentTime);
        payment.setCustomerId(updatePaymentRequest.getCustomerId());
        paymentRepository.save(payment);
        return new PaymentResponse(true, payment);
    }

    @Override
    public PaymentPageResponse getPayments(Integer page, Integer size, Integer customerId, Integer paymentTypeId, Integer amount) {
        Pageable pageable = PageRequest.of(page-1, size);
        Page<Payment> paymentPage = paymentRepository.findAll(paymentFilter(customerId, paymentTypeId, amount),pageable);
        List<Payment> paymentList = paymentPage.getContent().stream().sorted((o1, o2) -> o1.getPaymentId().compareTo(o2.getPaymentId())).collect(Collectors.toList());
        return new PaymentPageResponse(true, paymentList, page, (int) paymentPage.getTotalElements(), paymentPage.getTotalPages());
    }

    protected static Specification<Payment> paymentFilter(Integer customerId, Integer paymentTypeId, Integer amount) {
        return new Specification<Payment>() {
            public Predicate toPredicate(Root<Payment> root, CriteriaQuery<?> query, CriteriaBuilder criteriaBuilder) {
                List<Predicate> predicates = new ArrayList<>();

                if(customerId != null) {
                    predicates.add(criteriaBuilder.equal(root.get("customerId"), customerId));
                }
                if(paymentTypeId != null) {
                    predicates.add(criteriaBuilder.equal(root.get("paymentTypeId"), paymentTypeId));
                }
                if(amount != null) {
                    predicates.add(criteriaBuilder.equal(root.get("amount"), amount));
                }

                return criteriaBuilder.and(predicates.toArray(new Predicate[0]));
            }
        };
    }
}
