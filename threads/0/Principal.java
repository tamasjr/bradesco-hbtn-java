import java.util.*;

public class Principal {

    public static void main(String[] args) {
        Contador contador = new Contador();
        List<Thread> threads = new ArrayList<>();
        // Cria e inicia 10 threads
        for (int i = 0; i < 2; i++) {
            Thread thread = new ThreadContador(contador);
            threads.add(thread);
            thread.start();
        }
        // Aguarda todas as threads terminarem
        for (Thread thread : threads) {
            try {
                thread.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        System.out.println("Valor final do contador: " + contador.getContagem());
    }
}

