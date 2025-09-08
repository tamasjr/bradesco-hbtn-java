import java.util.*;

public class Blog {
    private List<Post> postagens;

    public Blog() {
        this.postagens = new ArrayList<>();
    }

    public void adicionarPostagem(Post postagem) throws Exception {
        for (Post p : postagens) {
            if (p.getAutor().equals(postagem.getAutor()) && p.getTitulo().equals(postagem.getTitulo())) {
                throw new Exception("Postagem jah existente");
            }
        }
        this.postagens.add(postagem);
    }

    public Set<Autor> obterTodosAutores() {
        Set<Autor> autores = new TreeSet<>();
        for (Post postagem : postagens) {
            autores.add(postagem.getAutor());
        }
        return autores;
    }

    public Map<Categorias, Integer> obterContagemPorCategoria() {
        Map<Categorias, Integer> contagem = new TreeMap<>();
        for (Post postagem : postagens) {
            Categorias categoria = postagem.getCategoria();
            contagem.put(categoria, contagem.getOrDefault(categoria, 0) + 1);
        }
        return contagem;
    }

    public Set<Post> obterPostsPorAutor(Autor autor) {
        Set<Post> posts = new TreeSet<>();
        for (Post postagem : postagens) {
            if (postagem.getAutor().equals(autor)) {
                posts.add(postagem);
            }
        }
        return posts;
    }

    public Set<Post> obterPostsPorCategoria(Categorias categoria) {
        Set<Post> posts = new TreeSet<>();
        for (Post postagem : postagens) {
            if (postagem.getCategoria() == categoria) {
                posts.add(postagem);
            }
        }
        return posts;
    }

    public Map<Categorias, Set<Post>> obterTodosPostsPorCategorias() {
        Map<Categorias, Set<Post>> map = new TreeMap<>();
        for (Post postagem : postagens) {
            map.computeIfAbsent(postagem.getCategoria(), k -> new TreeSet<>()).add(postagem);
        }
        return map;
    }

    public Map<Autor, Set<Post>> obterTodosPostsPorAutor() {
        Map<Autor, Set<Post>> map = new TreeMap<>();
        for (Post postagem : postagens) {
            map.computeIfAbsent(postagem.getAutor(), k -> new TreeSet<>()).add(postagem);
        }
        return map;
    }
}
