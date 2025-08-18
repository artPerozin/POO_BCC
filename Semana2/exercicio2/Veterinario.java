package exercicio2;

public class Veterinario {
    
    private String nome;
    private double salario;
    private Endereco endereco;
    private Animal[] animais;
    private int quantidadeAnimais;

    public Veterinario(
        String nome,
        double salario
    ) {
        this.nome = nome;
        this.salario = salario;
    }

    public Veterinario(){}

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getNome() {
        return nome;
    }

    public void setSalario(float salario) {
        this.salario = salario;
    }

    public double getSalario() {
        return salario;
    }

    public void setEndereco(Endereco endereco) {
        this.endereco = endereco;
    }

    public Endereco getEndereco() {
        return endereco;
    }

    public void setAnimal(Animal animal) {
        this.animais[quantidadeAnimais] = animal;
        this.quantidadeAnimais++;
    }

    public Animal getAnimal(int animalIdx) {
        return this.animais[animalIdx];
    }

    public Animal[] getAnimais() {
        return animais;
    }

    public int getQuantidadeAnimais() {
        return this.quantidadeAnimais;
    }
}
