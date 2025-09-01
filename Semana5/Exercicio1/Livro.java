

public class Livro {
    private String titulo;
    private String isbn;
    private Autor autor;

    public Livro() {}

    public Livro(String titulo, String isbn, Autor autor) {
        this.titulo = titulo;
        this.isbn = isbn;
        this.autor = autor;
    }

    public String getTitulo() { return titulo; }
    public void setTitulo(String titulo) { this.titulo = titulo; }

    public String getIsbn() { return isbn; }
    public void setIsbn(String isbn) { this.isbn = isbn; }

    public Autor getAutor() { return autor; }
    public void setAutor(Autor autor) { this.autor = autor; }

    @Override
    public String toString() {
        return "Livro [titulo=" + titulo + ", isbn=" + isbn + ", autor=" + autor.getNome() + "]";
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (!(obj instanceof Livro)) return false;
        Livro l = (Livro) obj;
        return this.isbn.equals(l.isbn);
    }
}
