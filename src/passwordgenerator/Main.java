package project;
import java.util.Scanner;
import java.util.Random;
public class SmartPasswordGenerator {
  // Generate Password Method
    public static String generatePassword(String name, String pan, String dob) {
     Random random = new Random();
        String special = "@#$&!";
        char sp = special.charAt(random.nextInt(special.length()));
        int num = random.nextInt(100);
        String password = name.substring(0, 2).toUpperCase() + pan.substring(0, 4) +  dob.substring(0, 2) + sp + num;
                        return password;
    }
    // Password Strength Method
    public static void checkStrength(String password) {
        if (password.length() >= 12) {
            System.out.println("Password Strength: STRONG");
        } else if (password.length() >= 8) {
            System.out.println("Password Strength: MEDIUM");
        } else {
            System.out.println("Password Strength: WEAK");
        }
    }
    // Main Method
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        char choice;
        do {
            // Accept User Details
            System.out.print("Enter Your Name: ");
            String name = sc.nextLine();

            System.out.print("Enter PAN Number: ");
            String pan = sc.nextLine();

            System.out.print("Enter Date of Birth (DDMMYYYY): ");
            String dob = sc.nextLine();

            // Generate Password
            String password = generatePassword(name, pan, dob);
            
            // Display Password
            System.out.println("\nGenerated Password: " + password);

            // Check Strength
            checkStrength(password);

            // Multiple Users
            System.out.print("\nGenerate Again? (y/n): ");
            choice = sc.next().charAt(0);

            sc.nextLine();

        } while (choice == 'y' || choice == 'Y');

        System.out.println("Program Ended.");

        sc.close();
    }
}