package Semana6.AulaPratica5.infra;

public class Contato {
    
    public Contato(){}

    private String nome;
    private int telefone;

    public void setNome (String nome) { this.nome = nome; }
    public String getNome () { return this.nome; }

    public void setTelefone (int telefone) { this.telefone = telefone; }
    public int getTelefone () { return this.telefone; }
}
