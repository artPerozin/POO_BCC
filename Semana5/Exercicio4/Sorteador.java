package Semana5.Exercicio4;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

class Sorteador {
    private List<Pessoa> pessoas;
    private Random random;

    public Sorteador(List<Pessoa> pessoas) {
        this.pessoas = new ArrayList<>(pessoas);
        this.random = new Random();
    }

    public Pessoa sortearProximo() {
        if (pessoas.isEmpty()) {
            return null;
        }
        int index = random.nextInt(pessoas.size());
        return pessoas.remove(index);
    }

    public String toString() {
        return "Sorteador [pessoasRestantes=" + pessoas.size() + "]";
    }
}
