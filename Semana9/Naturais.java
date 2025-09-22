package Semana9;
import java.util.ArrayList;
import java.util.List;

public class Naturais extends Gerador {
    public List<Integer> gerar(int quantidade) {
        List<Integer> lista = new ArrayList<>();
        for (int i = 0; i < quantidade; i++) {
            lista.add(i);
        }
        return lista;
    }
}
