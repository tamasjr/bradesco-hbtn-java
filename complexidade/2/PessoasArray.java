import java.util.Set;
import java.util.LinkedHashSet;
import java.util.HashSet;
import java.util.TreeMap;
import java.util.SortedMap;
import java.util.Map;

public class PessoasArray {

    private String[] nomes;

    public PessoasArray() {

        nomes = new String[]{"Amanda", "Beatriz", "Carlos","Daniela","Eduardo",
                "Fabio","Gustavo", "Hingrid","Isabela","Joao","Leise","Maria",
                "Norberto","Otavio","Paulo", "Quirino","Renata","Sabata",
                "Tais","Umberto","Vanessa","Xavier"};
    }

    public String[] getNomes() {
        return nomes;
    }

    public void setNomes(String[] nomes) {
        this.nomes = nomes;
    }

    public void buscaBinaria(String nome){
        System.out.println("Procurando o nome: \"" + nome + "\"");
        boolean found = false;
        int left = 0;
        int right = nomes.length - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            System.out.println("Passando pelo indice: " + mid);
            int res = nome.compareTo(nomes[mid]);
            if (res == 0) {
                System.out.println("Nome " + nome + " encontrado na posição " + mid);
                return;
            } else if (res > 0) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        if (!found) {
            throw new IllegalArgumentException("O nome " + nome + " não se encontra no array de nomes");
        }
    }
}
