import java.util.List;

public class Main {
    public static void main(String[] args) {
        LivroDAO livroDAO = new LivroDAOImpl();

        // Inserir livros
        Livro livro1 = new Livro("Livro 1", 1, "Autor 1");
        Livro livro2 = new Livro("Livro 2", 2, "Autor 2");

        livroDAO.inserirLivro(livro1);
        livroDAO.inserirLivro(livro2);

        // Listar livros
        List<Livro> listaLivros = livroDAO.listarLivros();
        System.out.println("Lista de Livros:");
        for (Livro livro : listaLivros) {
            System.out.println("ID: " + livro.getId() + ", Nome: " + livro.getNome() + ", Autor: " + livro.getAutor());
        }

        // Buscar livro por ID
        Livro livroEncontrado = livroDAO.buscarLivroPorId(1);
        if (livroEncontrado != null) {
            System.out.println("Livro encontrado: " + livroEncontrado.getNome());
        } else {
            System.out.println("Livro não encontrado.");
        }

        // Atualizar livro
        Livro livroAtualizado = new Livro("Livro Atualizado", 1, "Novo Autor");
        livroDAO.atualizarLivro(livroAtualizado);

        // Deletar livro
        livroDAO.deletarLivro(2);

        // Listar livros novamente
        listaLivros = livroDAO.listarLivros();
        System.out.println("Lista de Livros após atualização e exclusão:");
        for (Livro livro : listaLivros) {
            System.out.println("ID: " + livro.getId() + ", Nome: " + livro.getNome() + ", Autor: " + livro.getAutor());
        }
    }
}
