package ses_5;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
 
public class EmailSenderWithExecutor {
    private static void sendEmail() {
        System.out.println("1. Sending email by " + Thread.currentThread().getName());      
        try {
            Thread.sleep(3000); // Simulate 3 seconds delay
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("2. Email sent by " + Thread.currentThread().getName());
    }
	public static void main(String[] args) {
        System.out.println("Email sending started (WITH Executor)...");
        // Create executor with 2 threads (like 2 email agents)
        ExecutorService executor = Executors.newFixedThreadPool(2);       
        for (int i = 1; i <= 5; i++) {
            executor.submit(() -> {
                sendEmail();
            });
        } 
        executor.shutdown(); // Always shut down when done
        System.out.println("All email tasks submitted (WITH Executor).");
    }
}

