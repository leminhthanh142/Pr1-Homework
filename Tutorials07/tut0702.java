package Tutorials07;
import java.util.Scanner;
public class tut0702 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("Enter an integer number between 10 and 20: ");
        try {
            int num = input.nextInt();
            while (10 > num || 20 < num) {
                System.out.print("But you must enter an integer between 10 and 20: ");
                num = input.nextInt();
            }
            System.out.println("Thank you, " + num + " it is!!");
        }
        catch (Exception e) {
            System.out.println("Enter a number pls !!");
        }
        input.close();
    }
}
