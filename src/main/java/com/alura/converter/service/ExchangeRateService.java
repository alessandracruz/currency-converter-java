package com.alura.converter.service;

import com.alura.converter.domain.Conversion;

/**
 * Contrato para serviços de taxa de câmbio.
 */
public interface ExchangeRateService {

    /**
     * Converte um valor entre duas moedas.
     *
     * @param from   sigla da moeda de origem (ex.: USD)
     * @param to     sigla da moeda de destino (ex.: BRL)
     * @param amount valor a converter
     * @return objeto Conversion com resultado e metadados
     * @throws Exception quando ocorrer falha de rede ou parsing
     */
    Conversion convert(String from, String to, double amount) throws Exception;
}

