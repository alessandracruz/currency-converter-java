package com.alura.converter.service;

import com.alura.converter.domain.Conversion;

public class ServiceTest {
    public static void main(String[] args) throws Exception {
        // antes de rodar, certifique-se de ter:
        // export ER_API_KEY=sua_chave_aqui
        ExchangeRateService service = new ExchangeRateApiService();
        Conversion c = service.convert("USD", "BRL", 100);
        System.out.println(c);
    }
}

