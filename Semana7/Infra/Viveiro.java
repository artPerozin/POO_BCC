package Semana7.Infra;

import java.util.ArrayList;
import java.util.List;

public class Viveiro {
    protected String nome;
    protected float comprimento;
    protected float largura;
    protected List<Animal> animais = new ArrayList<>();

    public Viveiro() {}

    public float calculaEspaco() {
        return comprimento * largura;
    }

    public float espacoDisponivel() {
        float ocupado = 0;
        for (Animal a : animais) {
            ocupado += a.calculaEspacoOcupado();
        }
        return calculaEspaco() - ocupado;
    }

    public boolean adicionarAnimal(Animal animal) {
        if (animal instanceof Peixe) {
            return false;
        }

        float espacoNecessario = animal.calculaEspacoOcupado() * 0.7f; 
        if (espacoDisponivel() >= espacoNecessario) {
            animais.add(animal);
            return true;
        }
        return false;
    }

    public void setLargura(float largura) { this.largura = largura; }
    public float getLargura() { return this.largura; }

    public void setComprimento(float comprimento) { this.comprimento = comprimento; }
    public float getComprimento() { return this.comprimento; }

    public void setNome(String nome) { this.nome = nome; }
    public String getNome() { return this.nome; }

    public List<Animal> getAnimals() {return this.animais;}
}
