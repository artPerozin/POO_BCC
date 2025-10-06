package AulaPratica8.usecase;

import java.util.List;
import java.util.Map;
import java.util.Scanner;
import AulaPratica8.Infra.Contato;
import AulaPratica8.domain.ListaTelefonica;
import AulaPratica8.persistencia.ContatoDAOImpl;

public class Main {

    private static final Scanner scanner = new Scanner(System.in);
    private static final ListaTelefonica listaTelefonica = new ListaTelefonica(new ContatoDAOImpl());

    private static final String RESET = "\u001B[0m";
    private static final String CYAN = "\u001B[36m";
    private static final String GREEN = "\u001B[32m";
    private static final String RED = "\u001B[31m";
    private static final String YELLOW = "\u001B[33m";

    public static void main(String[] args) {
        int opcao;
        do {
            exibirMenu();
            System.out.print(YELLOW + "Escolha uma opção: " + RESET);
            while (!scanner.hasNextInt()) {
                System.out.print(RED + "Por favor, insira um número válido: " + RESET);
                scanner.next();
            }
            opcao = scanner.nextInt();
            scanner.nextLine();

            switch (opcao) {
                case 1: adicionarContato(); break;
                case 2: removerContato(); break;
                case 3: exibirContatos(); break;
                case 0: System.out.println(GREEN + "\nEncerrando o sistema... Até logo! 👋" + RESET); break;
                default: System.out.println(RED + "❌ Opção inválida. Tente novamente." + RESET); break;
            }

        } while (opcao != 0);
    }

    private static void exibirMenu() {
        System.out.println("\n" + CYAN + "==============================");
        System.out.println("      LISTA TELEFÔNICA 📞");
        System.out.println("==============================" + RESET);
        System.out.println(GREEN + "1." + RESET + " Adicionar contato");
        System.out.println(GREEN + "2." + RESET + " Remover contato");
        System.out.println(GREEN + "3." + RESET + " Listar contatos");
        System.out.println(GREEN + "0." + RESET + " Sair");
        System.out.println();
    }

    public static void adicionarContato() {
        System.out.println(CYAN + "\n--- Adicionar Contato ---" + RESET);
        System.out.print("Nome: ");
        String nome = scanner.nextLine().trim();
        System.out.print("Telefone: ");
        String telefone = scanner.nextLine().trim();

        if (nome.isEmpty() || telefone.isEmpty()) {
            System.out.println(RED + "⚠️ Nome e telefone não podem ser vazios!" + RESET);
            return;
        }

        Contato contato = new Contato(nome, telefone);
        listaTelefonica.adicionarContato(contato);
        System.out.println(GREEN + "✅ Contato adicionado com sucesso!" + RESET);
    }

    public static void removerContato() {
        System.out.println(CYAN + "\n--- Remover Contato ---" + RESET);
        System.out.print("Nome: ");
        String nome = scanner.nextLine().trim();
        System.out.print("Telefone: ");
        String telefone = scanner.nextLine().trim();

        Contato contato = new Contato(nome, telefone);
        listaTelefonica.removerContato(contato);
        System.out.println(RED + "🗑️  Contato removido (se existia na lista)." + RESET);
    }

    public static void exibirContatos() {
        System.out.println(CYAN + "\n--- Lista de Contatos ---" + RESET);
        Map<Character, List<Contato>> contatos = listaTelefonica.listarContatos();

        if (contatos.isEmpty()) {
            System.out.println(RED + "Nenhum contato cadastrado!" + RESET);
            return;
        }

        contatos.keySet().stream().sorted().forEach(letra -> {
            System.out.println(YELLOW + "\n[" + letra + "]" + RESET);
            contatos.get(letra).forEach(c -> System.out.println("📞 " + c.getNome() + " | " + c.getTelefone()));
        });
    }
}
