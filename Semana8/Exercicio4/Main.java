package Semana8.Exercicio4;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Aluno a1 = new Aluno("Ana", 15, new double[]{9.0, 8.5, 10.0});
        Aluno a2 = new Aluno("Bruno", 15, new double[]{6.0, 7.0, 5.5});
        Aluno a3 = new Aluno("Carla", 16, new double[]{7.5, 8.0, 7.0});
        Aluno a4 = new Aluno("Diego", 16, new double[]{4.0, 5.0, 6.0});
        Aluno a5 = new Aluno("Elisa", 16, new double[]{10.0, 9.5, 9.0});
        Aluno a6 = new Aluno("Felipe", 16, new double[]{3.0, 4.5, 5.0});

        List<Aluno> alunos = new ArrayList<>();
        alunos.addAll(Arrays.asList(a1, a2, a3, a4, a5, a6));

        alunos.sort(Comparator.comparingDouble(Aluno::calcularMedia).reversed());

        List<Equipe<Aluno>> equipes = separarEmEquipes(alunos);

        for (Equipe<Aluno> equipe : equipes) {
            System.out.println(equipe);
        }
    }

    private static List<Equipe<Aluno>> separarEmEquipes(List<Aluno> alunos) {
        List<Equipe<Aluno>> equipes = new ArrayList<>();
        int i = 0;
        int j = alunos.size() - 1;
        int contador = 1;

        while (i <= j) {
            Equipe<Aluno> equipe = new Equipe<>("Equipe " + contador++);

            if (i <= j) equipe.adicionarAluno(alunos.get(i++));
            if (i <= j) equipe.adicionarAluno(alunos.get(j--));

            if (equipe.tamanho() < 3 && i <= j) {
                equipe.adicionarAluno(alunos.get(i++));
            }

            equipes.add(equipe);
        }

        return equipes;
    }
}
