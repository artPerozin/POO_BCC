package AulaPratica8.persistencia;

import AulaPratica8.Infra.Contato;
import java.util.*;
import java.io.*;
import java.nio.file.*;

public class ArquivoContatoDAO implements ContatoDAO {

    private String caminho;
    private List<Contato> contatos;

    public ArquivoContatoDAO(String caminho) {
        this.caminho = caminho;
        this.contatos = leContatos();
    }

    private String toCSV(Contato c) {
        return c.getNome() + ";" + c.getTelefone();
    }

    private Contato fromCSV(String s) {
        String[] partes = s.split(";");
        return new Contato(partes[0], partes[1]);
    }

    private List<Contato> leContatos() {
        List<Contato> lista = new ArrayList<>();
        try {
            if (!Files.exists(Paths.get(caminho))) {
                Files.createFile(Paths.get(caminho));
            }
            List<String> linhas = Files.readAllLines(Paths.get(caminho));
            for (String linha : linhas) {
                lista.add(fromCSV(linha));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return lista;
    }

    private void salvaContatos() {
        List<String> linhas = new ArrayList<>();
        for (Contato c : contatos) {
            linhas.add(toCSV(c));
        }
        try {
            Files.write(Paths.get(caminho), linhas);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void insert(Contato contato) {
        contatos.add(contato);
        salvaContatos();
    }

    @Override
    public void delete(Contato contato) {
        contatos.remove(contato);
        salvaContatos();
    }

    @Override
    public Map<Character, List<Contato>> getAll() {
        Map<Character, List<Contato>> mapa = new TreeMap<>();
        for (Contato c : contatos) {
            char letra = Character.toUpperCase(c.getNome().charAt(0));
            mapa.computeIfAbsent(letra, k -> new ArrayList<>()).add(c);
        }
        return mapa;
    }
}
