package TrabalhoPOO.Infra;

import java.util.ArrayList;
import java.util.List;

public class Usuario {
    private String nome;
    private String email;
    private String senha;
    private List<Musica> musicasFavoritas;
    private List<Playlist> playlists;

    public Usuario() {
        this.musicasFavoritas = new ArrayList<>();
        this.playlists = new ArrayList<>();
    }

    public Usuario(String nome, String email, String senha) {
        this();
        this.nome = nome;
        this.email = email;
        this.senha = senha;
    }

    public String getNome() { return nome; }
    public void setNome(String nome) { this.nome = nome; }

    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }

    public String getSenha() { return senha; }
    public void setSenha(String senha) { this.senha = senha; }

    public List<Musica> getMusicasFavoritas() { return musicasFavoritas; }
    public void addMusicaFavorita(Musica musica) {
        if (!this.musicasFavoritas.contains(musica)) this.musicasFavoritas.add(musica);
    }

    public List<Playlist> getPlaylists() { return playlists; }
    public void addPlaylist(Playlist playlist) {
        if (!this.playlists.contains(playlist)) this.playlists.add(playlist);
    }

    @Override
    public String toString() {
        return "Usuario{nome='" + nome + "', email='" + email + 
               "', favoritas=" + musicasFavoritas.size() + 
               ", playlists=" + playlists.size() + "}";
    }
}
