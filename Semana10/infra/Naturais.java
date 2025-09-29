package Semana10.infra;
import java.util.ArrayList;

public class Naturais extends Gerador {
    public void gerar(int quantidade) {
        sequencia = new ArrayList<>();
        for (int i = 0; i < quantidade; i++) {
            sequencia.add(i);
        }
    }
}
