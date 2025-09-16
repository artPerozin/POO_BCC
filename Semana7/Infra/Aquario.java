package Semana7.Infra;

public class Aquario extends Viveiro {
    private float altura;
    private float temperatura;

    public Aquario() {}

    public void setAltura(float altura) { this.altura = altura; }
    public float getAltura() { return this.altura; }

    public void setTemperatura(float temperatura) { this.temperatura = temperatura; }
    public float getTemperatura() { return this.temperatura; }


    @Override
    public float calculaEspaco() {
        return comprimento * largura * altura;
    }

    @Override
    public float espacoDisponivel() {
        float ocupado = 0;
        for (Animal a : animais) {
            ocupado += a.calculaEspacoOcupado();
        }
        return calculaEspaco() - ocupado;
    } 

    @Override
    public boolean adicionarAnimal(Animal animal) {
        if (!(animal instanceof Peixe)) {
            return false;
        }

        float espacoNecessario = animal.calculaEspacoOcupado() * 0.7f;
        if (espacoDisponivel() >= espacoNecessario) {
            animais.add(animal);
            return true;
        }
        return false;
    }
}
