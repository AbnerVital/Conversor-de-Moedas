package br.com.alura.conversor.ui;

import br.com.alura.conversor.exception.ErroDeMoedaException;
import br.com.alura.conversor.servico.ConversorDeMoeda;

import java.util.Scanner;

public class MenuDeMoedas {

    private final ConversorDeMoeda conversor = new ConversorDeMoeda();
    private final Scanner scanner = new Scanner(System.in);

    private static final String[][] MOEDAS = {
            {"BRL", "Real Brasileiro"},
            {"ARS", "Peso Argentino"},
            {"CLP", "Peso Chileno"},
            {"COP", "Peso Colombiano"},
            {"BOB", "Boliviano"}
    };

    public void exibir() {
        while (true) {
            System.out.println("\n==== CONVERSOR DE MOEDAS ====");
            System.out.println("1. Converter de moeda para USD");
            System.out.println("2. Converter de USD para moeda");
            System.out.println("3. Sair");
            System.out.print("Escolha uma opção: ");

            try {
                int opcao = Integer.parseInt(scanner.nextLine());

                switch (opcao) {
                    case 1 -> converterParaUSD();
                    case 2 -> converterDeUSD();
                    case 3 -> {
                        System.out.println("Encerrando...");
                        return;
                    }
                    default -> System.out.println("Opção inválida.");
                }
            } catch (NumberFormatException e) {
                System.out.println("Entrada inválida. Digite um número.");
            }
        }
    }

    private void converterParaUSD() {
        String origem = escolherMoeda("Converter DE:");
        double valor = perguntarValor();
        try {
            double resultado = conversor.converterParaUSD(origem, valor);
            System.out.printf("Resultado: %.2f %s = %.2f USD%n", valor, origem, resultado);
        } catch (ErroDeMoedaException e) {
            System.out.println("Erro: " + e.getMessage());
        }
    }

    private void converterDeUSD() {
        String destino = escolherMoeda("Converter PARA:");
        double valor = perguntarValor();
        try {
            double resultado = conversor.converterDeUSD(destino, valor);
            System.out.printf("Resultado: %.2f USD = %.2f %s%n", valor, resultado, destino);
        } catch (ErroDeMoedaException e) {
            System.out.println("Erro: " + e.getMessage());
        }
    }

    private String escolherMoeda(String titulo) {
        System.out.println("\n" + titulo);
        for (int i = 0; i < MOEDAS.length; i++) {
            System.out.printf("%d. %s → %s%n", i + 1, MOEDAS[i][0], MOEDAS[i][1]);
        }

        while (true) {
            System.out.print("Escolha pelo número: ");
            try {
                int opcao = Integer.parseInt(scanner.nextLine());
                if (opcao >= 1 && opcao <= MOEDAS.length) {
                    return MOEDAS[opcao - 1][0];
                }
            } catch (NumberFormatException ignored) {}
            System.out.println("Opção inválida.");
        }
    }

    private double perguntarValor() {
        System.out.print("Digite o valor: ");
        while (true) {
            try {
                return Double.parseDouble(scanner.nextLine());
            } catch (NumberFormatException e) {
                System.out.print("Valor inválido. Tente novamente: ");
            }
        }
    }
}

