package TrabalhoPOO.Domain;

import TrabalhoPOO.Infra.*;
import javazoom.jl.player.Player;
import javazoom.jl.decoder.JavaLayerException;
import java.io.*;
import java.util.*;

public class AppMusica {
    private List<Usuario> usuarios;
    private List<Musica> musicas;
    private List<Artista> artistas;

    public AppMusica(
        List<Usuario> usuarios,
        List<Musica> musicas,
        List<Artista> artistas
    ) {
        this.usuarios = usuarios;
        this.musicas = musicas;
        this.artistas = artistas;
    }

    public Usuario autenticar(String email, String senha) {
        for (Usuario u : usuarios) {
            if (u.getEmail().equals(email) && u.getSenha().equals(senha)) return u;
        }
        return null;
    }

    public List<Musica> listarMusicas() { return this.musicas; }
    public List<Artista> listarArtistas() { return this.artistas; }
    public List<Playlist> listarPlaylistsUsuario(Usuario usuario) { return usuario.getPlaylists(); }

    public void adicionarMusicaPlaylist(Usuario usuario, String playlistTitulo, Musica musica) {
        for (Playlist p : usuario.getPlaylists()) {
            if (p.getTitulo().equalsIgnoreCase(playlistTitulo)) {
                p.addMusica(musica);
                return;
            }
        }
    }

    public void removerMusicaPlaylist(Usuario usuario, String playlistTitulo, Musica musica) {
        for (Playlist p : usuario.getPlaylists()) {
            if (p.getTitulo().equalsIgnoreCase(playlistTitulo)) {
                p.getMusicas().remove(musica);
                return;
            }
        }
    }

    public void tocarPreview(Musica musica) {
        try {
            FileInputStream fileInputStream = new FileInputStream(musica.getArquivoMP3());
            Player player = new Player(fileInputStream);
            player.play(300);
        } catch (FileNotFoundException e) {
            System.out.println("Arquivo não encontrado: " + musica.getArquivoMP3());
        } catch (JavaLayerException e) {
            System.out.println("Erro ao reproduzir áudio: " + e.getMessage());
        }
    }
}
