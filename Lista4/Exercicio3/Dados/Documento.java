package Lista4.Exercicio3.Dados;

import Lista4.Exercicio3.Exceptions.NomeInvalidoException;

public class Documento extends Arquivo {
    private String texto;

    public Documento(String nome) throws NomeInvalidoException {
        super(nome);
        this.setExtensao(".txt");
    }

    public String getTexto() { return texto; }
    public void setTexto(String texto) { this.texto = texto; }

}