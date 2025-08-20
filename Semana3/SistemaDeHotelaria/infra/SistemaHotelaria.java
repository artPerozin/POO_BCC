package infra;

public class SistemaHotelaria {
    private Funcionario[] funcionarios = new Funcionario[50];
    private Hospede[] hospedes = new Hospede[50];
    private Quarto[] quartos = new Quarto[50];
    private Reserva[] reservas = new Reserva[200];

    private int quantidadeFuncionarios = 0;
    private int quantidadeHospedes = 0;
    private int quantidadeQuartos = 0;
    private int quantidadeReservas = 0;

    // ---- CADASTROS ----

    public void cadastrarFuncionario(String nome, String cpf, String cargo, double salario){
        Funcionario funcionario = new Funcionario(nome, cpf, cargo, salario);
        if(quantidadeFuncionarios < funcionarios.length){
            funcionarios[quantidadeFuncionarios] = funcionario;
            quantidadeFuncionarios++;
        } else {
            System.out.println("Limite de funcionários atingido!");
        }
    }

    public void cadastrarHospede(String nome, String cpf, int numeroQuarto) {
        Hospede hospede = new Hospede(nome, cpf, numeroQuarto);
        if(quantidadeHospedes < hospedes.length) {
            hospedes[quantidadeHospedes] = hospede;
            quantidadeHospedes++;
        } else {
            System.out.println("Limite de hóspedes atingido!");
        }
    }

    public void cadastrarQuarto(int numero, Funcionario funcionarioResponsavel) {
        Quarto quarto = new Quarto(numero, funcionarioResponsavel, true);
        if(quantidadeQuartos < quartos.length) {
            quartos[quantidadeQuartos] = quarto;
            quantidadeQuartos++;
        } else {
            System.out.println("Limite de quartos atingido!");
        }
    }

    public void cadastrarReserva(int numeroReserva, Hospede hospede, String dataEntrada, String dataSaida) {
        Quarto quartoDisponivel = buscarPrimeiroQuartoDisponivel();
        if(quartoDisponivel != null) {
            Reserva reserva = new Reserva(numeroReserva, hospede, quartoDisponivel, dataEntrada, dataSaida);
            if(quantidadeReservas < reservas.length) {
                reservas[quantidadeReservas] = reserva;
                quantidadeReservas++;
                quartoDisponivel.setDisponivel(false);
                System.out.println("Reserva cadastrada no quarto " + quartoDisponivel.getNumero());
            } else {
                System.out.println("Limite de reservas atingido!");
            }
        } else {
            System.out.println("Nenhum quarto disponível!");
        }
    }

    // ---- MÉTODOS AUXILIARES ----

    private Quarto buscarPrimeiroQuartoDisponivel() {
        for(int i = 0; i < quantidadeQuartos; i++) {
            if(quartos[i].isDisponivel()) {
                return quartos[i];
            }
        }
        return null;
    }

    public int getQuantidadeFuncionarios() {
        return quantidadeFuncionarios;
    }

    public int getQuantidadeHospedes() {
        return quantidadeHospedes;
    }

    public int getQuantidadeQuartos() {
        return quantidadeQuartos;
    }

    public Funcionario getFuncionarioByIndex(int index) {
        if(index >= 0 && index < quantidadeFuncionarios) {
            return funcionarios[index];
        }
        return null;
    }

    public Hospede getHospedeByIndex(int index) {
        if(index >= 0 && index < quantidadeHospedes) {
            return hospedes[index];
        }
        return null;
    }

    public Quarto getQuartoByIndex(int index) {
        if(index >= 0 && index < quantidadeQuartos) {
            return quartos[index];
        }
        return null;
    }

    public void listarFuncionarios() {
        System.out.println("=== Funcionários ===");
        for(int i = 0; i < quantidadeFuncionarios; i++) {
            System.out.println(i + " - " + funcionarios[i].toString());
        }
    }

    public void listarHospedes() {
        System.out.println("=== Hóspedes ===");
        for(int i = 0; i < quantidadeHospedes; i++) {
            System.out.println("[" + i + "] " + hospedes[i].toString());
        }
    }

    public void listarQuartosDisponiveis() {
        System.out.println("=== Quartos Disponíveis ===");
        for(int i = 0; i < quantidadeQuartos; i++) {
            if(quartos[i].isDisponivel()) {
                System.out.println("[" + i + "] " + quartos[i].toString());
            }
        }
    }

    public void listarReservas() {
        System.out.println("=== Reservas ===");
        for(int i = 0; i < quantidadeReservas; i++) {
            System.out.println(reservas[i]);
        }
    }
}
