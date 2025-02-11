package com.example.currencyconverter.controller;

import com.example.currencyconverter.dto.CurrencyConversionRequest;
import com.example.currencyconverter.dto.CurrencyConversionResponse;
import com.example.currencyconverter.service.CurrencyConverterService;
import com.example.currencyconverter.service.ExchangeRateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import jakarta.validation.Valid;
import java.util.Map;

@RestController
@RequestMapping("/api")
public class CurrencyConverterController {
    @Autowired
    private ExchangeRateService exchangeRateService;

    @Autowired
    private CurrencyConverterService currencyConverterService;

    @GetMapping("/rates")
    public Map<String, Double> getExchangeRates(@RequestParam(defaultValue = "USD") String base) {
        return exchangeRateService.getExchangeRates(base.toUpperCase());
    }

    @PostMapping("/convert")
    public CurrencyConversionResponse convertCurrency(@Valid @RequestBody CurrencyConversionRequest request) {
        return currencyConverterService.convertCurrency(request);
    }
}
