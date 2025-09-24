package Semana9.ListaExercicio3.Exercicio2.usecase;

import Semana9.ListaExercicio3.Exercicio2.infra.Circulo;
import Semana9.ListaExercicio3.Exercicio2.infra.Losango;
import Semana9.ListaExercicio3.Exercicio2.infra.TrianguloEquilatero;

public class Main {
    public static void main(String[] args) {
        
        Circulo c = new Circulo();
        c.setRaio(5);
        System.out.println(c);

        Losango l = new Losango();
        l.setD(10);
        l.setd(6);
        System.out.println(l);

        TrianguloEquilatero t = new TrianguloEquilatero();
        t.setLado(7);
        System.out.println(t);
    }
}
