package Model;

import java.util.Date;

public class Livro {
    private static int proximoId = 1;
    private String titulo;
    private String autor;
    private String editora;
    private String ISBN;
    private Date ano_publicação;
    private String categoria;
    private int id;

    public Livro(String titulo, String autor, String editora, String ISBN, Date ano_publicação, String categoria) {
        this.titulo = titulo;
        this.autor = autor;
        this.editora = editora;
        this.ISBN = ISBN;
        this.ano_publicação = ano_publicação;
        this.categoria = categoria;
        this.id = proximoId;
        proximoId++;
    }
}
