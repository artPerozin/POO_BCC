package Lista4.Exercicio1.Apresentacao;

import java.util.*;
import Lista4.Exercicio1.Dados.*;

public class Main {
    public static void main(String[] args) {
        Random random = new Random();

        List<IOperacaoInteira> operacoes = new ArrayList<>();
        operacoes.add(new Soma());
        operacoes.add(new MDC());
        operacoes.add(new Mod());
        operacoes.add(new Multiplicacao());
        
        for (IOperacaoInteira op : operacoes) {
            int a = random.nextInt(10) + 1;
            int b = random.nextInt(10) + 1;
            int resultado = op.executar(a, b);

            System.out.println(op.getClass().getSimpleName() +
                    " -> executar(" + a + ", " + b + ") = " + resultado);
        }
    }
}
