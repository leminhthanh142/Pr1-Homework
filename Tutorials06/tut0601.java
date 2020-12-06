package Tutorials06;
import java.util.Scanner;
public class tut0601 {
    public static void main(String[] args) {

        Scanner input = new Scanner (System.in);
        int option = 0;
        do {
            System.out.println("Choose one feature listed below");
            System.out.print("1. BMI calculator \n" +
                    "2. Coin convert \n"+
                    "3. Leap year \n" +
                    "4. Quadratic equation \n" +
                    "5. Password strength \n" +
                    "6. GCD finder \n" +
                    "7. Quit \n");
            System.out.print("Option: ");
            option = input.nextInt();
            switch (option) {
                case 1 -> BMI(input);
                case 2 -> CoinConvert(input);
                case 3 -> LeapYear(input);
                case 4 -> QuadraticEquation(input);
                case 5 -> PasswordStrength(input);
                case 6 -> GCD(input);
                case 7 -> System.out.println("Goodbye!!");
                default -> System.out.println("Invalid option");
            }
        }
        while( option != 7);
    }
    public static void BMI(Scanner input) {
        System.out.print("Enter your height: ");
        double h = input.nextDouble();
        System.out.print("Enter your weight: ");
        double w = input.nextDouble();
        System.out.println("Your BMI: " +  w/(h*h));
    }

    public static void CoinConvert(Scanner input) {

    }

    public static void LeapYear(Scanner input) {
        System.out.print("Enter year to check: ");
        int y = input.nextInt();

        if (y % 4 == 0 && y % 100 != 0 || y % 400 == 0 ) {
            System.out.println(y + " is a leap year");
        }
        else
            System.out.println(y + " is not a leap year");
    }

    public static void QuadraticEquation(Scanner input) {

    }

    public static void PasswordStrength(Scanner input) {

        System.out.print("Enter your password: ");
        String password = input.nextLine();

        boolean upperCase = false,
                lowerCase = false,
                digits = false,
                symbols = false;

        int score = 0;

        if (password.length() > 12 ) score += 2;

        else if (password.length() >= 8) score ++;

        for (int i=0; i<password.length(); i++) {
            if (password.charAt(i) >= 'A' && password.charAt(i) <= 'Z') upperCase = true;

            else if (password.charAt(i) >= 'a' && password.charAt(i) <= 'z') lowerCase = true;

            else if (password.charAt(i) >= '0' && password.charAt(i) <= '0') digits = true;

            else symbols = true;
        }

        if (upperCase) score ++;
        if (lowerCase) score ++;
        if (digits) score ++;
        if (symbols) score ++;

        if (score >= 5) {
            System.out.println("Password strength: " + score + " (Strong)");
        }
        else if (score >= 3) {
            System.out.println("Password strength: " + score + " (Medium)");
        }
        else    System.out.println("Password strength: " + score + " (Weak)");
    }

    public static void GCD(Scanner input) {
        System.out.print("Enter a: ");
        int a = input.nextInt();
        System.out.print("Enter b: ");
        int b = input.nextInt();
        int result = 0;

        for (int i=1; i<=a && i<=b; i++) {
            if( a%i==0 && b%i==0) {
                result = i;
            }
        }
        System.out.println("GCD(" + a + ", " + b + ") = " + result);
    }

}
