package AulaPratica8.persistencia;

import java.util.List;
import java.util.Map;

import AulaPratica8.Infra.Contato;

public interface ContatoDAO {
    void insert(Contato contato);
    void delete(Contato contato);
    Map<Character, List<Contato>> getAll();
}
