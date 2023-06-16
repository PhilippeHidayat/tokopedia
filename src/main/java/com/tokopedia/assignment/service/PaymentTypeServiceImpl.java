package com.tokopedia.assignment.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.tokopedia.assignment.models.PaymentType;
import com.tokopedia.assignment.payloads.response.PaymentTypeResponse;
import com.tokopedia.assignment.repository.PaymentTypeRepository;

public class PaymentTypeServiceImpl implements PaymentTypeService {

    @Autowired
    PaymentTypeRepository paymentTypeRepository;

    @Override
    public PaymentTypeResponse getPaymentTypeList() {
        List<PaymentType> paymentTypeList = paymentTypeRepository.findAll();
        return new PaymentTypeResponse(true, paymentTypeList);
    }
    
}
