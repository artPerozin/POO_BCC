package Semana3.SistemaDePassagensUML.src.infra;

public class Cidade {
    private String nome;
    private String estado;

    public Cidade() {}

    public String toString() {
        return  "Nome:    " + nome + "\n" +
                "Estado:  " + estado + "\n";
    }
    
    public String getNome() {
        return nome;
    }

    public String getEstado() {
        return estado;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }
}
