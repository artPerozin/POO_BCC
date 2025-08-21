package Semana3.SistemaDePassagensUML.infra;

public class Cliente {
    private String cpf;
    private String nome;
    private String endereco;
    private String telefone;
    private Reserva[] reservas;
    public void reservarIda(Reserva reserva) {}
    public void reservarVolta(Reserva ida, Reserva volta ) {}

    public Cliente(
        String cpf,
        String nome,
        String endereco,
        String telefone
    ){
        this.cpf = cpf;
        this.nome = nome;
        this.endereco = endereco;
        this.telefone = telefone;
    }
    public String getNome(){
        return nome;
    }
    public Reserva[] getReservas() {
        return reservas;
    }
    public String getCpf(){
        return cpf;
    }
    public String toString() {
        String result = "=== Dados do Cliente ===\n" +
            "CPF: " + cpf + "\n" +
            "Nome: " + nome + "\n" +
            "Endereço: " + endereco + "\n" +
            "Telefone: " + telefone + "\n" +
            "Reservas:\n";
        if (reservas != null && reservas.length > 0) {
            for (int i = 0; i < reservas.length; i++) {
            result += "  " + (i + 1) + ") " +
                (reservas[i] != null ? reservas[i].toString() : "Sem dados") +
                "\n";
            }
        } else {
            result += "  Nenhuma reserva cadastrada\n";
        }
        return result;
    }
}
