package infra;
public class Quarto {
    private int numero;
    private Hospede hospede;
    private Funcionario funcionarioResponsavel;
    private boolean disponivel;

    public Quarto(
        int numero,
        Funcionario funcionarioResponsavel,
        boolean disponivel
    ) {
        this.numero = numero;
        this.funcionarioResponsavel = funcionarioResponsavel;
        this.disponivel = true;
        this.hospede = null;
    }

    public int getNumero() {
        return numero;
    }

    public Hospede getCliente() {
        return hospede;
    }

    public Funcionario getFuncionarioResponsavel() {
        return funcionarioResponsavel;
    }

    public boolean isDisponivel() {
        return disponivel;
    }

    public void setDisponivel(boolean disponivel) {
        this.disponivel = disponivel;
    }

    public void hospedarCliente(Hospede hospede) {
        this.hospede = hospede;
        this.disponivel = true;
    }

    public void liberarQuarto() {
        this.hospede = null;
        this.disponivel = false;
    }

    public String toString() {
        return "Numero do quarto: " + numero + ", Funcionario responsavel: " + funcionarioResponsavel.getNome();
    }
}
