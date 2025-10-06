package AulaPratica8.domain;

import AulaPratica8.persistencia.ContatoDAO;
import AulaPratica8.Infra.Contato;
import java.util.List;
import java.util.Map;

public class ListaTelefonica {

    private final ContatoDAO contatoDAO;

    public ListaTelefonica(ContatoDAO contatoDAO) {
        this.contatoDAO = contatoDAO;
    }

    public void adicionarContato(Contato contato) {
        contatoDAO.insert(contato);
    }

    public void removerContato(Contato contato) {
        contatoDAO.delete(contato);
    }

    public Map<Character, List<Contato>> listarContatos() {
        return contatoDAO.getAll();
    }
}
