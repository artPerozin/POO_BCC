from Exceptions.ObjetoSobrepostoException import ObjetoSobrepostoException

class EspacoGeometrico:
    def __init__(self):
        self.retas = []
        self.pontos = []

    def adicionarReta(self, nova_reta):
        for reta_existente in self.retas:
            if nova_reta.intercepta(reta_existente):
                raise ObjetoSobrepostoException(
                    f"A reta y={nova_reta.a}*x+{nova_reta.b} intercepta a reta y={reta_existente.a}*x+{reta_existente.b}"
                )
        self.retas.append(nova_reta)

    def adicionarPonto(self, ponto):
        for reta in self.retas:
            if reta.estaNaReta(ponto):
                raise ObjetoSobrepostoException(
                    f"O ponto ({ponto.x},{ponto.y}) está sobreposto à reta y={reta.a}*x+{reta.b}"
                )
        self.pontos.append(ponto)