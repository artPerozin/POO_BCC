package Semana3.SistemaDePassagensUML.infra;

import java.util.Scanner;

public class ReservaPassagem {
    private Reserva[] reservas = new Reserva[50];
    private Cliente[] clientes = new Cliente[50];
    private Cidade[] cidades = new Cidade[50];
    private int quantidadeCidades = 0;
    private int quantidadeClientes = 0;

    private Scanner sc = new Scanner(System.in);

    public void cadastrarCidade(){
        if (quantidadeCidades >= cidades.length) {
            System.out.println("Limite de cidades atingido.");
            return;
        }
        System.out.print("Nome da Cidade: ");
        String nomeCidade = sc.nextLine();
        System.out.println("Digite o estado");
        String nomeEstado = sc.nextLine();
        cidades[quantidadeCidades] = new Cidade(nomeCidade, nomeEstado);
        quantidadeCidades++;
        System.out.println("Cidade cadastrada com sucesso!");
    }
    public void cadastrarCliente(){
        if (quantidadeClientes >= clientes.length) {
            System.out.println("Limite de clientes atingido.");
            return;
        }
        System.out.println("CPF: ");
        String cpf = sc.nextLine();
        System.out.println("Nome completo: ");
        String nome = sc.nextLine();
        System.out.println("Endereco: ");
        String endereco = sc.nextLine();
        System.out.println("Telefone: ");
        String telefone = sc.nextLine();
        clientes[quantidadeClientes] = new Cliente(cpf, nome, endereco, telefone);
        quantidadeClientes++;
        System.out.println("Cliente cadastrado com sucesso!"); 
    }
    public void reservarIda() {
        if (quantidadeClientes == 0) {
            System.out.println("Nenhum cliente cadastrado.");
            return;
        }
        if (quantidadeCidades < 2) {
            System.out.println("É necessário cadastrar pelo menos 2 cidades (origem e destino).");
            return;
        }
        if (reservas.length == quantidadeClientes) {
            System.out.println("Limite de reservas atingido.");
            return;
        }
        System.out.println("Digite o índice do cliente para fazer a reserva:");
        mostrarClientes();
        int idxCliente = sc.nextInt();
        sc.nextLine();
        Cliente cliente = clientes[idxCliente];

        System.out.println("Digite o índice da cidade de origem:");
        mostrarCidades();
        int idxOrigem = sc.nextInt();
        sc.nextLine();
        Cidade cidadeOrigem = cidades[idxOrigem];
        
        System.out.println("Digite o índice da cidade de destino:");
        mostrarCidades();
        int idxDestino = sc.nextInt();
        sc.nextLine();
        Cidade cidadeDestino = cidades[idxDestino];
        int numReserva = (int)(Math.random() * 1000000);
        sc.nextLine();

        System.out.print("Data do voo (dd/mm/aaaa): ");
        String dataVoo = sc.nextLine();
        System.out.print("Hora do voo (hh:mm): ");
        String horaVoo = sc.nextLine();
        System.out.print("Preço da passagem: ");
        float preco = sc.nextFloat();
        sc.nextLine();
        System.out.print("Classe do voo (Econômica, Executiva, Primeira): ");
        String classeVoo = sc.nextLine();
        System.out.print("Número da poltrona: ");
        int poltrona = sc.nextInt();
        sc.nextLine();
        System.out.print("É ida e volta? (true/false): ");
        boolean idaEvolta = sc.nextBoolean();
        sc.nextLine();

        Reserva reserva = new Reserva();
        reserva.setNumReserva(numReserva);
        reserva.setDataVoo(dataVoo);
        reserva.setHoraVoo(horaVoo);
        reserva.setPreco(preco);
        reserva.setClasseVoo(classeVoo);
        reserva.setPoltrona(poltrona);
        reserva.setIdaEvolta(idaEvolta);
        reserva.setOrigem(cidadeOrigem);
        reserva.setDestino(cidadeDestino);
        cliente.reservarIda(reserva);

        System.out.println("Reserva cadastrada com sucesso para o cliente " + cliente.getNome());
    }
    public void reservarVolta() {
        if (quantidadeClientes == 0) {
            System.out.println("Nenhum cliente cadastrado.");
            return;
        }
        System.out.println("Digite o índice do cliente para reservar a volta:");
        mostrarClientes();
        int idxCliente = sc.nextInt();
        sc.nextLine();
        Cliente cliente = clientes[idxCliente];

        Reserva[] reservasCliente = cliente.getReservas();
        if (reservasCliente == null || reservasCliente.length == 0) {
            System.out.println("O cliente não possui reservas de ida cadastradas.");
            return;
        }

        System.out.println("Selecione o índice da reserva de ida:");
        for (int i = 0; i < reservasCliente.length; i++) {
            if (reservasCliente[i] != null) {
                System.out.println(i + " - " + reservasCliente[i].toString());
            }
        }
        int idxIda = sc.nextInt();
        sc.nextLine();
        Reserva ida = reservasCliente[idxIda];
        int numReserva = (int)(Math.random() * 1000000);

        System.out.print("Data do voo de volta (dd/mm/aaaa): ");
        String dataVoo = sc.nextLine();
        System.out.print("Hora do voo de volta (hh:mm): ");
        String horaVoo = sc.nextLine();
        System.out.print("Preço da passagem de volta: ");
        float preco = sc.nextFloat();
        sc.nextLine();
        System.out.print("Classe do voo (Econômica, Executiva, Primeira): ");
        String classeVoo = sc.nextLine();
        System.out.print("Número da poltrona: ");
        int poltrona = sc.nextInt();
        sc.nextLine();

        Cidade cidadeOrigem = ida.getDestino();
        Cidade cidadeDestino = ida.getOrigem();

        Reserva volta = new Reserva();
        volta.setNumReserva(numReserva);
        volta.setDataVoo(dataVoo);
        volta.setHoraVoo(horaVoo);
        volta.setPreco(preco);
        volta.setClasseVoo(classeVoo);
        volta.setPoltrona(poltrona);
        volta.setIdaEvolta(true);
        volta.setOrigem(cidadeOrigem);
        volta.setDestino(cidadeDestino);
        cliente.reservarVolta(ida, volta);

        System.out.println("Reserva de volta cadastrada com sucesso para o cliente " + cliente.getNome());
    }
    public Reserva[] mostrarReservas(){
        System.out.println("Digite o CPF do cliente: ");
        String cpfCliente = sc.nextLine();
        for(int i = 0; i < quantidadeClientes; i++){
            Cliente cliente = clientes[i];
            if(cliente.getCpf() == cpfCliente) {
                cliente.getReservas();
            }
        }
        return reservas;
    }
    public Cliente[] mostrarClientes() {
        for(int i = 0; i < quantidadeClientes; i++) {
            System.out.println(clientes[i].toString());
        }
        return clientes;
    }
    public Cidade[] mostrarCidades() {
        for(int i = 0; i < quantidadeCidades; i++) {
            System.out.println(cidades[i].toString());
        }
        return cidades;
    }
}
