package com.alura.converter.model;

public class CurrencyTest {
    public static void main(String[] args) {
        System.out.println(Currency.contains("usd")); // deve imprimir true
        System.out.println(Currency.contains("BRL")); // deve imprimir true
        System.out.println(Currency.contains("xyz")); // deve imprimir false
    }
}
