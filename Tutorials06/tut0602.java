package Tutorials06;
import java.util.Scanner;
public class tut0602 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        int [] arr = new int[0];
        char choice = 'y';

        while (choice == 'Y' || choice == 'y') {
            int[] arr2 = new int[arr.length + 1];
            System.out.print("Enter the number: ");
            int num = input.nextInt();

            for (int i = 0; i < arr.length; i++) {
                arr2[i] = arr[i];
            }

            arr2[arr2.length - 1] = num;
            arr = arr2;

            for (int j : arr) {
                System.out.print(" " + j);
            }

            System.out.println(" ");
            System.out.println("Do you want to continue entering a new number?");
            System.out.println("Yes / No");

            choice = input.next().charAt(0);
        }
        System.out.println("Bye !!!");
        input.close();
    }
}
