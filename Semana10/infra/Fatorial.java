package Semana10.infra;
import java.util.ArrayList;

public class Fatorial extends Gerador {
    public void gerar(int quantidade) {
        sequencia = new ArrayList<>();
        int fat = 1;
        for (int i = 1; i <= quantidade; i++) {
            fat *= i;
            sequencia.add(fat);
        }
    }
}
