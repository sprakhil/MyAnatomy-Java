package ses_5;

public class WithoutAtomic {
    static int counter = 0;
	public static void main(String[] args) throws InterruptedException {
        Thread[] threads = new Thread[5];
        // Each thread will increment the counter 1000 times
        for (int i = 0; i < 5; i++) {
            threads[i] = new Thread(() -> {
                for (int j = 0; j < 1000; j++) {
                    counter++; // Not thread-safe!
                }
            });
            threads[i].start();
        }
        // Wait for all threads to finish
        for (int i = 0; i < 5; i++) {
            threads[i].join();
        }
        System.out.println("Final Counter (without atomic): " + counter);
    }
}
 
 
