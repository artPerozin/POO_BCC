package TrabalhoPOO.Infra;

import java.util.ArrayList;
import java.util.List;

public class Musica {
    private String titulo;
    private String arquivoMP3;
    private int duracao;
    private List<Artista> artistas;

    public Musica() {
        this.artistas = new ArrayList<>();
    }

    public Musica(
        String titulo,
        String arquivoMP3,
        int duracao
    ) {
        this();
        this.titulo = titulo;
        this.arquivoMP3 = arquivoMP3;
        this.duracao = duracao;
    }

    public String getTitulo() { return titulo; }
    public void setTitulo(String titulo) { this.titulo = titulo; }

    public String getArquivoMP3() { return arquivoMP3; }
    public void setArquivoMP3(String arquivoMP3) { this.arquivoMP3 = arquivoMP3; }

    public int getDuracao() { return duracao; }
    public void setDuracao(int duracao) { this.duracao = duracao; }

    public List<Artista> getArtistas() { return artistas; }
    public void addArtista(Artista artista) {
        if (!this.artistas.contains(artista)) {
            this.artistas.add(artista);
            artista.addMusica(this);
        }
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("- ").append(getTitulo()).append(" | Artistas: ");

        for (Artista a : getArtistas()) {
            sb.append(a.getNome()).append(" ");
        }

        return sb.toString().trim();
    }
}
