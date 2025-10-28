package Lista4.Exercicio3.Dados;

import Lista4.Exercicio3.Exceptions.NomeInvalidoException;

public class Video extends Arquivo {
    private Qualidade qualidade;

    public Video(String nome, Qualidade qualidade) throws NomeInvalidoException {
        super(nome);
        this.qualidade = qualidade;
        this.setExtensao(".mp4");
    }

    public Qualidade getQualidade() { return qualidade; }
    public void setQualidade(Qualidade qualidade) { this.qualidade = qualidade; }
}
