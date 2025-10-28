package Dados;

import java.util.List;

public class Orcamento {
    private String dataEntrega;
    private String dataSaida;
    private boolean finalizado;
    private float valor;
    private List<Peca> pecas;
    private Mecanico mecanicoResponsavel;

    public Orcamento() {}

    public String getDataEntrega() { return this.dataEntrega; }
    public void setDataEntrega(String dataEntrega) {this.dataEntrega = dataEntrega; }

    public String getDataSaida() { return this.dataSaida; }
    public void setDataSaida(String dataSaida) { this.dataSaida = dataSaida; }

    public boolean getFinalizado() { return this.finalizado; }
    public void finalizaConserto(boolean finalizado) { this.finalizado = finalizado; }

    public float getValor() { return this.valor; }
    public void setValor(float valor) { this.valor = valor; }

    public List<Peca> getPecas() { return this.getPecas(); }
    public void adicionaPeca(Peca peca) {this.pecas.add(peca); }

    public Mecanico getMecanicoResponsavel() { return this.mecanicoResponsavel; }
    public void adicionaMecanico (Mecanico mecanicoResponsavel) { this.mecanicoResponsavel = mecanicoResponsavel;}

    public float calculaValor() {
        int valorTotal = 0;
        for (Peca p : pecas) {
            valorTotal += p.getPreco();
        }
        this.setValor(valorTotal);
        return this.getValor();
    }
    
    public String toString() {return "data de entrega: " + this.getDataEntrega() + " data de saida: " + this.getDataSaida() + " finalizado? " + this.finalizado; }

}
