package Semana8.Exercicio4;

import java.util.ArrayList;
import java.util.List;

public class Equipe<T> {
    private String nome;
    private List<T> membros;

    public Equipe() {
        this.membros = new ArrayList<>();
    }

    public Equipe(String nome) {
        this.nome = nome;
        this.membros = new ArrayList<>();
    }

    public void setNome(String nome) { this.nome = nome; }
    public String getNome() { return this.nome; }

    public void adicionarAluno(T membro) { membros.add(membro);}

    public List<T> getMembros() { return membros; }

    public int tamanho() { return membros.size(); }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("Equipe " + nome + ":\n");
        for (T membro : membros) {
            sb.append(" - ").append(membro.toString()).append("\n");
        }
        return sb.toString();
    }
}
