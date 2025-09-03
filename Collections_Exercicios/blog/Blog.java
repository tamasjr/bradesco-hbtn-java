import java.util.*;

public class Blog {
    ArrayList<Post> postagens;

    public Blog() {
        this.postagens = new ArrayList<>();
    }

    public void adicionarPostagem(Post postagem) {
        if (postagem == null) {
            throw new IllegalArgumentException("Postagem invalida");
        }
        this.postagens.add(postagem);
    }

    public Set<String> obterTodosAutores() {
        Set<String> autores = new TreeSet<>();
        for (Post postagem : postagens) {
            autores.add(postagem.getAutor());
        }
        return autores;
    }

    public Map<String, Integer> obterContagemPorCategoria() {
        Map<String, Integer> contagem = new TreeMap<>();
        for (Post postagem : postagens) {
            String categoria = postagem.getCategoria();
            contagem.put(categoria, contagem.getOrDefault(categoria, 0) + 1);
        }
        return contagem;
    }
}