package ses_4;

@SuppressWarnings("serial")
class InvalidNameException extends RuntimeException {
    public InvalidNameException(String message) {
        super(message);
    }
}

public class OnlineRegistration {
	public void registrationUser(String name) throws InvalidNameException {
		if(name == null || name.trim().isEmpty()) {
			throw new InvalidNameException("Name can't be empty");
		}
		System.out.println("Registration Successful !");
	}
	
	public static void main(String[] args) {
		OnlineRegistration reg = new OnlineRegistration();
//		try {
//			reg.registrationUser("Akhil");
//		} catch (InvalidNameException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
		
		reg.registrationUser("Akhil");
	}
}
