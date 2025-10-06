package AulaPratica8.Infra;

public class Contato {
    private String nome;
    private String telefone;

    public Contato(){}
    public Contato(
        String nome,
        String telefone
    ){
        this.nome = nome;
        this.telefone = telefone;
    }

    public void setNome(String nome) { this.nome = nome; }
    public String getNome() { return this.nome; }
    
    public void setTelefone(String telefone) { this.telefone = telefone; }
    public String getTelefone() { return this.telefone; }

    @Override
    public boolean equals(Object object) {
        if (this == object) return true;
        if (object == null || getClass() != object.getClass()) return false;
        Contato contato = (Contato) object;
        return (nome != null ? nome.equals(contato.nome) : contato.nome == null) &&
               (telefone != null ? telefone.equals(contato.telefone) : contato.telefone == null);
    }
}
