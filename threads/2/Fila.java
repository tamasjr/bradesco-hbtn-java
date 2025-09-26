import java.util.LinkedList;

public class Fila {
    private final LinkedList<Integer> fila = new LinkedList<>();
    private final int capacidade;

    public Fila(int capacidade) {
        this.capacidade = capacidade;
    }

    public synchronized void adicionar(int item) throws InterruptedException {
        while (fila.size() == capacidade) {
            wait();
        }
        fila.add(item);
        notifyAll();
    }

    public synchronized int retirar() throws InterruptedException {
        while (fila.isEmpty()) {
            wait();
        }
        int item = fila.removeFirst();
        notifyAll();
        return item;
    }
}
