package com.alura.converter.service;

import com.alura.converter.domain.Conversion;

/**
 * Abstração para serviços de taxa de câmbio.
 */
public interface ExchangeRateService {

    /**
     * Converte um valor de uma moeda para outra.
     *
     * @param from Sigla de origem (ex: "USD")
     * @param to Sigla de destino (ex: "BRL")
     * @param amount Valor a converter
     * @return Objeto Conversion contendo o resultado
     * @throws Exception em caso de falha na requisição ou parsing
     */
    Conversion convert(String from, String to, double amount) throws Exception;
}
