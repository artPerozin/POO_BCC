package Lista4.Exercicio1.Dados;

public class MDC implements IOperacaoInteira {
    public int executar(int a, int b) {
        while (b != 0) {
            int temp = b;
            b = a % b;
            a = temp;
        }
        return a;
    }
}
