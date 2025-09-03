package Semana6.Exercicio1;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class LerUsuarios {
    public static void main(String[] args) {
        Scanner sc;
        try {
            sc = new Scanner(new File("pessoas.txt"));
        } catch (FileNotFoundException e) {
            System.out.println("Arquivo não encontrado. Lendo do teclado...");
            sc = new Scanner(System.in);
        }

        List<Pessoa> pessoas = new ArrayList<>();

        while (sc.hasNextLine()) {
            String linha = sc.nextLine().trim();
            if (linha.isEmpty()) continue;

            String[] dados = linha.split(",");
            if (dados.length < 4) continue;

            String nome = dados[0].trim();
            int idade = Integer.parseInt(dados[1].trim());
            String cpf = dados[2].trim();
            String cidade = dados[3].trim();

            Pessoa p = new Pessoa(nome, idade, cpf, cidade);
            pessoas.add(p);

            Collections.sort(pessoas);
        }
        exibirAgrupado(pessoas);
        System.out.println("-------------------------------------------------");
    }

    private static void exibirAgrupado(List<Pessoa> pessoas) {
        System.out.println("1 até 12: crianças;");
        pessoas.stream()
                .filter(p -> p.getIdade() >= 1 && p.getIdade() <= 12)
                .forEach(p -> System.out.println("– " + p));

        System.out.println("13 até 18: adolescentes;");
        pessoas.stream()
                .filter(p -> p.getIdade() >= 13 && p.getIdade() <= 18)
                .forEach(p -> System.out.println("– " + p));

        System.out.println("19 até 25: jovens;");
        pessoas.stream()
                .filter(p -> p.getIdade() >= 19 && p.getIdade() <= 25)
                .forEach(p -> System.out.println("– " + p));

        System.out.println("26 até 59: adultos;");
        pessoas.stream()
                .filter(p -> p.getIdade() >= 26 && p.getIdade() <= 59)
                .forEach(p -> System.out.println("– " + p));

        System.out.println("60 ou mais: idosos;");
        pessoas.stream()
                .filter(p -> p.getIdade() >= 60)
                .forEach(p -> System.out.println("– " + p));
    }
}
