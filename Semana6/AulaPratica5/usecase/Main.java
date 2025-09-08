package Semana6.AulaPratica5.usecase;

import Semana6.AulaPratica5.domain.ListaTelefonica;
import Semana6.AulaPratica5.infra.Contato;

import java.util.*;

public class Main {

    private ListaTelefonica listaTelefonica;

    public Main() {
        this.listaTelefonica = new ListaTelefonica();
    }

    public void adicionarContato(Contato contato) {
        listaTelefonica.adicionarContato(contato);
    }

    public void removerContato(Contato contato) {
        listaTelefonica.removerContato(contato);
    }

    public List<Contato> buscarContatos(char letra) {
        return listaTelefonica.buscarContatos(letra);
    }

    public Map<Character, List<Contato>> buscarContatos() {
        return listaTelefonica.buscarContatos();
    }

    // Novo método: listar todos os contatos (facilita remoção)
    public List<Contato> listarTodos() {
        return listaTelefonica.listarTodos();
    }

    public static void main(String[] args) {
        Main app = new Main();
        Scanner sc = new Scanner(System.in);

        while (true) {
            System.out.println("\n=== MENU LISTA TELEFÔNICA ===");
            System.out.println("1 - Adicionar contato");
            System.out.println("2 - Remover contato");
            System.out.println("3 - Buscar contatos por letra");
            System.out.println("4 - Listar contatos agrupados");
            System.out.println("5 - Sair");
            System.out.print("Escolha uma opção: ");
            int opcao = sc.nextInt();
            sc.nextLine(); // consumir quebra de linha

            switch (opcao) {
                case 1: {
                    System.out.print("Digite o nome: ");
                    String nome = sc.nextLine();
                    System.out.print("Digite o telefone: ");
                    int telefone = sc.nextInt();
                    sc.nextLine();

                    Contato novo = new Contato();
                    novo.setNome(nome);
                    novo.setTelefone(telefone);

                    app.adicionarContato(novo);
                    System.out.println("✅ Contato adicionado com sucesso!");
                    break;
                }

                case 2: {
                    System.out.print("Digite o nome do contato a remover: ");
                    String nome = sc.nextLine();

                    Contato remover = null;
                    for (Contato c : app.listarTodos()) {
                        if (c.getNome().equalsIgnoreCase(nome)) {
                            remover = c;
                            break;
                        }
                    }

                    if (remover != null) {
                        app.removerContato(remover);
                        System.out.println("🗑️ Contato removido!");
                    } else {
                        System.out.println("⚠️ Contato não encontrado!");
                    }
                    break;
                }

                case 3: {
                    System.out.print("Digite a letra: ");
                    char letra = sc.nextLine().charAt(0);

                    List<Contato> encontrados = app.buscarContatos(letra);
                    if (encontrados.isEmpty()) {
                        System.out.println("⚠️ Nenhum contato encontrado!");
                    } else {
                        System.out.println("📒 Contatos com '" + letra + "':");
                        for (Contato c : encontrados) {
                            System.out.println(" - " + c.getNome() + " (" + c.getTelefone() + ")");
                        }
                    }
                    break;
                }

                case 4: {
                    Map<Character, List<Contato>> agrupados = app.buscarContatos();
                    if (agrupados.isEmpty()) {
                        System.out.println("⚠️ Nenhum contato na lista!");
                    } else {
                        System.out.println("📖 Contatos agrupados:");
                        for (Character letra : agrupados.keySet()) {
                            System.out.println("[" + letra + "]");
                            for (Contato c : agrupados.get(letra)) {
                                System.out.println(" - " + c.getNome() + " (" + c.getTelefone() + ")");
                            }
                        }
                    }
                    break;
                }

                case 5: {
                    System.out.println("👋 Saindo...");
                    sc.close();
                    return;
                }

                default:
                    System.out.println("⚠️ Opção inválida!");
            }
        }
    }
}