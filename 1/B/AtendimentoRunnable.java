public class AtendimentoRunnable implements Runnable {
    int idCliente;

    public void run() {
        System.out.println("atendendo cliente " + idCliente);
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }

    public static void main(String[] args) {
        Runnable r = new AtendimentoRunnable();
        new Thread(r, "Atendente-1").start();
    }
}
