package Dados;

import java.util.List;

public class Veiculo {
    private String marca;
    private String cor;
    private String modelo;
    private int ano;
    private String placa;
    private List<Orcamento> orcamentos;
    private Cliente dono;

    public Veiculo() {}

    public String getMarca() { return this.marca; }
    public void setMarca(String marca) { this.marca = marca; }

    public String getCor() { return this.cor; }
    public void setCor(String cor) { this.cor = cor; }

    public String getModelo() { return this.modelo; }
    public void setModelo(String modelo) { this.modelo = modelo; }

    public int getAno() { return this.ano; }
    public void setAno(int ano) { this.ano = ano; }

    public String getPlaca() { return this.placa; }
    public void setPlaca(String placa) { this.placa = placa; }

    public List<Orcamento> getOrcamentos() { return this.orcamentos; }
    public void addOrcamento(Orcamento orcamento) { this.orcamentos.add(orcamento); }

    public Cliente getDono() { return this.dono; }
    public void setDono(Cliente dono) { this.dono = dono;}

    public float calculaOrcamentos() {
        float valorTotal = 0;
        for (Orcamento o : orcamentos) {
            if(o.getFinalizado()) valorTotal += o.calculaValor();
        }
        return valorTotal;
    }

    public String toString() { return "marca: " + this.getMarca() + " modelo: " + this.getModelo(); }

}
