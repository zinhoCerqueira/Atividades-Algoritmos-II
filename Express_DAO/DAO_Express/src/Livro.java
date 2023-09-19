public class Livro {
    public String nome;
    public long id;
    public String autor;

    public Livro(String nome, long id, String autor) {
        this.nome = nome;
        this.id = id;
        this.autor = autor;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }
}
