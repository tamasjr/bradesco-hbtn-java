public class Post implements Comparable<Post> {
    private String titulo;
    private String corpo;
    private Autor autor;
    private Categorias categoria;

    public Post(Autor autor, String titulo, String corpo, Categorias categoria) {
        this.titulo = titulo;
        this.autor = autor;
        this.categoria = categoria;
        this.corpo = corpo;
    }

    public String getTitulo() {
        return titulo;
    }

    public Autor getAutor() {
        return autor;
    }

    public Categorias getCategoria() {
        return categoria;
    }

    public String getCorpo() {
        return corpo;
    }

    @Override
    public String toString() {
        return titulo;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Post)) return false;
        Post post = (Post) o;
        return titulo.equals(post.titulo) && autor.equals(post.autor);
    }

    @Override
    public int hashCode() {
        return titulo.hashCode() * 31 + autor.hashCode();
    }

    @Override
    public int compareTo(Post other) {
        return this.titulo.compareTo(other.titulo);
    }
}
