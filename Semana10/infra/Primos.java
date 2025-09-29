package Semana10.infra;
import java.util.ArrayList;

public class Primos extends Gerador {
    public void gerar(int quantidade) {
        sequencia = new ArrayList<>();
        int num = 2;
        while (sequencia.size() < quantidade) {
            if (ehPrimo(num)) {
                sequencia.add(num);
            }
            num++;
        }
    }

    private boolean ehPrimo(int n) {
        if (n < 2) return false;
        for (int i = 2; i <= Math.sqrt(n); i++) {
            if (n % i == 0) return false;
        }
        return true;
    }
}
