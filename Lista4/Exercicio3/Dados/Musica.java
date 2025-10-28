package Lista4.Exercicio3.Dados;

import Lista4.Exercicio3.Exceptions.NomeInvalidoException;

public class Musica extends Arquivo {
    private int duracao;

    public Musica(String nome, int duracao) throws NomeInvalidoException {
        super(nome);
        this.setDuracao(duracao);
        this.setExtensao(".mp3");
    }

    public int getDuracao() { return duracao; }
    public void setDuracao(int duracao) { this.duracao = duracao; }
}
