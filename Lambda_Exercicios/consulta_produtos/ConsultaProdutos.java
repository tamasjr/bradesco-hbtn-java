import java.util.ArrayList;
import java.util.List;

public class ConsultaProdutos {
    public static List<Produto> filtrar(List<Produto> produtos, CriterioFiltro criterio) {
        List<Produto> resultado = new ArrayList<>();
        for (Produto produto : produtos) {
            if (criterio.testar(produto)) {
                resultado.add(produto);
            }
        }
        return resultado;
    }
}
