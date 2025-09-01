import java.util.*;

public class ManipularArrayNumeros {

    static Integer buscarPosicaoNumero(List<Integer> numeros, int numero) {
        for (int i = 0; i < numeros.size(); i++) {
            if (numeros.get(i) == numero) {
                return i;
            }
        }
        return -1;
    }

    static void adicionarNumero(List<Integer> numeros, int numero) {
        if (buscarPosicaoNumero(numeros, numero) == -1) {
            numeros.add(numero);
        } else {
            throw new RuntimeException("Numero jah contido na lista");
        }
    }

    static void removerNumero(List<Integer> numeros, int numero) {
        int posicao = buscarPosicaoNumero(numeros, numero);
        if (posicao != -1) {
            numeros.remove(posicao);
        } else {
            throw new RuntimeException("Numero nao encontrado na lista");
        }
    }

    static void substituirNumero(List<Integer> numeros, int numeroAntigo, int numeroNovo) {
        int posicao = buscarPosicaoNumero(numeros, numeroAntigo);
        if (posicao != -1) {
            numeros.set(posicao, numeroNovo);
        } else {
            numeros.add(numeroNovo);
        }
    }

}