import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

public class ConsultaProdutos {
    public static List<Produto> filtrar(List<Produto> produtos, Predicate<Produto> criterio) {
        List<Produto> resultado = new ArrayList<>();
        for (Produto produto : produtos) {
            if (criterio.test(produto)) {
                resultado.add(produto);
            }
        }
        return resultado;
    }
}
