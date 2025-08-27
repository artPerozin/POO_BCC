package Semana3.SistemaDePassagensUML.src.domain;

import java.util.ArrayList;
import java.util.List;

import Semana3.SistemaDePassagensUML.src.infra.Cidade;
import Semana3.SistemaDePassagensUML.src.infra.Cliente;
import Semana3.SistemaDePassagensUML.src.infra.Reserva;

public class ReservaPassagem {

    private List<Cidade> cidades = new ArrayList<>();
    private List<Cliente> clientes = new ArrayList<>();

    public ReservaPassagem() {
    }

    public void cadastrarCidade (Cidade cidade) {
        cidades.add(cidade);
        System.out.println("Cidade cadastrada com sucesso!");
    }

    public Cidade[] mostrarCidades () {
        return this.cidades.toArray(new Cidade[0]);
    }

    public void cadastrarCliente (Cliente cliente) {
        clientes.add(cliente);
        System.out.println("Cliente cadastrado com sucesso!");
    }

    public Cliente[] mostrarClientes () {
        return this.clientes.toArray(new Cliente[0]);
    }

    public void reservarIda (Cliente cliente, Reserva reserva) {
        cliente.reservarIda(reserva);
    }

    public void reservarVolta (Cliente cliente, Reserva ida, Reserva volta) {
        cliente.reservarVolta(ida, volta);
    }

    public Reserva[] mostrarReservas (String cpfCliente) {
        for (Cliente cliente : clientes) {
            if (cliente.getCpf().equals(cpfCliente)) {
                return cliente.getReservas().toArray(new Reserva[0]);
            }
        }
        return new Reserva[0];
    }
}
