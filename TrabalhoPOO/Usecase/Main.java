package TrabalhoPOO.Usecase;

import TrabalhoPOO.Infra.*;
import TrabalhoPOO.Domain.*;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        // Criar artistas
        Artista a1 = new Artista("Artista A");
        Artista a2 = new Artista("Artista B");
        List<Artista> artistas = Arrays.asList(a1, a2);

        // Criar música
        Musica m1 = new Musica("musiquinha", "musicas/musiquinha.mp3", 180);
        m1.addArtista(a1);
        List<Musica> musicas = Arrays.asList(m1);

        // Criar usuários
        Usuario u1 = new Usuario("Alice", "alice@email.com", "123");
        Usuario u2 = new Usuario("Bob", "bob@email.com", "abc");

        // Criar playlists
        Playlist p1 = new Playlist("Favoritas da Alice", "Músicas legais");
        p1.addMusica(m1);
        u1.addPlaylist(p1);
        u1.addMusicaFavorita(m1);

        Playlist p2 = new Playlist("Top do Bob", "As melhores do momento");
        u2.addPlaylist(p2);

        List<Usuario> usuarios = Arrays.asList(u1, u2);

        AppMusica appMusica = new AppMusica(usuarios, musicas, artistas);

        Usuario usuario = appMusica.autenticar("alice@email.com", "123");
        if (usuario == null) {
            System.out.println("Falha na autenticação!");
            return;
        }

        // Listar músicas e artistas
        appMusica.listarMusicas();
        appMusica.listarArtistas();

        // Listar playlists do usuário
        appMusica.listarPlaylistsUsuario(usuario);

        // Tocar prévia da música
        appMusica.tocarPreview(m1);

        // Adicionar música à playlist
        System.out.println("Adicionando música à playlist...");
        appMusica.adicionarMusicaPlaylist(usuario, "Favoritas da Alice", m1);
        appMusica.listarPlaylistsUsuario(usuario);

        // Remover música da playlist
        System.out.println("Removendo música da playlist...");
        appMusica.removerMusicaPlaylist(usuario, "Favoritas da Alice", m1);
        appMusica.listarPlaylistsUsuario(usuario);
    }
}
