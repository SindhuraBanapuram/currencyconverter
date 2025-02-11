package com.example.currencyconverter.service;

import com.example.currencyconverter.dto.ExchangeRateResponse;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import java.util.Map;

@Service
public class ExchangeRateService {
    @Value("${exchange.api.url}")
    private String exchangeApiUrl;

    private final RestTemplate restTemplate = new RestTemplate();

    public Map<String, Double> getExchangeRates(String baseCurrency) {
        String url = exchangeApiUrl + baseCurrency;
        ExchangeRateResponse response = restTemplate.getForObject(url, ExchangeRateResponse.class);
        if (response != null) {
            return response.getRates();
        }
        throw new RuntimeException("Failed to fetch exchange rates");
    }
}
