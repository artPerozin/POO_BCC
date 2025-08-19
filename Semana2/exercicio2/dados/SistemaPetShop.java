package exercicio2.dados;
import java.util.Scanner;

public class SistemaPetShop {
    private Veterinario[] veterinarios = new Veterinario[50];
    private int quantidadeVeterinarios;
    private Scanner leitor = new Scanner(System.in);

    public void cadastrarVeterinario() {
        if (quantidadeVeterinarios >= veterinarios.length) {
            System.out.println("Limite de veterinários atingido.");
            return;
        }
        System.out.print("Nome do veterinário: ");
        String nome = leitor.nextLine();
        System.out.print("Salário do veterinário: ");
        double salario = leitor.nextDouble();
        leitor.nextLine();
        veterinarios[quantidadeVeterinarios] = new Veterinario(nome, salario);
        quantidadeVeterinarios++;
        System.out.println("Veterinário cadastrado com sucesso!");
    }

    public void mostrarVeterinarios() {
        for (int i = 0; i < quantidadeVeterinarios; i++) {
            System.out.println(i + " - " + veterinarios[i].toString());
        }
    }

    public void cadastrarEnderecoVeterinario() {
        if (quantidadeVeterinarios == 0) {
            System.out.println("Nenhum veterinário cadastrado.");
            return;
        }
        mostrarVeterinarios();
        System.out.print("Escolha o número do veterinário para cadastrar endereço: ");
        int idx = leitor.nextInt();
        leitor.nextLine();
        if (idx < 0 || idx >= quantidadeVeterinarios) {
            System.out.println("Índice inválido.");
            return;
        }
        System.out.print("Rua: ");
        String rua = leitor.nextLine();
        System.out.print("Número: ");
        String numero = leitor.nextLine();
        System.out.print("Bairro: ");
        String bairro = leitor.nextLine();
        System.out.print("Cidade: ");
        String cidade = leitor.nextLine();
        System.out.print("Estado: ");
        String estado = leitor.nextLine();
        System.out.print("CEP: ");
        String cep = leitor.nextLine();

        Endereco endereco = new Endereco(rua, numero, bairro, cidade, estado, cep);
        veterinarios[idx].setEndereco(endereco);
        System.out.println("Endereço cadastrado com sucesso!");
    }

    public void cadastrarAnimal() {
        if (quantidadeVeterinarios == 0) {
            System.out.println("Nenhum veterinário cadastrado.");
            return;
        }
        mostrarVeterinarios();
        System.out.print("Escolha o número do veterinário para cadastrar um animal: ");
        int idx = leitor.nextInt();
        leitor.nextLine();
        if (idx < 0 || idx >= quantidadeVeterinarios) {
            System.out.println("Índice inválido.");
            return;
        }
        System.out.print("Nome do animal: ");
        String nome = leitor.nextLine();
        System.out.print("Espécie do animal: ");
        String especie = leitor.nextLine();
        System.out.print("Descrição do animal: ");
        String descricao = leitor.nextLine();

        Animal animal = new Animal(nome, especie, descricao);
        veterinarios[idx].setAnimal(animal);
        System.out.println("Animal cadastrado com sucesso!");
    }

    public void mostrarAnimais() {
        if (quantidadeVeterinarios == 0) {
            System.out.println("Nenhum veterinário cadastrado.");
            return;
        }
        mostrarVeterinarios();
        System.out.print("Escolha o número do veterinário para visualizar os animais: ");
        int idx = leitor.nextInt();
        if (idx < 0 || idx >= quantidadeVeterinarios) {
            System.out.println("Índice inválido.");
            return;
        }
        Animal[] animais = veterinarios[idx].getAnimais();
        for (int i = 0; i < veterinarios[idx].getQuantidadeAnimais(); i++) {
            System.out.println(i + " - " + animais[i].toString());
        }
    }

    public void cadastrarDono() {
        if (quantidadeVeterinarios == 0) {
            System.out.println("Nenhum veterinário cadastrado.");
            return;
        }
        mostrarVeterinarios();
        System.out.print("Escolha o número do veterinário para visualizar os animais: ");
        int vetIdx = leitor.nextInt();
        leitor.nextLine();
        if (vetIdx < 0 || vetIdx >= quantidadeVeterinarios) {
            System.out.println("Índice inválido.");
            return;
        }
        Veterinario veterinario = veterinarios[vetIdx];
        if (veterinario.getQuantidadeAnimais() == 0) {
            System.out.println("Nenhum animal cadastrado para este veterinário.");
            return;
        }
        Animal[] animais = veterinarios[vetIdx].getAnimais();
        for (int i = 0; i < veterinarios[vetIdx].getQuantidadeAnimais(); i++) {
            System.out.println(i + " - " + animais[i].toString());
        }
        System.out.print("Escolha o número do animal para cadastrar um dono: ");
        int animalIdx = leitor.nextInt();
        leitor.nextLine();
        if (animalIdx < 0 || animalIdx >= veterinario.getQuantidadeAnimais()) {
            System.out.println("Índice inválido.");
            return;
        }
        System.out.print("Nome do dono: ");
        String nome = leitor.nextLine();
        System.out.print("CPF do dono: ");
        String cpf = leitor.nextLine();
        
        Dono dono = new Dono(nome, cpf);
        veterinario.getAnimal(animalIdx).setDono(dono);
        System.out.println("Dono cadastrado com sucesso!");
    }
}