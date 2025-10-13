package Semana7.Usecases;

import Semana7.Domain.Zoologico;
import Semana7.Exceptions.EspacoIndisponivelException;
import Semana7.Infra.*;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Zoologico zoologico = new Zoologico();

        int opcao;
        do {
            System.out.println("\n=== MENU ZOOLÓGICO ===");
            System.out.println("1 - Cadastrar Viveiro");
            System.out.println("2 - Cadastrar Aquário");
            System.out.println("3 - Cadastrar Animal");
            System.out.println("4 - Cadastrar Peixe");
            System.out.println("5 - Alocar Animal em Viveiro");
            System.out.println("6 - Listar Viveiros");
            System.out.println("0 - Sair");
            System.out.print("Escolha: ");
            opcao = sc.nextInt();
            sc.nextLine(); // limpar buffer

            switch (opcao) {
                case 1: {
                    System.out.print("Nome do Viveiro: ");
                    String nome = sc.nextLine();
                    System.out.print("Comprimento: ");
                    float comp = sc.nextFloat();
                    System.out.print("Largura: ");
                    float larg = sc.nextFloat();

                    Viveiro v = new Viveiro();
                    v.setNome(nome);
                    v.setComprimento(comp);
                    v.setLargura(larg);

                    zoologico.cadastrarViveiro(v);
                    System.out.println("Viveiro cadastrado com sucesso!");
                    break;
                }
                case 2: {
                    System.out.print("Nome do Aquário: ");
                    String nome = sc.nextLine();
                    System.out.print("Comprimento: ");
                    float comp = sc.nextFloat();
                    System.out.print("Largura: ");
                    float larg = sc.nextFloat();
                    System.out.print("Altura: ");
                    float alt = sc.nextFloat();
                    System.out.print("Temperatura: ");
                    float temp = sc.nextFloat();

                    Aquario a = new Aquario();
                    a.setNome(nome);
                    a.setComprimento(comp);
                    a.setLargura(larg);
                    a.setAltura(alt);
                    a.setTemperatura(temp);

                    zoologico.cadastrarViveiro(a);
                    System.out.println("Aquário cadastrado com sucesso!");
                    break;
                }
                case 3: {
                    System.out.print("Nome do animal: ");
                    String nome = sc.nextLine();
                    System.out.print("Cor do animal: ");
                    String cor = sc.nextLine();
                    System.out.print("Espécie: ");
                    String especie = sc.nextLine();
                    System.out.print("Largura: ");
                    float largura = sc.nextFloat();
                    System.out.print("Comprimento: ");
                    float comprimento = sc.nextFloat();
                    System.out.print("Altura: ");
                    float altura = sc.nextFloat();

                    Animal a = new Animal(nome, cor, especie, largura, comprimento, altura);
                    zoologico.cadastrarAnimal(a);
                    System.out.println("Animal cadastrado com sucesso!");
                    break;
                }
                case 4: {
                    System.out.print("Nome do peixe: ");
                    String nome = sc.nextLine();
                    System.out.print("Cor do peixe: ");
                    String cor = sc.nextLine();
                    System.out.print("Espécie: ");
                    String especie = sc.nextLine();
                    System.out.print("Largura: ");
                    float largura = sc.nextFloat();
                    System.out.print("Comprimento: ");
                    float comprimento = sc.nextFloat();
                    System.out.print("Altura: ");
                    float altura = sc.nextFloat();
                    System.out.print("Temperatura ideal: ");
                    float tempIdeal = sc.nextFloat();

                    Peixe p = new Peixe(nome, cor, especie, largura, comprimento, altura, tempIdeal);
                    zoologico.cadastrarAnimal(p);
                    System.out.println("Peixe cadastrado com sucesso!");
                    break;
                }
                case 5: {
                    if (zoologico.getAnimais().isEmpty()) {
                        System.out.println("Nenhum animal cadastrado.");
                        break;
                    }
                    System.out.println("Animais cadastrados:");
                    int i = 1;
                    for (Animal a : zoologico.getAnimais()) {
                        System.out.println(i + " - " + a.getNome() + " (" + a.getEspecie() + ")");
                        i++;
                    }
                    System.out.print("Escolha o animal: ");
                    int idxAnimal = sc.nextInt() - 1;

                    if (zoologico.getViveiros().isEmpty()) {
                        System.out.println("Nenhum viveiro cadastrado.");
                        break;
                    }
                    System.out.println("Viveiros disponíveis:");
                    int j = 1;
                    for (Viveiro v : zoologico.getViveiros()) {
                        System.out.println(j + " - " + v.getNome() + " (" + v.getClass().getSimpleName() + ")");
                        j++;
                    }
                    System.out.print("Escolha o viveiro: ");
                    int idxViveiro = sc.nextInt() - 1;

                    Animal animalEscolhido = zoologico.getAnimais().get(idxAnimal);
                    Viveiro viveiroEscolhido = zoologico.getViveiros().get(idxViveiro);

                    try {
                        zoologico.alocarAnimal(animalEscolhido, viveiroEscolhido);
                    } catch (EspacoIndisponivelException e) {
                        e.printStackTrace();
                    }
                    break;
                }
                case 6: {
                    System.out.println("\n=== LISTA DE VIVEIROS ===");
                    for (Viveiro v : zoologico.getViveiros()) {
                        System.out.println("Viveiro: " + v.getNome() + " (" + v.getClass().getSimpleName() + ")");
                        if (v.getAnimals().isEmpty()) {
                            System.out.println("  -> Viveiro vazio");
                        } else {
                            for (Animal a : v.getAnimals()) {
                                if (a instanceof Peixe) {
                                    Peixe peixe = (Peixe) a;
                                    System.out.println("  - Peixe: " + peixe.getNome() +
                                            ", cor: " + peixe.getCor() +
                                            ", espécie: " + peixe.getEspecie() +
                                            ", temp ideal: " + peixe.getTemperaturaIdeal());
                                } else {
                                    System.out.println("  - Animal: " + a.getNome() +
                                            ", cor: " + a.getCor() +
                                            ", espécie: " + a.getEspecie());
                                }
                            }
                        }
                    }
                    break;
                }
                case 0: {
                    System.out.println("Saindo...");
                    break;
                }
                default: {
                    System.out.println("Opção inválida!");
                    break;
                }
            }
        } while (opcao != 0);

        sc.close();
    }
}
