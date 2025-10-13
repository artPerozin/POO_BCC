package TrabalhoPOO.Usecase;

import TrabalhoPOO.Infra.*;
import TrabalhoPOO.Domain.*;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        Artista a1 = new Artista("Artista A");
        Artista a2 = new Artista("Artista B");
        List<Artista> artistas = Arrays.asList(a1, a2);

        Musica m1 = new Musica("musiquinha", "musicas/musiquinha.mp3", 180);
        m1.addArtista(a1);
        List<Musica> musicas = Arrays.asList(m1);

        Usuario u1 = new Usuario("Alice", "alice@email.com", "123");
        Usuario u2 = new Usuario("Bob", "bob@email.com", "abc");

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

        System.out.println("\nLISTA DE MÚSICAS:");
        appMusica.listarMusicas().forEach(System.out::println);

        System.out.println("\nLISTA DE ARTISTAS:");
        appMusica.listarArtistas().forEach(System.out::println);

        System.out.println("\nPLAYLISTS DO USUÁRIO:");
        appMusica.listarPlaylistsUsuario(usuario).forEach(System.out::println);

        System.out.println("\nTocando preview da música '" + m1.getTitulo() + "'...");
        appMusica.tocarPreview(m1);

        System.out.println("\nAdicionando música à playlist 'Favoritas da Alice'...");
        appMusica.adicionarMusicaPlaylist(usuario, "Favoritas da Alice", m1);
        appMusica.listarPlaylistsUsuario(usuario).forEach(System.out::println);

        System.out.println("\nRemovendo música da playlist 'Favoritas da Alice'...");
        appMusica.removerMusicaPlaylist(usuario, "Favoritas da Alice", m1);
        appMusica.listarPlaylistsUsuario(usuario).forEach(System.out::println);

        System.out.println("\nUSUÁRIOS:");
        usuarios.forEach(System.out::println);

        System.out.println("\nMÚSICAS:");
        musicas.forEach(System.out::println);

        System.out.println("\nARTISTAS:");
        artistas.forEach(System.out::println);
    }
}
