package exercicio1;
public class Pessoa {

    private String nome;
    private int idade;
    private double altura;
    private double massa;

    public Pessoa(){}

    public String getNome() {
        return this.nome;
    }

    public int getIdade() {
        return this.idade;
    }

    public double getAltura() {
        return this.altura;
    }

    public double getMassa() {
        return this.massa;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setIdade(int idade){
        this.idade = idade;
    }

    public void setAltura(double altura){
        this.altura = altura;
    }

    public void setMassa(double massa){
        this.massa = massa;
    }

    public double calculaIMC() {
        return this.massa / (this.altura + this.altura);
    }
}