package ses_5;

//class Hello extends Thread{
//	public void run() {
//		for(int i = 0; i< 5; i++) 
//			System.out.println("Hello in Thread");
//	}
//}
//
//public class Multithread {
//	public static void main(String[] args) {
//		Hello obj = new Hello();
//		obj.start();
//		for(int i = 0; i< 5; i++)
//				System.out.println("Hello in Main");
//	}
//}

class Hello implements Runnable{
	public void run() {
		for(int i = 0; i< 100; i++) 
			System.out.println("Hello in Thread");
	}
}

public class Multithread {
	public static void main(String[] args) {
		Hello obj = new Hello();
		Thread t = new Thread(obj);
		t.start();
		for(int i = 0; i< 100; i++)
				System.out.println("Hello in Main");
	}
}

