package Tutorials10;

import java.util.Scanner;

public class tut10 {
    static Scanner input = new Scanner(System.in);

    public static void main(String[] args) {

        // i create a menu to combine 4 exercises for short
        int n = 0;
        while (n != 5) {
            System.out.println("1. GCD Finder \n" +
                    "2. Fibonacci number \n" +
                    "3. The factorial \n" +
                    "4. Decimal to binary \n" +
                    "5. Quit");
            System.out.print("Option: ");
            n = input.nextInt();
            switch (n) {
                case 1 -> {
                    System.out.print("Enter a: ");
                    int a = input.nextInt();
                    System.out.print("Enter b: ");
                    int b = input.nextInt();
                    System.out.println("GCD("+ a + ", " + b + ") = " + GCDFinder(a, b));
                }
                case 2 -> {
                    System.out.print("Enter n: ");
                    int num = input.nextInt();
                    while (num < 0) {
                        System.out.print("Enter a positive number: ");
                        num = input.nextInt();
                    }
                    System.out.println("Result: " + FibonacciNumber(num));
                }
                case 3 -> {
                    System.out.print("Enter n: ");
                    int factorialNum = input.nextInt();
                    while (factorialNum < 0) {
                        System.out.print("Enter a positive number: ");
                        factorialNum = input.nextInt();
                    }
                    System.out.println("Result: " + TheFactorial(factorialNum));
                }
                case 4 -> {
                    System.out.print("Enter decimal number: ");
                    int decimalNum = input.nextInt();
                    System.out.println("Result: " + DecimalToBinary(decimalNum));
                }
                case 5 -> System.out.println("Goodbye !!");
                default -> System.out.println("Invalid option");
            }
        }
    }

    public static int GCDFinder (int a, int b) {
        // short form of if else
        return (b == 0)? a : GCDFinder(b, a % b);
    }

    public static int FibonacciNumber (int num) {
        return (num == 0 || num == 1)? num : FibonacciNumber(num - 1) + FibonacciNumber(num - 2);
    }

    public static int TheFactorial(int factorialNum) {
        return (factorialNum == 0)? 1 : factorialNum * TheFactorial(factorialNum - 1);
    }

    public static String DecimalToBinary(int decimalNum) {
        String result = "";
        while (decimalNum < 0) {
            decimalNum += Math.pow(2, 8);
        }
        return (decimalNum == 0 || decimalNum == 1)? (result + decimalNum) : (result + DecimalToBinary(decimalNum / 2) + DecimalToBinary(decimalNum % 2));
    }
}
