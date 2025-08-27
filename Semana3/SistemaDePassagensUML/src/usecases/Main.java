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
        System.out.print("Estado da cidade: ");
        String estado = sc.nextLine();

        Cidade cidade = new Cidade();

        cidade.setNome(nomeCidade);
        cidade.setEstado(estado);

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
            System.out.println("[" + i + "] " + clientes[i]);
        }
        int escolhaCliente = sc.nextInt();
        sc.nextLine();

        Cliente cliente = clientes[escolhaCliente];
        Cidade[] cidades = sistema.mostrarCidades();

        if (cidades.length < 2) {
            System.out.println("É necessário ter pelo menos 2 cidades cadastradas!");
            return;
        }

        System.out.println("Escolha a cidade de origem:");
        for (int i = 0; i < cidades.length; i++) {
            System.out.println("[" + i + "] " + cidades[i]);
        }
        int origemIndex = sc.nextInt();
        sc.nextLine();

        System.out.println("Escolha a cidade de destino:");
        for (int i = 0; i < cidades.length; i++) {
            if (i == origemIndex) continue;
            System.out.println("[" + i + "] " + cidades[i]);
        }
        int destinoIndex = sc.nextInt();
        sc.nextLine();

        Cidade origem = cidades[origemIndex];
        Cidade destino = cidades[destinoIndex];

        System.out.print("Número da reserva: ");
        int numReserva = sc.nextInt();
        sc.nextLine();

        System.out.print("Data da viagem (dd/mm/aaaa): ");
        String dataVoo = sc.nextLine();

        System.out.print("Hora da viagem (hh:mm): ");
        String horaVoo = sc.nextLine();

        System.out.print("Preço da passagem: R$ ");
        float preco = sc.nextFloat();
        sc.nextLine();

        System.out.print("Classe (Econômica, Executiva, Primeira): ");
        String classeVoo = sc.nextLine();

        System.out.print("Ida e volta? (true/false): ");
        boolean idaEvolta = sc.nextBoolean();
        sc.nextLine();

        System.out.print("Número da poltrona: ");
        int poltrona = sc.nextInt();
        sc.nextLine();

        Reserva reserva = new Reserva();
        reserva.setNumReserva(numReserva);
        reserva.setDataVoo(dataVoo);
        reserva.setHoraVoo(horaVoo);
        reserva.setPreco(preco);
        reserva.setClasseVoo(classeVoo);
        reserva.setIdaEvolta(idaEvolta);
        reserva.setPoltrona(poltrona);
        reserva.setOrigem(origem);
        reserva.setDestino(destino);

        if (idaEvolta) {
            System.out.println("Preencha os dados da volta:");
            System.out.print("Data da volta (dd/mm/aaaa): ");
            String dataVolta = sc.nextLine();
            System.out.print("Hora da volta (hh:mm): ");
            String horaVolta = sc.nextLine();
            System.out.print("Preço da passagem de volta: R$ ");
            float precoVolta = sc.nextFloat();
            sc.nextLine();
            System.out.print("Classe da volta: ");
            String classeVolta = sc.nextLine();
            System.out.print("Número da poltrona da volta: ");
            int poltronaVolta = sc.nextInt();
            sc.nextLine();

            Reserva reservaVolta = new Reserva();
            reservaVolta.setNumReserva(numReserva + 1);
            reservaVolta.setDataVoo(dataVolta);
            reservaVolta.setHoraVoo(horaVolta);
            reservaVolta.setPreco(precoVolta);
            reservaVolta.setClasseVoo(classeVolta);
            reservaVolta.setIdaEvolta(false);
            reservaVolta.setPoltrona(poltronaVolta);
            reservaVolta.setOrigem(destino);
            reservaVolta.setDestino(origem);

            reserva.setVolta(reservaVolta);
        }

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
