public class AtendimentoThread extends Thread {
    int idCliente;

    public void run() {
        System.out.println(
                getName() +
                        " atendendo cliente " +
                        idCliente);
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }

    public static void main(String[] args) throws InterruptedException {
        var t = new AtendimentoThread();
        t.start();
        t.join();
    }
}
