import java.util.Scanner;

public class Media {
    public static void main(String[] args) {
        Scanner leitor = new Scanner(System.in);
        float[] valores = new float[5];
        float soma = 0;
        for (int i = 0; i < 5; i++) {
            valores[i] = Float.parseFloat(leitor.nextLine());
        }
        for (float valor : valores) {
            soma += valor;
        }
        float media = soma / 5;
        System.out.println("A média é: " + media);
        leitor.close();
    }
}
