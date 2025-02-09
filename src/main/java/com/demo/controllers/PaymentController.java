package com.demo.controllers;

import com.demo.models.PaymentRequest;
import com.demo.models.PaymentResponse;
import com.demo.services.PaymentService;
import com.demo.services.MockPaymentService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/payments")
public class PaymentController {

    private final PaymentService paymentService = new MockPaymentService();

    @PostMapping("/process")
    public ResponseEntity<PaymentResponse> processPayment(@RequestBody PaymentRequest request) {
        PaymentResponse response = paymentService.processPayment(request);
        return ResponseEntity.ok(response);
    }

    @GetMapping("/{id}")
    public ResponseEntity<PaymentResponse> getPaymentStatus(@PathVariable String id) {
        PaymentResponse response = paymentService.getPaymentStatus(id);
        if (response == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(response);
    }

    @GetMapping
    public ResponseEntity<List<PaymentResponse>> listPayments() {
        List<PaymentResponse> payments = paymentService.listPayments();
        return ResponseEntity.ok(payments);
    }

    @PostMapping("/refund/{id}")
    public ResponseEntity<PaymentResponse> refundPayment(@PathVariable String id) {
        PaymentResponse response = paymentService.refundPayment(id);
        if (response == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(response);
    }
}
