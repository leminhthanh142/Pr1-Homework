package Tutorials07;

import java.util.Scanner;

public class tut0701 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("Enter a (a>0): ");
        int a = input.nextInt();
        System.out.print("Enter b (b>0): ");
        int b = input.nextInt();
        int result = 0;

        // loop through the smaller number
        for (int i=1; i<=a && i<=b; i++) {
            // find the largest number that both a and b % that number equals 0
            if (a % i==0 && b % i==0) {
                result = i;
            }
        }
        System.out.println("gcd"+"(" + a + "," + b + ")" + ": " + result);
        input.close();
    }
}
