package ses_5;

public class EmailSenderWithoutExecutor {
	  private static void sendEmail() {
	        System.out.println("1 .Sending email by " + Thread.currentThread().getName());
	        try {
	            Thread.sleep(2000); // Simulate 2 seconds delay
	        } catch (InterruptedException e) {
	            e.printStackTrace();
	        }
	        System.out.println("2 .Email sent by " + Thread.currentThread().getName());
	    }
	public static void main(String[] args) {
      System.out.println("Email sending started (WITHOUT Executor)...");

      for (int i = 1; i <= 5; i++) {
          Thread thread = new Thread(() -> {
              sendEmail();
          });
          thread.start();
      }

      System.out.println("All email tasks submitted (WITHOUT Executor).");
  }


}
