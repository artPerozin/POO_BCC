class Reta:
    def __init__(self, a, b):
        self.a = a
        self.b = b

    def intercepta(self, outra):
        if self.a == outra.a:
            return False
        return True

    def estaNaReta(self, ponto):
        return ponto.y == self.a * ponto.x + self.b