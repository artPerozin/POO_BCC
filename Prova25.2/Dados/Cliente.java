package Dados;

import java.util.List;

public class Cliente extends Pessoa {
    private List<Veiculo> veiculos;
    
    public Cliente() {};

    public List<Veiculo> getVeiculos() { return this.veiculos; }
    public void adicionarVeiculo(Veiculo veiculo) {
        this.veiculos.add(veiculo);
    }

    public void removerVeiculo(Veiculo veiculo) {
        this.veiculos.remove(veiculo);
    }

    public float calculaOrcamentosVeiculos() {
        int valorTotal = 0;
        for(Veiculo v : veiculos){
            valorTotal += v.calculaOrcamentos();
        }
        return valorTotal;
    }

    public String toString() {
        return "nome: " + this.getNome() + " telefone: " + this.getTelefone();
    }
}
