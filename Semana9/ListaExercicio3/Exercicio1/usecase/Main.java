package Semana9.ListaExercicio3.Exercicio1.usecase;

import Semana9.ListaExercicio3.Exercicio1.Infra.Cachorro;
import Semana9.ListaExercicio3.Exercicio1.Infra.Gato;

public class Main {
    public static void main(String[] args) {
        Cachorro tobby = new Cachorro();
        Gato traquinas = new Gato();

        System.out.println("Tobby disse:   " + tobby.emitirSom());
        System.out.println("traquinas disse:   " + traquinas.emitirSom());
    }
}
