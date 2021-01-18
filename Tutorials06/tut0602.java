package Tutorials06;
import java.util.Scanner;
public class tut0602 {
    public static void main(String[] args) {
        int[] arr = new int[0];
        Scanner sc = new Scanner(System.in);
        while (true) {
            int[] arr2 = new int[arr.length + 1];
            System.out.print("Enter an integer: ");
            arr2[arr.length] = sc.nextInt();
            sc.nextLine();
            for (int i = 0; i < arr.length; i++) {
                arr2[i] = arr[i];
                System.out.print(arr[i] + " ");
            }
            System.out.println(arr2[arr.length]);
            arr = arr2;

            System.out.print("Do you wish to continue? (Y/N) ");
            if (sc.nextLine().equalsIgnoreCase("n")) {
                System.out.println("Goodbye!");
                break;
            }
        }
    }
}
