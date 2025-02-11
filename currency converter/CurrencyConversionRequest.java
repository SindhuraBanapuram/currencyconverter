package com.example.currencyconverter.dto;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class CurrencyConversionRequest {
    @NotBlank(message = "Source currency is required")
    private String from;

    @NotBlank(message = "Target currency is required")
    private String to;

    @Min(value = 1, message = "Amount must be greater than zero")
    private double amount;
}
