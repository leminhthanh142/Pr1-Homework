package Tutorials09;

import java.util.Scanner;

public class tut09 {
    static Scanner input = new Scanner(System.in);
    public static void main(String[] args) {
        int option;
        do {
            try {
                System.out.println("Choose one feature listed below");
                System.out.print("1. BMI calculator \n" +
                        "2. Coin convert \n" +
                        "3. Leap year \n" +
                        "4. Quadratic equation \n" +
                        "5. Password strength \n" +
                        "6. GCD finder \n" +
                        "7. Quit \n");
                System.out.print("Option: ");
                option = input.nextInt();
            }
            catch (Exception e) {
                System.out.println("You must enter a number from 1-7");
                input.nextLine();
                System.out.print("Option: ");
                option = input.nextInt();
            }
            switch (option) {
                case 1 -> System.out.println("Your BMI value is: " + BMI());
                case 2 -> System.out.println(CoinConvert());
                case 3 -> System.out.println(LeapYear());
                case 4 -> System.out.println(QuadraticEquation());
                case 5 -> System.out.println(PasswordStrength());
                case 6 -> System.out.println("Result: " + GCD());
                case 7 -> System.out.println("Goodbye!!");
                default -> System.out.println("Invalid option");
            }
        }
        while (option != 7);
    }

    public static double BMI() {
        System.out.print("Enter your height: ");
        double h = input.nextDouble();
        System.out.print("Enter your weight: ");
        double w = input.nextDouble();
        return w/(h*h);
    }

    public static String CoinConvert() {
        System.out.print("Enter the amount of xu: ");
        int xu = input.nextInt();
        int quan = xu / 10000;
        int dong = xu % 10000 / 100;
        int hao = xu % 100 /10;
        xu = xu % 10;
        return quan + " 'quan'   " + dong +  " 'dong'   " + hao + " 'hao'   " + xu + " 'xu'   ";
    }

    public static String LeapYear() {
        System.out.print("Enter year to check: ");
        int y = input.nextInt();

        if (y % 4 == 0 && y % 100 != 0 || y % 400 == 0) {
            return (y + " is a leap year");
        } else
            return (y + " is not a leap year");
    }

    public static String QuadraticEquation()  {
        System.out.print("Enter a: ");
        double a = input.nextDouble();
        System.out.print("Enter b: ");
        double b = input.nextDouble();
        System.out.print("Enter c: ");
        double c = input.nextDouble();

        if (a == 0 && b==0 && c==0) {
            return ("There's nothing to be solved.");
        }
        else if (a==0 && b==0 && c!=0) {
            return ("The equation has no root.");
        }
        else if (a==0 && b!=0 && c!=0) {
            double x = -c / b;
            return ("There is one root: x = " + x);
        }
        else {
            double delta = b * b - 4 * a * c;
            if (delta < 0) {
                return ("The equation has no real root.");
            } else if (delta == 0) {
                double x = -b / (2 * a);
                return ("The root is x = " + x);
            } else {
                double x1 = (-b + Math.sqrt(delta)) / (2 * a);
                double x2 = (-b - Math.sqrt(delta)) / (2 * a);
                return ("There are 2 roots: x1 = " + x1 + ", x2 = " + x2);
            }
        }
    }

    public static String PasswordStrength() {
        System.out.print("Enter your password: ");
        String password = input.next();
        boolean upperCase = false,
                lowerCase = false,
                digits = false,
                symbols = false;

        int score = 0;

        if (password.length() > 12) score += 2;

        else if (password.length() >= 8) score++;

        for (int i = 0; i < password.length(); i++) {
            if (password.charAt(i) >= 'A' && password.charAt(i) <= 'Z') upperCase = true;

            else if (password.charAt(i) >= 'a' && password.charAt(i) <= 'z') lowerCase = true;

            else if (password.charAt(i) >= '0' && password.charAt(i) <= '9') digits = true;

            else symbols = true;
        }

        if (upperCase) score++;
        if (lowerCase) score++;
        if (digits) score++;
        if (symbols) score++;

        if (score >= 5) {
            return ("Password strength: " + score + " (Strong)");
        } else if (score >= 3) {
            return ("Password strength: " + score + " (Medium)");
        } else return ("Password strength: " + score + " (Weak)");
    }

    public static int GCD() {
        System.out.print("Enter a: ");
        int a = input.nextInt();
        System.out.print("Enter b: ");
        int b = input.nextInt();
        int result = 0;

        for (int i = 1; i <= a && i <= b; i++) {
            if (a % i == 0 && b % i == 0) {
                result = i;
            }
        }
        return result;
    }
}
