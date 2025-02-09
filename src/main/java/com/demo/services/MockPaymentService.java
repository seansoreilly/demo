package com.demo.services;

import com.demo.models.PaymentRequest;
import com.demo.models.PaymentResponse;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;
import java.util.List;
import java.util.stream.Collectors;

public class MockPaymentService implements PaymentService {

    private final Map<String, PaymentResponse> paymentRecords = new HashMap<>();

    @Override
    public PaymentResponse processPayment(PaymentRequest request) {
        String paymentId = UUID.randomUUID().toString();
        PaymentResponse response = new PaymentResponse();
        response.setId(paymentId);
        response.setStatus("SUCCESS");
        response.setAmount(request.getAmount());
        response.setTimestamp(LocalDateTime.now());

        paymentRecords.put(paymentId, response);
        return response;
}

public List<PaymentResponse> listPayments() {
    return paymentRecords.values().stream().collect(Collectors.toList());
}

    @Override
    public PaymentResponse getPaymentStatus(String paymentId) {
        return paymentRecords.getOrDefault(paymentId, null);
    }

    @Override
    public PaymentResponse refundPayment(String paymentId) {
        PaymentResponse response = paymentRecords.get(paymentId);
        if (response != null) {
            response.setStatus("REFUNDED");
            response.setTimestamp(LocalDateTime.now());
        }
        return response;
    }
}
