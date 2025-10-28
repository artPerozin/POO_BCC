package Negocio;

import java.util.List;

import Dados.Cliente;
import Dados.Mecanico;
import Dados.Orcamento;
import Dados.Veiculo;

public class Oficina {
    private List<Mecanico> mecanicos;
    private List<Cliente> clientes;

    public Oficina() {}

    public void adicionarCliente(Cliente c) { this.clientes.add(c); }
    public void adicionarMecanico(Mecanico m) { this.mecanicos.add(m); }
    public void adicionarVeiculo(Cliente c, Veiculo v) { c.adicionarVeiculo(v); }
    public void adicionarOrcamento(Veiculo v, Orcamento o) { v.addOrcamento(o); }
    public List<Cliente> getClientes() { return this.clientes; }
    public List<Mecanico> getMecanicos() { return this.mecanicos; }
    public List<Veiculo> getVeiculos (Cliente c) { return c.getVeiculos(); }
    public List<Orcamento> getOrcamentos(Veiculo v) { return v.getOrcamentos(); }
}
