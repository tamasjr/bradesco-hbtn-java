public class Consumidor extends Thread {
    private final Fila fila;

    public Consumidor(Fila fila) {
        this.fila = fila;
    }

    @Override
    public void run() {
        try {
            while (true) {
                int numero = fila.retirar();
                System.out.println("Consumidor consumiu: " + numero);
                Thread.sleep(500);
            }
        } catch (InterruptedException e) {
            // Thread finalizada
        }
    }
}
