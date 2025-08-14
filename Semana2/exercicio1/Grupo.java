package exercicio1;
public class Grupo {
    private Pessoa[] pessoas = new Pessoa[5];
    private int numeroPessoas = 0;

    public Grupo() {}

    public void setPessoa(Pessoa pessoa) {
        if (this.numeroPessoas < 5) {
            pessoas[this.numeroPessoas] = pessoa;
            this.numeroPessoas++;
        }
    }

    public void ordena() {
        for (int i = 0; i < 5; i++) {
            for (int j = i + 1; j < 5; j++) {
                if (this.pessoas[j].calculaIMC() > this.pessoas[i].calculaIMC()) {
                   Pessoa aux = this.pessoas[j]; 
                   this.pessoas[j] = this.pessoas[i];
                   this.pessoas[i] = aux;
                }
            }
        }       
    }

    public Pessoa getPessoa(int index) {
        return pessoas[index];
    }
}
