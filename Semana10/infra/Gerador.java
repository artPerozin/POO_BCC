package Semana10.infra;

import java.util.List;
import java.util.Random;

public abstract class Gerador implements ISequencia {
    protected List<Integer> sequencia;
    public List<Integer> getSequencia() {
        return sequencia;
    }
    public abstract void gerar(int quantidade);
    
    @Override
    public int sortear() {
        Random random = new Random();
        return sequencia.get(random.nextInt(sequencia.size()));
    }

    @Override
    public long somatorio() {
        return sequencia.stream().mapToLong(Integer::intValue).sum();
    }

    @Override
    public double mediaAritmetica() {
        return somatorio() / (double) sequencia.size();
    }

    @Override
    public double mediaGeometrica() {
        double produto = 1.0;
        for (int n : sequencia) {
            produto *= n == 0 ? 1 : n;
        }
        return Math.pow(produto, 1.0 / sequencia.size());
    }

    @Override
    public double variancia() {
        double media = mediaAritmetica();
        return sequencia.stream()
                .mapToDouble(n -> Math.pow(n - media, 2))
                .sum() / sequencia.size();
    }

    @Override
    public double desvioPadrao() {
        return Math.sqrt(variancia());
    }

    @Override
    public long amplitude() {
        int max = sequencia.stream().mapToInt(Integer::intValue).max().orElse(0);
        int min = sequencia.stream().mapToInt(Integer::intValue).min().orElse(0);
        return max - min;
    }
}

