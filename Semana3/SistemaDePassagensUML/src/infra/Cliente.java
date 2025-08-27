package Semana3.SistemaDePassagensUML.src.infra;

import java.util.ArrayList;
import java.util.List;

public class Cliente {
    private String cpf;
    private String nome;
    private String endereco;
    private String telefone;
    private List<Reserva> reservas = new ArrayList<>();

    public Cliente() {}

    public void reservarIda(Reserva reserva) {
        this.reservas.add(reserva);
    }

    public void reservarVolta(Reserva ida, Reserva volta) {
        ida.setVolta(volta);
        this.reservas.add(volta);
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public List<Reserva> getReservas() {
        return reservas;
    }

    public String toString() {
        return  "----------------------------\n" +
                "Nome:     " + nome + "\n" +
                "CPF:      " + cpf + "\n" +
                "Endereço: " + endereco + "\n" +
                "Telefone: " + telefone + "\n" +
                "----------------------------";
    }

    public boolean equals (Object o) {
        if( o instanceof Cliente) {
            Cliente C = (Cliente) o;
            if(C.getNome().equals(this.getNome())) {
                return true;
            }
        }
        return false;
    }
}
