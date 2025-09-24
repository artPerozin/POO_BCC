from Aluno import Aluno
from Professor import Professor

prof1 = Professor("Carlos", 3500.50)
prof2 = Professor("Mariana", 4200.75)

aluno1 = Aluno("Arthur", [8.0, 7.5, 9.0])
aluno2 = Aluno("Beatriz", [6.0, 5.5, 6.5])
aluno3 = Aluno("Caio", [7.0, 7.0, 7.0])
aluno4 = Aluno("Daniela", [9.5, 8.5, 10.0])
aluno5 = Aluno("Eduardo", [4.0, 6.0, 5.0])

professores = [prof1, prof2]
alunos = [aluno1, aluno2, aluno3, aluno4, aluno5]

print("Professores:")
for prof in professores:
    print(prof)

print("\nAlunos:")
for aluno in alunos:
    print(aluno)