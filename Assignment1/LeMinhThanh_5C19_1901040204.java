/*
    Full name: Le Minh Thanh
    Class: 5C19
    ID: 1901040204
*/
package Assignment1;

import java.util.Scanner;

public class LeMinhThanh_5C19_1901040204 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int n;
        char answer;

        do {
            // create repeated menu
            do {
                try {
                    System.out.println("Please choose one feature listed below: \n" +
                            "1. Convert a decimal integer to binary \n" +
                            "2. Compute a consecutive square root \n" +
                            "3. Solve a quadratic equation \n" +
                            "4. Print a triangle given its size \n");
                    System.out.print("Option: ");
                    n = input.nextInt();
                }
                // catch the error if user enter a letter or something that different form an integer
                catch (Exception e) {
                    System.out.println();
                    System.out.println("------ You must enter a number from 1-4 ------");
                    input.nextLine();
                    System.out.print("------ Option: ");
                    n = input.nextInt();
                }
                // divide menu into 4 parts and execute it whenever it was called
                switch (n) {
                    case 1 -> DecimalToBinary(input);
                    case 2 -> ConsecutiveSquareRoot(input);
                    case 3 -> QuadraticEquation(input);
                    case 4 -> Triangle(input);
                    default -> {
                        System.out.println();
                        System.out.println("------ Invalid option. Try again!! ------");
                        System.out.println();
                    }
                }
            }
            while (n < 1 || n > 4);

            // ask user whether they want to continue or not ?
            System.out.println("Do you want to continue?");
            System.out.println(" Y/ N ");
            System.out.print("Answer: ");
            answer = input.next().charAt(0);
        }
        while (answer == 'Y' || answer == 'y');
        System.out.println();
        System.out.println("------ Goodbye!! ------");
    }

    // Convert a Decimal number to binary
    public static void DecimalToBinary(Scanner input) {

        // create a string to store the value after each manipulation inside the while loop
        String binaryString = "";
        int num;
        System.out.print("Enter a decimal number: ");
        num = input.nextInt();

        // (for negative number) get its value corresponding to the unsigned 8 bit representation.
        while (num < 0) {
            num += Math.pow(2, 8);
        }

        if (num == 0) {
            System.out.println();
            System.out.println("--- Binary value is: 0");
            System.out.println();
        } else {
            //transfer to binary code with GF(2) mathematics
            while (num != 0) {
                binaryString += num % 2;
                num = num / 2;
                System.out.println(binaryString);
            }
            System.out.println();
            System.out.print("--- Binary value is: ");

            // last time in while loop produce an extra i --> take from (i-1)
            // reverse the string to get final result
            for (int i = binaryString.length() - 1; i >= 0; i--) {
                System.out.print(binaryString.charAt(i));
            }
            System.out.println();
            System.out.println();
        }
    }

    // Solve a consecutive square root
    public static void ConsecutiveSquareRoot(Scanner input) {
        double m;

        // ask user to enter a positive number
        do {
            System.out.print("Enter a positive m: ");
            m = input.nextInt();
        }
        while (m < 0);

        System.out.print("Enter n (from 1 to 5): ");
        int n = input.nextInt();

        // ask user to enter 'n' again and again until it satisfied the condition
        while (1 > n || n > 5) {
            System.out.println("The number is not in range. Try again with n from 1 to 5");
            System.out.print("Enter n: ");
            n = input.nextInt();
        }

        double result = 0;
        for (int i = 0; i < n; i++) {
            result = Math.sqrt(m + result);
        }

        System.out.println();
        System.out.println("--- Result: " + result);
        System.out.println();
    }

    // Solve quadratic equation
    public static void QuadraticEquation(Scanner input) {
        System.out.print("Enter a: ");
        double a = input.nextDouble();
        System.out.print("Enter b: ");
        double b = input.nextDouble();
        System.out.print("Enter c: ");
        double c = input.nextDouble();

        double x1, x2;
        double delta = (b * b - 4 * a * c);

        if (a == 0) {
            System.out.println();
            if (b == 0) {
                if (c == 0) {
                    System.out.println("--- There is nothing to be solved !!");
                } else {
                    System.out.println("--- The equation has no root !!");
                }
            } else {
                System.out.println("--- The equation has one root: " + (-c / b));
            }
        } else if (delta < 0) {
            System.out.println();
            System.out.println("--- The equation has no root !!");
        } else if (delta == 0) {
            x1 = -b / 2 * a;
            System.out.println();
            System.out.println("--- The equation has one root: " + x1);
        } else {
            x1 = ((-b + Math.sqrt(delta)) / (2 * a));
            x2 = ((-b - Math.sqrt(delta)) / (2 * a));
            System.out.println();
            System.out.println("--- The equation has 2 roots");
            System.out.println("    x1: " + x1);
            System.out.println("    x2: " + x2);
        }
        System.out.println();
    }

    // Print triangle with given size
    public static void Triangle(Scanner input) {
        System.out.print("Enter the height of triangular: ");
        int h = input.nextInt();

        // ask user to enter 'h' again and again until it satisfied the condition
        while (1 > h || h >= 6) {
            System.out.println("---- Try again with 1<= h <=5");
            System.out.print("---- Enter the height of triangular: ");
            h = input.nextInt();
        }

        for (int i = 0; i <= h; i++) {
            /* print the white spaces
              Start with i=0 to print an empty line.
              With the first row, the number of white spaces
              will equals to the height of triangular ( 'h' white spaces)
              and the number of white spaces will reduce when the row of
              triangular increases ( (h - i) white spaces; i=1,2,3,...)
              */
            for (int j = h; j >= i; j--) {
                System.out.print("  ");
            }
            // print odd number of asterisks
            for (int k = 0; k < (2 * i - 1); k++) {
                System.out.print("* ");
            }
            // print newline to form the triangular
            System.out.println();
        }
        System.out.println();
    }
}