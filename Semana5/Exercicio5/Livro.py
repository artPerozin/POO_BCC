class Livro:
    def __init__(self, titulo, ano, genero):
        self.titulo = titulo
        self.ano = ano
        self.genero = genero

    def __str__(self):
        return f"Livro: {self.titulo} ({self.ano}) - Gênero: {self.genero}"