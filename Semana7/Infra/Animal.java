package Semana7.Infra;

public class Animal {
    protected String nome;
    protected String cor;
    protected String especie;
    protected int idade;

    protected float largura;
    protected float comprimento;
    protected float altura;

    public Animal(
        String nome,
        String cor,
        String especie,
        float largura,
        float comprimento,
        float altura
    ){
        this.nome = nome;
        this.cor = cor;
        this.especie = especie;
        this.largura = largura;
        this.comprimento = comprimento;
        this.altura = altura;
    }

    public Animal() {}

    public float calculaEspacoOcupado() {
        return largura*comprimento;
    }

    public void setNome(String nome) {this.nome = nome;}
    public String getNome() {return this.nome;}

    public void setCor(String cor) {this.cor = cor;}
    public String getCor() {return this.cor;}

    public void setEspecie(String especie) {this.especie = especie;}
    public String getEspecie() {return this.especie;}

    public void setIdade(int idade) {this.idade = idade;}
    public int getIdade() {return this.idade;}
    
    public void setAltura(float altura) {this.altura = altura;}
    public float getAltura() {return this.altura;}

    public void setLargura(float largura) {this.largura = largura;}
    public float getLargura() {return this.largura;}

    public void setComprimento(float comprimento) {this.comprimento = comprimento;}
    public float getComprimento() {return this.comprimento;}
}
