package Dados;

public class Peca {
    private String nome;
    private String descricao;
    private float preco;

    public String getNome() { return this.nome; }
    public void setNome(String nome) { this.nome = nome; }

    public String getDescricao() { return this.descricao; }
    public void setDescricao(String descricao) { this.descricao = descricao; }

    public float getPreco() { return this.preco; }
    public void setPreco(float preco) { this.preco = preco; }

    public String toString() {
        return this.getNome() + " | " + this.getDescricao() + " | Preco: " + this.getPreco();
    }
}
