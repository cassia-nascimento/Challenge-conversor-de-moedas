package br.com.seuusuario.conversormoedas;

import java.util.Scanner;

public class Main {

    static class Moeda {
        String codigo;
        String nome;

        Moeda(String codigo, String nome) {
            this.codigo = codigo;
            this.nome = nome;
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        CurrencyApiClient client = new CurrencyApiClient("e5f4bfcc74ac663f03433d5f");

        Moeda[] moedas = {
                new Moeda("USD", "Dólar Americano"),
                new Moeda("EUR", "Euro"),
                new Moeda("BRL", "Real Brasileiro"),
                new Moeda("ARS", "Peso Argentino"),
                new Moeda("BOB", "Boliviano Boliviano"),
                new Moeda("CLP", "Peso Chileno"),
                new Moeda("COP", "Peso Colombiano"),
                new Moeda("KRW", "Won Sul-Coreano")
        };

        while (true) {
            System.out.println("\n=== Conversor de Moedas ===");
            System.out.println("Escolha a moeda base:");
            for (int i = 0; i < moedas.length; i++) {
                System.out.println((i + 1) + ". " + moedas[i].codigo + " - " + moedas[i].nome);
            }
            System.out.println("0. Sair");

            int opcaoBase = scanner.nextInt();
            if (opcaoBase == 0) break;
            if (opcaoBase < 1 || opcaoBase > moedas.length) {
                System.out.println("Opção inválida! Tente novamente.");
                continue;
            }

            Moeda base = moedas[opcaoBase - 1];

            System.out.println("\nEscolha a moeda de destino:");
            for (int i = 0; i < moedas.length; i++) {
                System.out.println((i + 1) + ". " + moedas[i].codigo + " - " + moedas[i].nome);
            }

            int opcaoDestino = scanner.nextInt();
            if (opcaoDestino < 1 || opcaoDestino > moedas.length) {
                System.out.println("Opção inválida! Tente novamente.");
                continue;
            }

            Moeda destino = moedas[opcaoDestino - 1];

            System.out.print("\nDigite o valor em " + base.codigo + " que deseja converter: ");
            String valorInput = scanner.next().replace(",", "."); // aceita vírgula ou ponto
            double valor;
            try {
                valor = Double.parseDouble(valorInput);
            } catch (NumberFormatException e) {
                System.out.println("Valor inválido! Tente novamente.");
                continue;
            }

            double taxa = client.getConversionRate(base.codigo, destino.codigo);
            if (taxa != -1) {
                double convertido = valor * taxa;
                System.out.printf("%.2f %s = %.2f %s%n", valor, base.codigo, convertido, destino.codigo);
            } else {
                System.out.println("Não foi possível obter a taxa de conversão. Tente novamente mais tarde.");
            }

            System.out.println("\nDeseja realizar outra conversão? (s/n)");
            String resposta = scanner.next();
            if (!resposta.equalsIgnoreCase("s")) break;
        }

        scanner.close();
        System.out.println("Programa encerrado. Obrigado por usar o Conversor de Moedas!");
    }
}
