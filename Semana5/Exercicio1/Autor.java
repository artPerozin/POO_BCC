

public class Autor {
    private String nome;
    private String nacionalidade;
    private int anoNascimento;

    public Autor() {}

    public Autor(String nome, String nacionalidade, int anoNascimento) {
        this.nome = nome;
        this.nacionalidade = nacionalidade;
        this.anoNascimento = anoNascimento;
    }

    public String getNome() { return nome; }
    public void setNome(String nome) { this.nome = nome; }

    public String getNacionalidade() { return nacionalidade; }
    public void setNacionalidade(String nacionalidade) { this.nacionalidade = nacionalidade; }

    public int getAnoNascimento() { return anoNascimento; }
    public void setAnoNascimento(int anoNascimento) { this.anoNascimento = anoNascimento; }

    public String toString() {
        return "Autor [nome=" + nome + ", nacionalidade=" + nacionalidade + ", anoNascimento=" + anoNascimento + "]";
    }

    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (!(obj instanceof Autor)) return false;
        Autor a = (Autor) obj;
        return this.nome.equalsIgnoreCase(a.nome);
    }
}
