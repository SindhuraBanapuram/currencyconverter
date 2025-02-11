package com.example.currencyconverter.service;

import com.example.currencyconverter.dto.CurrencyConversionRequest;
import com.example.currencyconverter.dto.CurrencyConversionResponse;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

import java.util.Map;

class CurrencyConverterServiceTest {
    private final ExchangeRateService exchangeRateService = mock(ExchangeRateService.class);
    private final CurrencyConverterService currencyConverterService = new CurrencyConverterService(exchangeRateService);

    @Test
    void testConvertCurrency() {
        // Mock exchange rate
        when(exchangeRateService.getExchangeRates("USD")).thenReturn(Map.of("EUR", 0.94));

        // Create request
        CurrencyConversionRequest request = new CurrencyConversionRequest();
        request.setFrom("USD");
        request.setTo("EUR");
        request.setAmount(100);

        // Test conversion
        CurrencyConversionResponse response = currencyConverterService.convertCurrency(request);
        assertEquals(94.0, response.getConvertedAmount());
    }
}
