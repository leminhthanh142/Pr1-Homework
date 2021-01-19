package DSA_Homework;

import java.util.Random;
import java.util.Scanner;

public class exampleCode {
//    static Scanner input = new Scanner(System.in);
//    public static void main(String[] args) {
//        System.out.print("Enter number a: ");
//        double a = input.nextDouble();
//        System.out.print("Enter number b: ");
//        double b = input.nextDouble();
//        System.out.println("Result: " + floatNumberChecker(a, b));
//    }
//
//    public static String floatNumberChecker (double a, double b) {
//        a = Math.round(a * 1000);
//        a = a / 1000;
//
//        b = Math.round(b * 1000);
//        b = b / 1000;
//
//        return (a == b)? "Two numbers are the same up to three decimal" : "Two number are different";
//    }

    public static void main(String[]args)
    {
        int n;
        int [] a;
        a=new int[1000];

        System.out.println("Please input the integer N:");
        Scanner scanner = new Scanner(System.in);
        n=scanner.nextInt();

        Random rand = new Random();
        for (int i=0; i<n; i++)
        {
            a[i]=rand.nextInt(10);
        }

        System.out.println("The list of " + n + " integers is:");
        for (int i=0; i<n; i++)
        {
            System.out.print(a[i]+" ");
        }
        System.out.println(" ");
        scanner.close();
    }
}
