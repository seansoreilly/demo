package com.demo.models;

import java.time.LocalDateTime;

public record PaymentResponse(String id, String status, double amount, LocalDateTime timestamp) {}
