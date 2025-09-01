package Semana5.Exercicio4;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        Pessoa p1 = new Pessoa("Ana", 25);
        Pessoa p2 = new Pessoa("Carlos", 30);
        Pessoa p3 = new Pessoa("Beatriz", 22);
        Pessoa p4 = new Pessoa("João", 28);

        Sorteador sorteador = new Sorteador(Arrays.asList(p1, p2, p3, p4));

        System.out.println("Sorteios:");
        Pessoa sorteado;
        while ((sorteado = sorteador.sortearProximo()) != null) {
            System.out.println(" - " + sorteado);
        }
    }
}

