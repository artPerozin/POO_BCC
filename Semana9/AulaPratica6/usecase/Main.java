package Semana9.AulaPratica6..usecase;

import Semana9.AulaPratica6.infra.Abundantes;
import Semana9.AulaPratica6.infra.Fatorial;
import Semana9.AulaPratica6.infra.Fibonacci;
import Semana9.AulaPratica6.infra.Gerador;
import Semana9.AulaPratica6.infra.Naturais;
import Semana9.AulaPratica6.infra.Perfeitos;
import Semana9.AulaPratica6.infra.Primos;
import Semana9.AulaPratica6.infra.Quadrados;

public class Main {
    public static void main(String[] args) {
        Gerador g1 = new Naturais();
        Gerador g2 = new Abundantes();
        Gerador g3 = new Fibonacci();
        Gerador g4 = new Fatorial();
        Gerador g5 = new Primos();
        Gerador g6 = new Quadrados();
        Gerador g7 = new Perfeitos();

        System.out.println("Naturais:   " + g1.gerar(10));
        System.out.println("Abundantes: " + g2.gerar(10));
        System.out.println("Fibonacci:  " + g3.gerar(10));
        System.out.println("Fatorial:   " + g4.gerar(10));
        System.out.println("Primos:     " + g5.gerar(10));
        System.out.println("Quadrados:  " + g6.gerar(10));
        System.out.println("Perfeitos:  " + g7.gerar(3));
    }
}
