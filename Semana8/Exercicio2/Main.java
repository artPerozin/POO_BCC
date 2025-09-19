package Semana8.Exercicio2;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        Matriz<Integer> matriz = new Matriz<>(5, 5);

        System.out.println("Digite os valores da matriz 5x5 (digite -1 para parar):");

        int i = 0, j = 0;
        while (i < 5 && j < 5) {
            int valor = sc.nextInt();
            if (valor == -1) break;

            matriz.set(valor, i, j);

            j++;
            if (j == 5) {
                j = 0;
                i++;
            }
        }

        int menorGlobal = Integer.MAX_VALUE;
        for (Quadrante q : Quadrante.values()) {
            List<Integer> elementos = matriz.getElementosQuadrante(q);
            if (!elementos.isEmpty()) {
                int menorQuadrante = Collections.min(elementos, Comparator.nullsLast(Integer::compareTo));
                if (menorQuadrante < menorGlobal) {
                    menorGlobal = menorQuadrante;
                }
            }
        }

        System.out.println("Menor elemento da matriz = " + menorGlobal);

        sc.close();
    }
}
