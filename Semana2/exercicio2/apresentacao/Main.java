package exercicio2.apresentacao;

import java.util.Scanner;

import exercicio2.dados.SistemaPetShop;

public class Main {

    public static void main(String[] args) {
        Scanner leitor = new Scanner(System.in);
        SistemaPetShop sistema = new SistemaPetShop();
        
        int opcao = -1;

        while (opcao != 0) {
            imprimeMenu();
            opcao = leitor.nextInt();

            switch (opcao) {
                case 0:
                    break;
                case 1:
                    sistema.cadastrarVeterinario();
                    break;
                case 2:
                    sistema.mostrarVeterinarios();
                    break;
                case 3:
                    sistema.cadastrarEnderecoVeterinario();
                    break;
                case 4:
                    sistema.cadastrarAnimal();
                    break;
                case 5:
                    sistema.mostrarAnimais();
                    break;
                case 6:
                    sistema.cadastrarDono();
                    break;                
                default:
                    System.out.println("Opcao invalida!");
                    break;
            }
        }

        leitor.close();
    }

    public static void imprimeMenu() {
        System.out.println("Escolha uma Opcao: ");
        System.out.println("0 - Sair");
        System.out.println("1 - Cadastrar Veterinario");
        System.out.println("2 - Exibir Veterinarios");
        System.out.println("3 - Cadastrar Endereco do Veterinario");
        System.out.println("4 - Cadastrar Animal");
        System.out.println("5 - Exibir Animais");
        System.out.println("6 - Cadastrar Dono");
    }
}
