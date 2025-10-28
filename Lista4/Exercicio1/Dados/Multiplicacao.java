package Lista4.Exercicio1.Dados;

public class Multiplicacao extends Soma {
    public int executar(int valor1, int valor2) {
        int resultado = 0;
        for (int i = 0; i < valor2; i++) {
            resultado = super.executar(resultado, valor1);
        }
        return resultado;
    }
}