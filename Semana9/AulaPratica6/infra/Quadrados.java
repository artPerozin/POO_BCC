package Semana9.AulaPratica4.infra;
import java.util.ArrayList;
import java.util.List;

public class Quadrados extends Gerador {
    public List<Integer> gerar(int quantidade) {
        List<Integer> lista = new ArrayList<>();
        for (int i = 1; i <= quantidade; i++) {
            lista.add(i * i);
        }
        return lista;
    }
}
