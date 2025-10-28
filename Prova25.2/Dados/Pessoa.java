package Dados;

class Pessoa {
    private String nome;
    private long CPF;
    private String telefone;

    public Pessoa(){}

    public String toString() {
        return "";
    }

    public String getNome() { return this.nome; }
    public void setNome(String nome) { this.nome = nome; }

    public long getCPF() { return this.CPF; }
    public void setCPF(long CPF) { this.CPF = CPF; }

    public String getTelefone() { return this.telefone; }
    public void setTelefone(String telefone) { this.telefone = telefone; }
}