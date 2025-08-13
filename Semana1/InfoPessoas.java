import java.util.Scanner;

public class InfoPessoas {
    public static void main(String[] args) {
        Scanner leitor = new Scanner(System.in);
        String[] nomes = new String[5];
        int[] idades = new int[5];

        for (int i = 0; i < 5; i++) {
            System.out.println("Digite o nome da pessoa " + (i+1));
            nomes[i] = leitor.nextLine();
            System.out.println("Digite a idade da pessoa " + (i+1));
            idades[i] = Integer.parseInt(leitor.nextLine());
        }
        for (int i = 0; i < idades.length - 1; i++) {
            for (int j = 0; j < idades.length - 1 - i; j++) {
                if (idades[j] < idades[j + 1]) {
                    int tempIdade = idades[j];
                    idades[j] = idades[j + 1];
                    idades[j + 1] = tempIdade;

                    String tempNome = nomes[j];
                    nomes[j] = nomes[j + 1];
                    nomes[j + 1] = tempNome;
                }
            }
        }

        System.out.println("Pessoas ordenadas por idade (decrescente):");
        for (int i = 0; i < 5; i++) {
            System.out.println(nomes[i] + " - " + idades[i] + " anos");
        }

        leitor.close();
    }
}
