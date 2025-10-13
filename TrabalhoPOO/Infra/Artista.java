package TrabalhoPOO.Infra;

import java.util.ArrayList;
import java.util.List;

public class Artista {
    private String nome;
    private String biografia;
    private List<Musica> musicas;

    public Artista() {
        this.musicas = new ArrayList<>();
    }

    public Artista(String nome) {
        this();
        this.nome = nome;
    }

    public String getNome() { return nome; }
    public void setNome(String nome) { this.nome = nome; }

    public String getBiografia() { return biografia; }
    public void setBiografia(String biografia) { this.biografia = biografia; }

    public List<Musica> getMusicas() { return musicas; }
    public void addMusica(Musica musica) {
        if (!this.musicas.contains(musica)) {
            this.musicas.add(musica);
            if (!musica.getArtistas().contains(this)) {
                musica.getArtistas().add(this);
            }
        }
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("- ").append(nome).append(" | Músicas: ");

        for (Musica m : musicas) {
            sb.append(m.getTitulo()).append(" ");
        }

        return sb.toString().trim();
    }

}
