from Pessoa import Pessoa

class Aluno(Pessoa):
    def __init__(self, nome: str, notas: list[float]):
        super().__init__(nome)
        self.notas = notas

    def calcular_media(self) -> float:
        if not self.notas:
            return 0.0
        return sum(self.notas) / len(self.notas)

    def __repr__(self) -> str:
        media = self.calcular_media()
        status = "Aprovado" if media >= 7 else "Exame"
        return f"Aluno(nome={self._nome}, notas={self.notas}, media={media:.2f}, status={status})"