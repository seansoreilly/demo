package com.demo.services;

import com.demo.models.PaymentRequest;
import com.demo.models.PaymentResponse;

import java.util.List;

public interface PaymentService {
    PaymentResponse processPayment(PaymentRequest request);
    PaymentResponse getPaymentStatus(String paymentId);
    PaymentResponse refundPayment(String paymentId);
    List<PaymentResponse> listPayments();
}
