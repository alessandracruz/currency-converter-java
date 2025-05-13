package com.alura.converter.domain;

import com.alura.converter.model.Currency;

public class ConversionTest {
    public static void main(String[] args) {
        // exemplo: 100 USD → BRL com taxa 5.2
        Conversion c = new Conversion(Currency.USD, Currency.BRL, 5.2, 100);
        System.out.println(c);
    }
}

