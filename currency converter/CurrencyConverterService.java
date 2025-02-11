package com.example.currencyconverter.service;

import com.example.currencyconverter.dto.CurrencyConversionRequest;
import com.example.currencyconverter.dto.CurrencyConversionResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.Map;

@Service
public class CurrencyConverterService {
    @Autowired
    private ExchangeRateService exchangeRateService;

    public CurrencyConversionResponse convertCurrency(CurrencyConversionRequest request) {
        Map<String, Double> rates = exchangeRateService.getExchangeRates(request.getFrom().toUpperCase());

        if (!rates.containsKey(request.getTo().toUpperCase())) {
            throw new IllegalArgumentException("Invalid target currency: " + request.getTo());
        }

        double conversionRate = rates.get(request.getTo().toUpperCase());
        double convertedAmount = request.getAmount() * conversionRate;

        return new CurrencyConversionResponse(request.getFrom(), request.getTo(), request.getAmount(), convertedAmount);
    }
}
