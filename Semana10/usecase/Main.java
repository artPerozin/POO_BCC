package Semana10.usecase;

import Semana10.infra.*;

public class Main {
    public static void main(String[] args) {
        Gerador[] geradores = {
            new Fibonacci(),
            new Naturais(),
            new Primos(),
            new Quadrados(),
            new Perfeitos(),
            new Fatorial(),
            new Abundantes()
        };

        for (Gerador g : geradores) {
            g.gerar(5);
            System.out.println(g.getClass().getSimpleName() + " -> " + g.getSequencia());
            System.out.println("Sorteados: " + g.sortear());
            System.out.println("Somatorio: " + g.somatorio());
            System.out.println("Media aritmetica: " + g.mediaAritmetica());
            System.out.println("Media geometrica: " + g.mediaGeometrica());
            System.out.println("Desvio Padrão: " + g.variancia());
            System.out.println("Variância: " + g.desvioPadrao());
            System.out.println("Amplitude: " + g.amplitude());
            System.out.println("--------------------");
        }
    }
}
