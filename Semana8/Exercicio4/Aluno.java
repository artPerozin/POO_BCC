package Semana8.Exercicio4;

public class Aluno {
    private String nome;
    private int idade;
    private double[] notas;

    public Aluno(){}

    public Aluno(
        String nome,
        int idade,
        double[] notas
    ){
        this.nome = nome;
        this.idade = idade;
        this.notas = notas;
    }

    public double calcularMedia() {
        double somatorioNotas = 0.0;
        for (double nota : notas) somatorioNotas += nota;
        return somatorioNotas/notas.length;
    }

    public String toString() {
        return "aluno: " + this.nome + "  idade: " + this.idade;
    }
}
