public class Post {
    private String autor;
    private String titulo;
    private String corpo;
    private String categoria;

    public Post(String autor, String titulo, String corpo, String categoria) {
        if (autor == null || autor.trim().isEmpty()) {
            throw new IllegalArgumentException("Autor invalido");
        }
        if (titulo == null || titulo.trim().isEmpty()) {
            throw new IllegalArgumentException("Titulo invalido");
        }
        if (corpo == null || corpo.trim().isEmpty()) {
            throw new IllegalArgumentException("Corpo invalido");
        }
        if (categoria == null || categoria.trim().isEmpty()) {
            throw new IllegalArgumentException("Categoria invalida");
        }
        this.autor = autor;
        this.titulo = titulo;
        this.corpo = corpo;
        this.categoria = categoria;
    }

    public String getAutor() {
        return autor;
    }

    public String getTitulo() {
        return titulo;
    }

    public String getCorpo() {
        return corpo;
    }

    public String getCategoria() {
        return categoria;
    }
}