import java.util.List;

public interface LivroDAO {
    void inserirLivro(Livro livro);
    Livro buscarLivroPorId(long id);
    List<Livro> listarLivros();
    void atualizarLivro(Livro livro);
    void deletarLivro(long id);
}
