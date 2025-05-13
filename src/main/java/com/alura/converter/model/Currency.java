package com.alura.converter.model;

/**
 * Enum com as siglas das moedas suportadas pelo conversor.
 */
public enum Currency {
    USD,  // Dólar americano
    BRL,  // Real brasileiro
    EUR,  // Euro
    GBP,  // Libra esterlina
    JPY,  // Iene japonês
    ARS,  // Peso argentino
    COP;  // Peso colombiano

    /**
     * Verifica se uma sigla existe neste enum.
     * @param code sigla (ex: "usd", "BRL")
     * @return true se for válida
     */
    public static boolean contains(String code) {
        try {
            Currency.valueOf(code.toUpperCase());
            return true;
        } catch (IllegalArgumentException ex) {
            return false;
        }
    }
}

