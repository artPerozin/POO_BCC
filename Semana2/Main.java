import java.util.Random;

public class Main {
    public static void main(String[] args) {
        Grupo g = new Grupo();
        Random rand = new Random();

        for (int i = 0; i < 5; i++) {
            Pessoa p = new Pessoa();
            p.setNome("Pessoa " + i);
            p.setIdade(15 + rand.nextInt(50));
            p.setAltura(1.50 + rand.nextDouble() * 0.50);
            p.setMassa(50 + rand.nextDouble() * 50);
            g.setPessoa(p);
        }

        for (int i = 0; i < 5; i++) {
            System.out.println("Nome: " + g.getPessoa(i).getNome());
            System.out.println("Idade: " + g.getPessoa(i).getIdade());
            System.out.println("Massa: " + g.getPessoa(i).getMassa());
            System.out.println("Altura: " + g.getPessoa(i).getAltura());
            System.out.println("IMC: " + g.getPessoa(i).calculaIMC() + "\n");
        }
    }
}
