package com.demo.models;

public record PaymentRequest(double amount, String currency, String description, 
                             String cardNumber, String cardExpiry, String cardCVC) {}
