package exercicio2.dados;

public class Veterinario {
    
    private String nome;
    private double salario;
    private Endereco endereco;
    private Animal[] animais;
    private int quantidadeAnimais = 0;

    public Veterinario(
        String nome,
        double salario
    ) {
        this.nome = nome;
        this.salario = salario;
        this.animais = new Animal[50];
    }

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
        return this.animais;        
    }

    public int getQuantidadeAnimais() {
        return this.quantidadeAnimais;
    }

    public String toString() {
        String veterinario = "";

        veterinario += "Nome: " + this.nome + "\n";
        veterinario += "Salario: " + this.salario + "\n";

        if(this.endereco != null) {
            veterinario += "Endereco: " + this.endereco.toString() + "\n";
        }

        return veterinario;
    }
}
