package Semana6.AulaPratica5.domain;

import Semana6.AulaPratica5.infra.Contato;
import java.util.*;

public class ListaTelefonica {

    private List<Contato> contatos;

    public ListaTelefonica() {
        this.contatos = new ArrayList<>();
    }

    public List<Contato> listarTodos() {
        return new ArrayList<>(contatos);
    }


    public void adicionarContato(Contato contato) {
        if (contato != null) {
            contatos.add(contato);
        }
    }

    public void removerContato(Contato contato) {
        contatos.remove(contato);
    }

    public List<Contato> buscarContatos(char letra) {
        List<Contato> resultado = new ArrayList<>();
        for (Contato c : contatos) {
            if (c.getNome() != null && !c.getNome().isEmpty() && 
                Character.toUpperCase(c.getNome().charAt(0)) == Character.toUpperCase(letra)) {
                resultado.add(c);
            }
        }
        return resultado;
    }

    public Map<Character, List<Contato>> buscarContatos() {
        Map<Character, List<Contato>> mapa = new HashMap<>();
        for (Contato c : contatos) {
            if (c.getNome() != null && !c.getNome().isEmpty()) {
                char inicial = Character.toUpperCase(c.getNome().charAt(0));
                mapa.putIfAbsent(inicial, new ArrayList<>());
                mapa.get(inicial).add(c);
            }
        }
        return mapa;
    }
}
