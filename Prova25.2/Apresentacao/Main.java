package Apresentacao;

import java.util.List;
import java.util.Scanner;

import Dados.Cliente;
import Dados.Mecanico;
import Dados.Veiculo;
import Negocio.Oficina;

public class Main {
    Oficina oficina = new Oficina();
    static Scanner sc = new Scanner(System.in);
    
    public static void main(String[] args) {
        Main app = new Main();
        int opcao = -1;

        do {
            System.out.println("\n===== MENU =====");
            System.out.println("1 - Adicionar Cliente");
            System.out.println("2 - Adicionar Mecânico");
            System.out.println("3 - Adicionar Veículo");
            System.out.println("4 - Criar Orçamento");
            System.out.println("5 - Mostrar Clientes");
            System.out.println("6 - Mostrar Mecânicos");
            System.out.println("7 - Mostrar Info Orçamento");
            System.out.println("0 - Sair");
            System.out.print("Escolha: ");

            opcao = sc.nextInt();
            sc.nextLine();

            switch (opcao) {
                case 1: app.adicionarCliente(); break;
                case 2: app.adicionarMecanico(); break;
                case 3: app.adicionarVeiculo(); break;
                case 4: app.criarOrcamento(); break;
                case 5: app.mostrarClientes(); break;
                case 6: app.mostrarMecanicos(); break;
                case 7: app.mostrarInfoOrcamento(); break;
                case 0: System.out.println("Encerrando..."); break;
                default: System.out.println("Opção inválida!");
            }
        } while (opcao != 0);
    }

    public void adicionarCliente() {
        Cliente c = new Cliente(); 
        System.out.println("Qual o nome do seu cliente?");
        c.setNome(sc.nextLine());
        System.out.println("Qual o telefone do cliente?");
        c.setTelefone(sc.nextLine());
        this.oficina.adicionarCliente(c);
    }

    public void adicionarMecanico() {
        Mecanico m = new Mecanico(); 
        System.out.println("Qual o nome do mecanico?");
        m.setNome(sc.nextLine());
        System.out.println("Qual o telefone do mecanico?");
        m.setTelefone(sc.nextLine());
        System.out.println("Qual o valor da mao de obra do mecanico?");
        m.setValorMaoDeObra(sc.nextFloat());
        this.oficina.adicionarMecanico(m);
    }

    public void adicionarVeiculo() {
        Veiculo v = new Veiculo();
        this.mostrarClientes();
        System.out.println("A qual cliente pertence esse veiculo?");
        Cliente c = this.oficina.getClientes().get(sc.nextInt());
        System.out.println("Qual a marca do veiculo?");
        v.setMarca(sc.nextLine());
        System.out.println("Qual o modelo do veiculo?");
        v.setModelo(sc.nextLine());
        System.out.println("Qual a cor do veiculo?");
        v.setCor(sc.nextLine());
        System.out.println("Qual o ano do veiculo?");
        v.setAno(sc.nextInt());
        System.out.println("Qual a placa do veiculo?");
        v.setPlaca(sc.nextLine());

        this.oficina.adicionarVeiculo(c, v);
    }

    public void criarOrcamento() {

    }

    public void mostrarClientes() {
        List<Cliente> clientes = this.oficina.getClientes();
        for (Cliente c : clientes) {
            System.out.println(c.toString());
        }
    }

    public void mostrarMecanicos() {
        List<Mecanico> mecanicos = this.oficina.getMecanicos();
        for (Mecanico m : mecanicos) {
            System.out.println(m.toString());
        }
    }

    public void mostrarInfoOrcamento() {

    }
}
