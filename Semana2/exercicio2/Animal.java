package exercicio2;

public class Animal {
    private String nome;
    private Dono dono;
    private String especie;
    private String descricao;

    public Animal(
        String nome,
        String especie,
        String descricao
    ){
        this.nome = nome;
        this.especie = especie;
        this.descricao = descricao;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setDono(Dono dono) {
        this.dono = dono;
    }

    public void setEspecie(String especie) {
        this.especie = especie;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getNome() {
        return nome;
    }

    public Dono getDono() {
        return dono;
    }

    public String getEspecie() {
        return especie;
    }

    public String getDescricao() {
        return descricao;
    }
}
