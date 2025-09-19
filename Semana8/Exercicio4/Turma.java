package Semana8.Exercicio4;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Turma {
    private List<Aluno> alunos;

    public Turma(){};

    public void adicionarAluno(Aluno aluno) { this.alunos.add(aluno); }

    private void ordenarAlunosPorMédia(List<Aluno> alunos) {
        alunos.sort(Comparator.comparingDouble(Aluno::calcularMedia).reversed());
    }

    public List<Equipe<Aluno>> separarEmEquipes(List<Aluno> alunos) {
        ordenarAlunosPorMédia(alunos);

        List<Equipe<Aluno>> equipes = new ArrayList<>();
        int i = 0;
        int j = alunos.size() - 1;

        while (i <= j) {
            Equipe<Aluno> equipe = new Equipe<>();
            if (i <= j) equipe.adicionarAluno(alunos.get(i++));
            if (i <= j) equipe.adicionarAluno(alunos.get(j--));

            if (equipe.getMembros().size() < 3 && i <= j) {
                equipe.adicionarAluno(alunos.get(i++));
            }
            if (equipe.getMembros().size() < 3 && i <= j) {
                equipe.adicionarAluno(alunos.get(j--));
            }

            equipes.add(equipe);
        }

        return equipes;
    }

}
