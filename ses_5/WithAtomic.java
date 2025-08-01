package ses_5;

import java.util.concurrent.atomic.AtomicInteger;

public class WithAtomic {
	static AtomicInteger counter  = new AtomicInteger(0);
	public static void main(String[] args) throws InterruptedException {
		Thread[] arr = new Thread[5];
		
		for(int i = 0; i< 5; i++) {
			arr[i] = new Thread(() -> {
				for(int j = 0; j<1000; j++) {
					counter.incrementAndGet();
				}
			});
			arr[i].start();
		}
		
		for (int i = 0; i < 5; i++) {
            arr[i].join();
        }
		System.out.println("Final Counter (with atomic): " + counter);
	}
}
