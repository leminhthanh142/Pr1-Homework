package Tutorials08;

import java.util.Scanner;

public class tut08 {
    public static void main(String[] args) {
        int userInput = 0;

        Scanner sc = new Scanner(System.in);
        do {
            do {
                try {
                    // Create a menu for user's selection
                    System.out.println("[1]:Convert a decimal (base 10) integer to binary (base 2)");
                    System.out.println("[2]:Compute a consecutive square root");
                    System.out.println("[3]:Solve a quadratic equation");
                    System.out.println("[4]:Print a triangle given its size");
                    System.out.println("[5]:Exit");
                    System.out.println("Please enter a number from 1-5");
                    userInput = sc.nextInt();
                }
                catch (Exception e) {
                    System.out.println("You must enter a number from 1-5");
                    sc.nextLine();
                }

                // Create a do-while loop to ensure the program executed chronically
                switch (userInput) {
                    case 1:
                        int[] binary = new int[100];
                        int result, i = 1, backup, j;

                        System.out.print("Enter a number:");
                        int decimal = sc.nextInt();
                        backup = decimal;
                        while (backup != 0) {

                            result = backup / 2;
                            binary[i++] = backup % 2;
                            backup = result; /* add an additional variable to carry out swapping method*/
                        }

                        System.out.print("Binary number is: ");

                        /*a loop for printing the binary in converse order*/
                        for (j = i - 1; j > 0; j--) {
                            System.out.print(binary[j]);
                        }
                        System.out.print("\n");
                        break;

                    case 2:
                        System.out.print("Please enter a number (m):");
                        double squareRoot = 0, m = sc.nextInt();
                        System.out.print("Enter an integer n (n from 1-5:");
                        int n = sc.nextInt(), u = 0;
                        double variable = m; //add a variable to store m, then use this variable to apply into formular.
                        while ((n < 1) || (n > 5)) {
                            System.out.print("Please enter n in range of 1-5");
                            n = sc.nextInt();
                        }
                        while (u < n) {
                            squareRoot = Math.sqrt(m);
                            m = squareRoot + variable;// squareRoot=0 -> m=0+squrt5 for the first time.Then the loop's 2nd time: squrt of qurt 5 and it will run continuously with this principal.
                            u++;//u runs until u=n
                        }
                        System.out.println("The result is: " + squareRoot);
                        break;
                    case 3:
                        System.out.println("Find solutions of: ax^2+bx+c=0");
                        System.out.print("Enter a: ");
                        double a = sc.nextDouble();
                        System.out.print("Enter b: ");
                        double b = sc.nextDouble();
                        System.out.print("Enter c: ");
                        double c = sc.nextDouble();
                        double x, x1, x2;
                        double delta = b * b - 4 * a * c;
                        if (a == 0) {
                            if (b == 0) {
                                if (c == 0) {
                                    System.out.println("Infinitely many solutions");//since 0=0
                                } else {
                                    System.out.println("No roots"); //c is different from 0
                                }
                            } else {
                                x = -c / b; //a=0 -> equation: bx+c=0
                                System.out.println("The final solution: x= " + x);
                            }

                        } else {
                            if (delta < 0) {
                                System.out.println("No roots");
                            } else if (delta == 0) {

                                x1 = x2 = -b / (2 * a);
                                System.out.println("The final solutions: x1=x2= " + x1);
                            } else { //delta>0
                                x1 = (-b + Math.sqrt(delta)) / (2 * a);
                                x2 = (-b - Math.sqrt(delta)) / (2 * a);
                                System.out.println("The final solutions: x1= " + x1 + "; x2= " + x2);
                            }
                        }
                        break;
                    case 4:
                        System.out.print("Enter n:");
                        int d = sc.nextInt();
                        while (true) {
                            if (d >= 1 && d <= 5) {
                                for (int k = 1; k <= d; k++) { // k runs 5 times
                                    for (int w = d - k; w >= 1; w--) { // printing spaces, j runs 4 times first, then j decreases to 1
                                        System.out.print("  ");
                                    }
                                    for (int w = 1; w <= (2 * k) - 1; w++) { // printing stars
                                        System.out.print("* "); // the number of stars printed out equals to that of times j runs
                                    }
                                    System.out.println(); // ending lines.
                                }
                                break;
                            } else {
                                System.out.print("Please enter integer from 1-5:");
                                d = sc.nextInt();
                            }
                        }
                        break;
                    case 5:
                        System.out.println("Thanks for using!!!");
                        break;
                    default:
                        System.out.println("Please enter an integer from 1-5.");
                }
            }
            while (userInput < 1 || userInput > 5);
        }
        while (userInput != 5);
    }
}
