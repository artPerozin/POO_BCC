package Dados;

public class Mecanico extends Pessoa{
    private float valorMaoDeObra;

    public Mecanico(){}

    public float getValorMaoDeObra() { return this.valorMaoDeObra; }
    public void setValorMaoDeObra(float valorMaoDeObra) { this.valorMaoDeObra = valorMaoDeObra; }

        public String toString() {
        return "nome: " + this.getNome() + " telefone: " + this.getTelefone() + " valor da mao de obra: " + this.getValorMaoDeObra();
    }
}
