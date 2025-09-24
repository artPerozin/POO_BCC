package Semana9.AulaPratica4.infra;
import java.util.ArrayList;
import java.util.List;

public class Fatorial extends Gerador {
    public List<Integer> gerar(int quantidade) {
        List<Integer> lista = new ArrayList<>();
        int fat = 1;
        for (int i = 1; i <= quantidade; i++) {
            fat *= i;
            lista.add(fat);
        }
        return lista;
    }
}
