package usecase;

import infra.SistemaHotelaria;
import infra.Funcionario;
import infra.Hospede;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        SistemaHotelaria sistema = new SistemaHotelaria();

        int opcao;
        do {
            System.out.println("\n===== SISTEMA DE HOTELARIA =====");
            System.out.println("1 - Cadastrar Funcionário");
            System.out.println("2 - Cadastrar Hóspede");
            System.out.println("3 - Cadastrar Quarto");
            System.out.println("4 - Cadastrar Reserva");
            System.out.println("5 - Listar Funcionários");
            System.out.println("6 - Listar Hóspedes");
            System.out.println("7 - Listar Quartos Disponíveis");
            System.out.println("8 - Listar Reservas");
            System.out.println("0 - Sair");
            System.out.print("Escolha uma opção: ");
            opcao = sc.nextInt();
            sc.nextLine();

            switch (opcao) {
                case 1: {
                    System.out.print("Nome: ");
                    String nome = sc.nextLine();
                    System.out.print("CPF: ");
                    String cpf = sc.nextLine();
                    System.out.print("Cargo: ");
                    String cargo = sc.nextLine();
                    System.out.print("Salário: ");
                    double salario = sc.nextDouble();
                    sc.nextLine();
                    sistema.cadastrarFuncionario(nome, cpf, cargo, salario);
                    break;
                }
                case 2: {
                    System.out.print("Nome: ");
                    String nome = sc.nextLine();
                    System.out.print("CPF: ");
                    String cpf = sc.nextLine();
                    System.out.print("Número do Quarto: ");
                    int numeroQuarto = sc.nextInt();
                    sc.nextLine();
                    sistema.cadastrarHospede(nome, cpf, numeroQuarto);
                    break;
                }
                case 3: {
                    if (sistema.getQuantidadeFuncionarios() == 0) {
                        System.out.println("⚠ Cadastre ao menos um funcionário antes!");
                        break;
                    }
                    System.out.print("Número do Quarto: ");
                    int numero = sc.nextInt();
                    sc.nextLine();

                    System.out.println("Escolha o funcionário responsável:");
                    sistema.listarFuncionarios();
                    System.out.print("Índice do funcionário: ");
                    int idxFunc = sc.nextInt();
                    sc.nextLine();
                    Funcionario responsavel = sistema.getFuncionarioByIndex(idxFunc);

                    if (responsavel != null) {
                        sistema.cadastrarQuarto(numero, responsavel);
                    } else {
                        System.out.println("Funcionário inválido!");
                    }
                    break;
                }
                case 4: {
                    if (sistema.getQuantidadeHospedes() == 0) {
                        System.out.println("⚠ Cadastre ao menos um hóspede antes!");
                        break;
                    }

                    System.out.println("Escolha o hóspede para a reserva:");
                    sistema.listarHospedes();
                    System.out.print("Índice do hóspede: ");
                    int idxHospede = sc.nextInt();
                    sc.nextLine();
                    Hospede hospede = sistema.getHospedeByIndex(idxHospede);

                    if (hospede != null) {
                        System.out.print("Número da reserva: ");
                        int numeroReserva = sc.nextInt();
                        sc.nextLine();
                        System.out.print("Data de entrada: ");
                        String entrada = sc.nextLine();
                        System.out.print("Data de saída: ");
                        String saida = sc.nextLine();

                        sistema.cadastrarReserva(numeroReserva, hospede, entrada, saida);
                    } else {
                        System.out.println("Hóspede inválido!");
                    }
                    break;
                }
                case 5: sistema.listarFuncionarios(); break;
                case 6: sistema.listarHospedes(); break;
                case 7: sistema.listarQuartosDisponiveis(); break;
                case 8: sistema.listarReservas(); break;
                case 0: System.out.println("Saindo..."); break;
                default: System.out.println("Opção inválida!"); break;
            }

        } while (opcao != 0);

        sc.close();
    }
}
