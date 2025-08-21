package Semana3.SistemaDePassagensUML.infra;

public class Cidade {
    private String nome;
    private String estado;

    public Cidade (
        String nome,
        String estado
    ){
        this.nome = nome;
        this.estado = estado;
    }
    public String toString() {
        return "Cidade: " + nome + " - Estado: " + estado;
    }
}
