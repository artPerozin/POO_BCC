package Semana10.infra;
import java.util.ArrayList;

public class Perfeitos extends Gerador {
    public void gerar(int quantidade) {
        sequencia = new ArrayList<>();
        int num = 2;
        while (sequencia.size() < quantidade) {
            if (ehPerfeito(num)) {
                sequencia.add(num);
            }
            num++;
        }
    }

    private boolean ehPerfeito(int n) {
        int soma = 1;
        for (int i = 2; i <= n / 2; i++) {
            if (n % i == 0) soma += i;
        }
        return soma == n;
    }
}
