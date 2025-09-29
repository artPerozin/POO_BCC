package Semana10.infra;
import java.util.ArrayList;

public class Quadrados extends Gerador {
    public void gerar(int quantidade) {
        sequencia = new ArrayList<>();
        for (int i = 1; i <= quantidade; i++) {
            sequencia.add(i * i);
        }
    }
}
