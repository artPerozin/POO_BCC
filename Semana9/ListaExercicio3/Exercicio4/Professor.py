from Pessoa import Pessoa

class Professor(Pessoa):
    def __init__(self, nome: str, salario: float):
        super().__init__(nome)
        self.salario = salario

    def __repr__(self) -> str:
        return f"Professor(nome={self._nome}, salario={self.salario:.2f})"