

import java.util.Date;

public class Emprestimo {
    private Usuario usuario;
    private Livro livro;
    private Date dataDevolucao;

    public Emprestimo() {}

    public Emprestimo(Usuario usuario, Livro livro, Date dataDevolucao) {
        this.usuario = usuario;
        this.livro = livro;
        this.dataDevolucao = dataDevolucao;
    }

    public Usuario getUsuario() { return usuario; }
    public void setUsuario(Usuario usuario) { this.usuario = usuario; }

    public Livro getLivro() { return livro; }
    public void setLivro(Livro livro) { this.livro = livro; }

    public Date getDataDevolucao() { return dataDevolucao; }
    public void setDataDevolucao(Date dataDevolucao) { this.dataDevolucao = dataDevolucao; }

    @Override
    public String toString() {
        return "Emprestimo [usuario=" + usuario.getNome() + ", livro=" + livro.getTitulo() 
               + ", devolução=" + dataDevolucao + "]";
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (!(obj instanceof Emprestimo)) return false;
        Emprestimo e = (Emprestimo) obj;
        return this.livro.equals(e.livro) && this.usuario.equals(e.usuario);
    }
}
