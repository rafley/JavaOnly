import java.util.Scanner;

public class windchillindex {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.print("Enter the temperature in Celsius: ");
        double tempC = input.nextDouble();

        System.out.print("Enter the wind speed in kilometers per hour: ");
        double windSpeed = input.nextDouble();

        double windChillIndex = 13.12 + 0.6215 * tempC - 11.37 * Math.pow(windSpeed, 0.16) + 0.3965 * tempC * Math.pow(windSpeed, 0.16);

        if (tempC <= 10 && windSpeed >= 4.8) {
            System.out.printf("The wind chill index is %.2f", windChillIndex);
        } else if (tempC > 10 || windSpeed < 4.8) {
            System.out.println("The temperature or wind speed is not within the acceptable range for calculating wind chill index.");
        } else {
            System.out.println("Invalid input. Please enter a valid temperature and wind speed.");
        }
    }
}
