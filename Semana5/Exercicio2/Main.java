

import java.util.Date;

public class Main {
    public static void main(String[] args) {
        Autor autor1 = new Autor("Machado de Assis", "Brasileiro", 1839);
        Autor autor2 = new Autor(); 
        autor2.setNome("George Orwell");
        autor2.setNacionalidade("Britânico");
        autor2.setAnoNascimento(1903);

        Livro livro1 = new Livro("Dom Casmurro", "123456", autor1);
        Livro livro2 = new Livro();
        livro2.setTitulo("1984");
        livro2.setIsbn("654321");
        livro2.setAutor(autor2);

        Usuario usuario1 = new Usuario("Ana Silva", "U001", "ana@email.com");
        Usuario usuario2 = new Usuario();
        usuario2.setNome("João Souza");
        usuario2.setMatricula("U002");
        usuario2.setEmail("joao@email.com");

        Emprestimo emprestimo1 = new Emprestimo(usuario1, livro1, new Date());
        Emprestimo emprestimo2 = new Emprestimo();
        emprestimo2.setUsuario(usuario2);
        emprestimo2.setLivro(livro2);
        emprestimo2.setDataDevolucao(new Date());

        Biblioteca biblioteca1 = new Biblioteca("Biblioteca Central");
        biblioteca1.addLivro(livro1);
        biblioteca1.addUsuario(usuario1);

        Biblioteca biblioteca2 = new Biblioteca();
        biblioteca2.setNome("Biblioteca Comunitária");
        biblioteca2.addLivro(livro2);
        biblioteca2.addUsuario(usuario2);

        System.out.println("Autores:");
        System.out.println(" - " + autor1.getNome() + " (" + autor1.getNacionalidade() + ")");
        System.out.println(" - " + autor2.getNome() + " (" + autor2.getNacionalidade() + ")\n");

        System.out.println("Livros:");
        System.out.println(" - " + livro1.getTitulo() + " | ISBN: " + livro1.getIsbn() 
                           + " | Autor: " + livro1.getAutor().getNome());
        System.out.println(" - " + livro2.getTitulo() + " | ISBN: " + livro2.getIsbn() 
                           + " | Autor: " + livro2.getAutor().getNome() + "\n");

        System.out.println("Usuários:");
        System.out.println(" - " + usuario1.getNome() + " | Matrícula: " + usuario1.getMatricula());
        System.out.println(" - " + usuario2.getNome() + " | Matrícula: " + usuario2.getMatricula() + "\n");

        System.out.println("Empréstimos:");
        System.out.println(" - " + emprestimo1.getUsuario().getNome() 
                           + " pegou \"" + emprestimo1.getLivro().getTitulo() + "\"");
        System.out.println(" - " + emprestimo2.getUsuario().getNome() 
                           + " pegou \"" + emprestimo2.getLivro().getTitulo() + "\"\n");

        System.out.println("Bibliotecas:");
        System.out.println(" - " + biblioteca1.getNome() 
                           + " | Livros: " + biblioteca1.getLivros().size() 
                           + " | Usuários: " + biblioteca1.getUsuarios().size());
        System.out.println(" - " + biblioteca2.getNome() 
                           + " | Livros: " + biblioteca2.getLivros().size() 
                           + " | Usuários: " + biblioteca2.getUsuarios().size());
    }
}
