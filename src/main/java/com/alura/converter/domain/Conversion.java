package com.alura.converter.domain;

import com.alura.converter.model.Currency;

/**
 * Representa o resultado de uma conversão entre duas moedas.
 */
public class Conversion {

    private final Currency from;         // moeda de origem
    private final Currency to;           // moeda de destino
    private final double rate;           // taxa de conversão
    private final double originalAmount; // valor antes da conversão
    private final double convertedAmount;// valor após aplicar a taxa

    /**
     * Construtor principal.
     *
     * @param from Moeda de origem (enum Currency)
     * @param to Moeda de destino (enum Currency)
     * @param rate Taxa de câmbio (ex: 5.20)
     * @param originalAmount Valor a ser convertido
     */
    public Conversion(Currency from, Currency to, double rate, double originalAmount) {
        this.from = from;
        this.to = to;
        this.rate = rate;
        this.originalAmount = originalAmount;
        this.convertedAmount = originalAmount * rate;
    }

    // Getters

    public Currency getFrom() {
        return from;
    }

    public Currency getTo() {
        return to;
    }

    public double getRate() {
        return rate;
    }

    public double getOriginalAmount() {
        return originalAmount;
    }

    public double getConvertedAmount() {
        return convertedAmount;
    }

    @Override
    public String toString() {
        return String.format(
                "%.2f %s = %.2f %s (rate: %.4f)",
                originalAmount, from, convertedAmount, to, rate
        );
    }
}

