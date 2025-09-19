import json

class Filme:
    def __init__(self, titulo: str, ano: int, classificacao: str, nota: float):
        self.titulo = titulo
        self.ano = ano
        self.classificacao = classificacao
        self.nota = nota

    @classmethod
    def from_json(cls, data: dict):
        """Cria um objeto Filme a partir de um dicionário JSON"""
        return cls(
            titulo=data.get("titulo"),
            ano=data.get("ano"),
            classificacao=data.get("classificacao"),
            nota=data.get("nota"),
        )

    def __str__(self):
        return f"{self.titulo} ({self.ano}) - Classificação: {self.classificacao}, Nota: {self.nota}"
