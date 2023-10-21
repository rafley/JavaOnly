import java.security.SecureRandom;

public class RandomPasswordGenerator {
    public static void main(String[] args) {
        int passwordLength = 12; // You can adjust the password length as needed
        String generatedPassword = generateRandomPassword(passwordLength);
        System.out.println("Random Password: " + generatedPassword);
    }

    public static String generateRandomPassword(int length) {
        String characters = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789!@#$%^&*()-_=+";
        StringBuilder password = new StringBuilder();

        SecureRandom random = new SecureRandom();
        for (int i = 0; i < length; i++) {
            int randomIndex = random.nextInt(characters.length());
            password.append(characters.charAt(randomIndex));
        }

        return password.toString();
    }
}
