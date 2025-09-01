class Autor:
    def __init__(self, nome, nacionalidade, idade):
        self.nome = nome
        self.nacionalidade = nacionalidade
        self.idade = idade

    def __str__(self):
        return f"Autor: {self.nome}, {self.idade} anos, Nacionalidade: {self.nacionalidade}"
