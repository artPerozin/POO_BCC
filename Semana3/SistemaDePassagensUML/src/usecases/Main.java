package Semana3.SistemaDePassagensUML.src.usecases;

import Semana3.SistemaDePassagensUML.src.domain.ReservaPassagem;
import Semana3.SistemaDePassagensUML.src.infra.Cidade;
import Semana3.SistemaDePassagensUML.src.infra.Cliente;
import Semana3.SistemaDePassagensUML.src.infra.Reserva;

import java.util.Scanner;

public class Main {
    private static ReservaPassagem sistema = new ReservaPassagem();
    private static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        int opcao = -1;

        do {
            System.out.println("\n===== SISTEMA DE RESERVAS =====");
            System.out.println("1 - Cadastrar Cliente");
            System.out.println("2 - Cadastrar Cidade");
            System.out.println("3 - Fazer Reserva");
            System.out.println("4 - Mostrar Reservas de um Cliente");
            System.out.println("0 - Sair");
            System.out.print("Escolha uma opção: ");
            opcao = sc.nextInt();
            sc.nextLine();

            switch (opcao) {
                case 1: cadastrarCliente(); break;
                case 2: cadastrarCidade(); break;
                case 3: fazerReserva(); break;
                case 4: mostrarReservas(); break;
                case 0: System.out.println("Encerrando o sistema...");
                default: System.out.println("Opção inválida!");
            }
        } while (opcao != 0);
    }

    public static void cadastrarCliente() {
        System.out.print("Nome do cliente: ");
        String nome = sc.nextLine();
        System.out.print("CPF do cliente: ");
        String cpf = sc.nextLine();
        System.out.print("Endereço do cliente: ");
        String endereco = sc.nextLine();
        System.out.print("Telefone do cliente: ");
        String telefone = sc.nextLine();

        Cliente cliente = new Cliente();

        cliente.setNome(nome);
        cliente.setCpf(cpf);
        cliente.setEndereco(endereco);
        cliente.setTelefone(telefone);

        sistema.cadastrarCliente(cliente);
    }

    public static void cadastrarCidade() {
        System.out.print("Nome da cidade: ");
        String nomeCidade = sc.nextLine();

        Cidade cidade = new Cidade();
        cidade.setNome(nomeCidade);
        sistema.cadastrarCidade(cidade);
    }

    public static void fazerReserva() {
        Cliente[] clientes = sistema.mostrarClientes();
        if (clientes.length == 0) {
            System.out.println("Nenhum cliente cadastrado!");
            return;
        }
        System.out.println("Escolha o cliente:");
        for (int i = 0; i < clientes.length; i++) {
            System.out.println((i + 1) + " \n " + clientes[i]);
        }
        int escolhaCliente = sc.nextInt();
        sc.nextLine();
        Cliente cliente = clientes[escolhaCliente - 1];

        Cidade[] cidades = sistema.mostrarCidades();
        if (cidades.length < 2) {
            System.out.println("É necessário ter pelo menos 2 cidades cadastradas!");
            return;
        }
        System.out.println("Escolha a cidade de origem:");
        for (int i = 0; i < cidades.length; i++) {
            System.out.println((i + 1) + " - " + cidades[i]);
        }
        int origemIndex = sc.nextInt();
        sc.nextLine();

        System.out.println("Escolha a cidade de destino:");
        for (int i = 0; i < cidades.length; i++) {
            if (i == origemIndex - 1) continue;
            System.out.println((i + 1) + " - " + cidades[i]);
        }
        int destinoIndex = sc.nextInt();
        sc.nextLine();

        Cidade origem = cidades[origemIndex - 1];
        Cidade destino = cidades[destinoIndex - 1];

        System.out.print("Data da viagem (dd/mm/aaaa): ");
        String data = sc.nextLine();

        Reserva reserva = new Reserva();
        reserva.setOrigem(origem);
        reserva.setDestino(destino);
        reserva.setDataVoo(data);

        sistema.reservarIda(cliente, reserva);

        System.out.println("Reserva feita com sucesso!");
    }

    public static void mostrarReservas() {
        System.out.print("Digite o CPF do cliente: ");
        String cpf = sc.nextLine();

        Reserva[] reservas = sistema.mostrarReservas(cpf);
        if (reservas.length == 0) {
            System.out.println("Nenhuma reserva encontrada para este cliente.");
        } else {
            System.out.println("Reservas do cliente:");
            for (Reserva r : reservas) {
                System.out.println(r);
            }
        }
    }
}
