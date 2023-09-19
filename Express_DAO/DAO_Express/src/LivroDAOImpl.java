import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LivroDAOImpl implements LivroDAO {
    private Map<Long, Livro> livros;

    public LivroDAOImpl() {
        livros = new HashMap<>();
    }

    @Override
    public void inserirLivro(Livro livro) {
        livros.put(livro.getId(), livro);
    }

    @Override
    public Livro buscarLivroPorId(long id) {
        return livros.get(id);
    }

    @Override
    public List<Livro> listarLivros() {
        return new ArrayList<>(livros.values());
    }

    @Override
    public void atualizarLivro(Livro livro) {
        livros.put(livro.getId(), livro);
    }

    @Override
    public void deletarLivro(long id) {
        livros.remove(id);
    }
}
