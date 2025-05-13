package com.alura.converter.ui;

import com.alura.converter.model.Currency;
import com.alura.converter.domain.Conversion;
import com.alura.converter.service.ExchangeRateApiService;
import com.alura.converter.service.ExchangeRateService;

import java.util.InputMismatchException;
import java.util.Locale;
import java.util.Scanner;

public class ConsoleApp {

    private static final Scanner SC = new Scanner(System.in).useLocale(Locale.US); // ponto decimal

    public static void main(String[] args) {
        ExchangeRateService service = new ExchangeRateApiService();

        while (true) {
            System.out.println("\n=== Conversor de Moedas ===");
            // exibe o menu
            for (int i = 0; i < Currency.values().length; i++) {
                System.out.printf("%d) %s%n", i + 1, Currency.values()[i]);
            }
            System.out.println("0) Sair");

            int fromIdx = readIndex("Escolha moeda origem: ");
            if (fromIdx == 0) break;

            int toIdx   = readIndex("Escolha moeda destino: ");
            if (toIdx == 0) break;

            double amount = readAmount("Digite o valor a converter: ");

            try {
                Conversion result = service.convert(
                        Currency.values()[fromIdx - 1].name(),
                        Currency.values()[toIdx - 1].name(),
                        amount
                );
                System.out.println("\nResultado => " + result);
            } catch (Exception e) {
                System.err.println("Erro: " + e.getMessage());
            }
        }

        System.out.println("Programa encerrado.");
    }

    private static int readIndex(String prompt) {
        while (true) {
            try {
                System.out.print(prompt);
                int idx = SC.nextInt();
                if (idx >= 0 && idx <= Currency.values().length) return idx;
                System.out.println("Informe um número entre 0 e " + Currency.values().length + ".");
            } catch (InputMismatchException ex) {
                System.out.println("Entrada inválida. Digite apenas números.");
                SC.nextLine(); // limpa buffer
            }
        }
    }

    private static double readAmount(String prompt) {
        while (true) {
            try {
                System.out.print(prompt);
                double value = SC.nextDouble();
                if (value > 0) return value;
                System.out.println("Valor precisa ser positivo.");
            } catch (InputMismatchException ex) {
                System.out.println("Entrada inválida. Use ponto como separador decimal (ex.: 55.75).");
                SC.nextLine();
            }
        }
    }
}

