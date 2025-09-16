package Semana7.Infra;

public class Peixe extends Animal {
    private float temperaturaIdeal;

    public Peixe (
        String nome,
        String cor,
        String especie,
        float largura,
        float comprimento,
        float altura,
        float temperaturaIdeal
    ){
        this.nome = nome;
        this.cor = cor;
        this.especie = especie;
        this.largura = largura;
        this.comprimento = comprimento;
        this.altura = altura;
        this.temperaturaIdeal = temperaturaIdeal;
    }
    public Peixe(){}

    public void setTemperaturaIdeal(float temperaturaIdeal) { this.temperaturaIdeal = temperaturaIdeal; }
    public float getTemperaturaIdeal() { return this.temperaturaIdeal; }

    @Override
    public float calculaEspacoOcupado() {
        return comprimento * largura * altura;
    }
    
}
