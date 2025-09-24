package Semana9.AulaPratica4.infra;
import java.util.ArrayList;
import java.util.List;

public class Fibonacci extends Gerador {
    public List<Integer> gerar(int quantidade) {
        List<Integer> lista = new ArrayList<>();
        int a = 0, b = 1;
        for (int i = 0; i < quantidade; i++) {
            lista.add(a);
            int temp = a + b;
            a = b;
            b = temp;
        }
        return lista;
    }
}
