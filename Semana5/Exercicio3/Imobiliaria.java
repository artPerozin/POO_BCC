package Semana5.Exercicio3;

import java.util.Arrays;

class Imobiliaria {
    private String nome;
    private Imovel[] imoveis;
    private int quantidade;

    public Imobiliaria(String nome, int capacidade) {
        this.nome = nome;
        this.imoveis = new Imovel[capacidade];
        this.quantidade = 0;
    }

    public void adicionarImovel(Imovel imovel) {
        if (quantidade < imoveis.length) {
            imoveis[quantidade] = imovel;
            quantidade++;
        } else {
            System.out.println("Capacidade máxima atingida. Não é possível adicionar mais imóveis.");
        }
    }

    public Imovel[] filtrarPorArea(float x) {
        Imovel[] filtrados = new Imovel[quantidade];
        int count = 0;

        for (int i = 0; i < quantidade; i++) {
            if (imoveis[i].calcularArea() >= x) {
                filtrados[count++] = imoveis[i];
            }
        }

        filtrados = Arrays.copyOf(filtrados, count);

        Arrays.sort(filtrados, (a, b) -> Float.compare(a.getPreco(), b.getPreco()));

        return filtrados;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("Imobiliaria: " + nome + "\nImóveis disponíveis:\n");
        for (int i = 0; i < quantidade; i++) {
            sb.append(" - ").append(imoveis[i].toString()).append("\n");
        }
        return sb.toString();
    }
}
