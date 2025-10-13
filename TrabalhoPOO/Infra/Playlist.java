package TrabalhoPOO.Infra;

import java.util.ArrayList;
import java.util.List;

public class Playlist {
    private String titulo;
    private String descricao;
    private List<Musica> musicas;

    public Playlist() {
        this.musicas = new ArrayList<>();
    }

    public Playlist(String titulo, String descricao) {
        this();
        this.titulo = titulo;
        this.descricao = descricao;
    }

    public List<Musica> getMusicas() { return this.musicas; }
    public void addMusica(Musica musica) { if (!this.musicas.contains(musica)) this.musicas.add(musica); }

    public String getTitulo() { return this.titulo; }
    public void setTitulo(String titulo) { this.titulo = titulo; }

    public String getDescricao() { return this.descricao; }
    public void setDescricao(String descricao) { this.descricao = descricao; }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("- Playlist: ").append(titulo)
        .append(" | Músicas: ");

        for (Musica m : musicas) {
            sb.append(m.getTitulo()).append(" ");
        }

        return sb.toString().trim();
    }
}
