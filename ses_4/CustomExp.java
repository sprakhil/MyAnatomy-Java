package ses_4;

@SuppressWarnings("serial")
class InvalidAgeException extends Exception {
    public InvalidAgeException(String message) {
        super(message);
    }
}

public class CustomExp {
    public static void validateAge(int age) throws InvalidAgeException {
        if (age < 18) {
            throw new InvalidAgeException("Age below 18 is not allowed to vote");
        }
        System.out.println("Eligible to vote");
    }

    public static void main(String[] args) {
        try {
            validateAge(44);
        } catch (InvalidAgeException e) {
            e.printStackTrace();
        }
    }
}
