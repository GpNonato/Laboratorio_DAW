public class MuitasThreads {
    public static void main(String[] args) throws InterruptedException {
        int total = 10_000;
        Thread[] threads = new Thread[total];

        for (int i = 0; i < total; i++) {
            threads[i] = new Thread(() -> {
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                }
            });
            threads[i].start();
        }

        for (var t : threads) {
            t.join();
        }
    }
}
