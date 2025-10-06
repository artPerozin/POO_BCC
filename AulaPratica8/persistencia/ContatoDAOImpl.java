package AulaPratica8.persistencia;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import AulaPratica8.Infra.Contato;

public class ContatoDAOImpl implements ContatoDAO {

    private final Map<Character, List<Contato>> contatos = new HashMap<>();

    @Override
    public void insert(Contato contato) {
        char primeiraLetra = Character.toUpperCase(contato.getNome().charAt(0));
        contatos.putIfAbsent(primeiraLetra, new ArrayList<>());
        contatos.get(primeiraLetra).add(contato);
    }

    @Override
    public void delete(Contato contato) {
        char primeiraLetra = Character.toUpperCase(contato.getNome().charAt(0));
        if (contatos.containsKey(primeiraLetra)) {
            contatos.get(primeiraLetra).removeIf(c -> 
                c.getNome().equals(contato.getNome()) && c.getTelefone().equals(contato.getTelefone())
            );
            if (contatos.get(primeiraLetra).isEmpty()) {
                contatos.remove(primeiraLetra);
            }
        }
    }

    @Override
    public Map<Character, List<Contato>> getAll() {
        return contatos;
    }
}
