package Semana3.SistemaDePassagensUML.usecases;

import Semana3.SistemaDePassagensUML.infra.*;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ReservaPassagem sistema = new ReservaPassagem();

        int opcao;
        do {
            System.out.println("\n===== SISTEMA DE PASSAGENS =====");
            System.out.println("1 - Cadastrar Cidade");
            System.out.println("2 - Cadastrar Cliente");
            System.out.println("3 - Reservar Ida");
            System.out.println("4 - Reservar Volta");
            System.out.println("5 - Mostrar Cidades");
            System.out.println("6 - Mostrar Clientes");
            System.out.println("7 - Mostrar Reservas");
            System.out.println("0 - Sair");
            System.out.print("Escolha uma opção: ");
            opcao = sc.nextInt();
            sc.nextLine();

            switch (opcao) {
                case 1:
                    sistema.cadastrarCidade();
                    break;
                case 2:
                    sistema.cadastrarCliente();
                    break;
                case 3:
                    sistema.reservarIda();
                    break;
                case 4:
                    sistema.reservarVolta();
                    break;
                case 5:
                    sistema.mostrarCidades();
                    break;
                case 6:
                    sistema.mostrarClientes();
                    break;
                case 7:
                    sistema.mostrarReservas();
                    break;
                case 0:
                    System.out.println("Saindo do sistema...");
                    break;
                default:
                    System.out.println("Opção inválida!");
            }
        } while (opcao != 0);

        sc.close();
    }
}
