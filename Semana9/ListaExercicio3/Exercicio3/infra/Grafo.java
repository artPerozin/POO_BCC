package Semana9.ListaExercicio3.Exercicio3.infra;

import java.util.ArrayList;
import java.util.List;

public class Grafo extends Digrafo {

    public void adicionarVertice() {
        int novoIndice = matrizAdjacencia1.size();

        List<Integer> novaLinha = new ArrayList<>();
        for (int i = 0; i <= novoIndice; i++) {
            novaLinha.add(0);
        }
        matrizAdjacencia1.add(novaLinha);

        for (int i = 0; i < novoIndice; i++) {
            matrizAdjacencia1.get(i).add(0);
        }
    }

    public void adicionarAresta(int origem, int destino) {
        matrizAdjacencia1.get(origem).set(destino, 1);
        matrizAdjacencia1.get(destino).set(origem, 1);
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("Matriz de Adjacência:\n");
        for (List<Integer> linha : matrizAdjacencia1) {
            for (Integer valor : linha) {
                sb.append(valor).append(" ");
            }
            sb.append("\n");
        }
        return sb.toString();
    }
}
