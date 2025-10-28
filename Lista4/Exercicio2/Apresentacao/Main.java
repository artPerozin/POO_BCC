package Lista4.Exercicio2.Apresentacao;

import Lista4.Exercicio2.Dados.Juiz;
import Lista4.Exercicio2.Dados.Processo;
import Lista4.Exercicio2.Exceptions.ProcessoSemJuizException;
import Lista4.Exercicio2.Negocio.SistemaProcessos;

public class Main {
    public static void main(String[] args) {
        try {
            SistemaProcessos sistema = new SistemaProcessos();

            Juiz juiz1 = new Juiz("Juiz 1", 5);
            Juiz juiz2 = new Juiz("Juiz 2", 5);
            Juiz juiz3 = new Juiz("Juiz 3", 4);

            sistema.cadastrarJuiz(juiz1);
            sistema.cadastrarJuiz(juiz2);
            sistema.cadastrarJuiz(juiz3);

            for (int i = 1; i <= 18; i++) {
                Processo p = new Processo(i, "Processo " + i);
                sistema.cadastrarProcesso(p);
            }

            sistema.distribuirProcessos();
            System.out.println("Distribuição concluída com sucesso.");
        } catch (ProcessoSemJuizException e) {
            System.out.println("Erro: " + e.getMessage());
        } catch (Exception e) {
            System.out.println("Erro inesperado: " + e.getMessage());
        }
    }
}
