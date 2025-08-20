package infra;
public class Hospede extends Pessoa {
    private int numeroQuarto;

    public Hospede() {
        super();
    }

    public Hospede(
        String nome,
        String cpf,
        int numeroQuarto
    ) {
        super(nome, cpf);
        this.numeroQuarto = numeroQuarto;
    }

    public int getNumeroQuarto() {
        return numeroQuarto;
    }

    public void setNumeroQuarto(int numeroQuarto) {
        this.numeroQuarto = numeroQuarto;
    }

    public String toString() {
        return "nome: " + getNome() + ", cpf: " + getCpf() + ", numero do quarto: " + numeroQuarto;
    }
}
