package Semana9;
import java.util.ArrayList;
import java.util.List;

public class Perfeitos extends Gerador {
    public List<Integer> gerar(int quantidade) {
        List<Integer> lista = new ArrayList<>();
        int num = 2;
        while (lista.size() < quantidade) {
            if (ehPerfeito(num)) {
                lista.add(num);
            }
            num++;
        }
        return lista;
    }

    private boolean ehPerfeito(int n) {
        int soma = 1;
        for (int i = 2; i <= n / 2; i++) {
            if (n % i == 0) soma += i;
        }
        return soma == n;
    }
}
