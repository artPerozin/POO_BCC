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

    public AppMusica(List<Usuario> usuarios, List<Musica> musicas, List<Artista> artistas) {
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

    public void listarMusicas() {
        System.out.println("=== Músicas Cadastradas ===");
        for (Musica m : musicas) {
            System.out.print("- " + m.getTitulo() + " | Artistas: ");
            for (Artista a : m.getArtistas()) System.out.print(a.getNome() + " ");
            System.out.println();
        }
        System.out.println();
    }

    public void listarArtistas() {
        System.out.println("=== Artistas Cadastrados ===");
        for (Artista a : artistas) {
            System.out.print("- " + a.getNome() + " | Músicas: ");
            for (Musica m : a.getMusicas()) System.out.print(m.getTitulo() + " ");
            System.out.println();
        }
        System.out.println();
    }

    public void listarPlaylistsUsuario(Usuario u) {
        System.out.println("=== Playlists de " + u.getNome() + " ===");
        for (Playlist p : u.getPlaylists()) {
            System.out.println("* " + p.getTitulo() + " (" + p.getDescricao() + ")");
            for (Musica m : p.getMusicas()) System.out.println("  - " + m.getTitulo());
        }
        System.out.println();
    }

    public void adicionarMusicaPlaylist(Usuario u, String playlistTitulo, Musica musica) {
        for (Playlist p : u.getPlaylists()) {
            if (p.getTitulo().equalsIgnoreCase(playlistTitulo)) {
                p.addMusica(musica);
                System.out.println("Música adicionada à playlist " + p.getTitulo());
                return;
            }
        }
        System.out.println("Playlist não encontrada!");
    }

    public void removerMusicaPlaylist(Usuario u, String playlistTitulo, Musica musica) {
        for (Playlist p : u.getPlaylists()) {
            if (p.getTitulo().equalsIgnoreCase(playlistTitulo)) {
                p.getMusicas().remove(musica);
                System.out.println("Música removida da playlist " + p.getTitulo());
                return;
            }
        }
        System.out.println("Playlist não encontrada!");
    }

    public void tocarPreview(Musica musica) {
        try {
            FileInputStream fileInputStream = new FileInputStream(musica.getArquivoMP3());
            Player player = new Player(fileInputStream);
            System.out.println("Tocando prévia de: " + musica.getTitulo());
            player.play(300);
            System.out.println("Prévia finalizada.\n");
        } catch (FileNotFoundException e) {
            System.out.println("Arquivo não encontrado: " + musica.getArquivoMP3());
        } catch (JavaLayerException e) {
            System.out.println("Erro ao reproduzir áudio: " + e.getMessage());
        }
    }
}
