package Semana9.ListaExercicio3.Exercicio3.usecase;

import Semana9.ListaExercicio3.Exercicio3.infra.Grafo;

public class Main {
    public static void main(String[] args) {
        Grafo g = new Grafo();

        for (int i = 0; i < 5; i++) {
            g.adicionarVertice();
        }

        g.adicionarAresta(0, 1);
        g.adicionarAresta(0, 2);
        g.adicionarAresta(1, 2);
        g.adicionarAresta(1, 3);
        g.adicionarAresta(3, 4);

        System.out.println(g);
    }
}
