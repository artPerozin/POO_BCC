package Semana10.infra;

import java.util.ArrayList;

public class Fibonacci extends Gerador {
    public void gerar(int quantidade) {
        sequencia = new ArrayList<>();
        int a = 0, b = 1;
        for (int i = 0; i < quantidade; i++) {
            sequencia.add(a);
            int temp = a + b;
            a = b;
            b = temp;
        }
    }
}
