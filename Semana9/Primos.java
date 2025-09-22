package Semana9;
import java.util.ArrayList;
import java.util.List;

public class Primos extends Gerador {
    public List<Integer> gerar(int quantidade) {
        List<Integer> lista = new ArrayList<>();
        int num = 2;
        while (lista.size() < quantidade) {
            if (ehPrimo(num)) {
                lista.add(num);
            }
            num++;
        }
        return lista;
    }

    private boolean ehPrimo(int n) {
        if (n < 2) return false;
        for (int i = 2; i <= Math.sqrt(n); i++) {
            if (n % i == 0) return false;
        }
        return true;
    }
}
