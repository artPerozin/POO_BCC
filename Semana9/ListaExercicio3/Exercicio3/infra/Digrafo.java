package Semana9.ListaExercicio3.Exercicio3.infra;

import java.util.ArrayList;
import java.util.List;

public abstract class Digrafo {
    protected List<List<Integer>> matrizAdjacencia1 = new ArrayList<>();

    public abstract void adicionarVertice();
    public abstract void adicionarAresta(int origem, int destino);
    public abstract String toString();
}
