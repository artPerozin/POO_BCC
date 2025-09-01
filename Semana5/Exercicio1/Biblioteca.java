

import java.util.ArrayList;
import java.util.List;

public class Biblioteca {
    private String nome;
    private List<Livro> livros;
    private List<Usuario> usuarios;

    public Biblioteca() {
        this.livros = new ArrayList<>();
        this.usuarios = new ArrayList<>();
    }

    public Biblioteca(String nome) {
        this.nome = nome;
        this.livros = new ArrayList<>();
        this.usuarios = new ArrayList<>();
    }

    public String getNome() { return nome; }
    public void setNome(String nome) { this.nome = nome; }

    public List<Livro> getLivros() { return livros; }
    public void addLivro(Livro livro) { this.livros.add(livro); }

    public List<Usuario> getUsuarios() { return usuarios; }
    public void addUsuario(Usuario usuario) { this.usuarios.add(usuario); }

    public String toString() {
        return "Biblioteca [nome=" + nome + ", livros=" + livros.size() 
               + ", usuarios=" + usuarios.size() + "]";
    }

    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (!(obj instanceof Biblioteca)) return false;
        Biblioteca b = (Biblioteca) obj;
        return this.nome.equalsIgnoreCase(b.nome);
    }
}
