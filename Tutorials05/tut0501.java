
import java.util.Scanner;

public class tut0501 {

    public static void main (String[] args) {
        Scanner input = new Scanner(System.in);
        double w, h, bmi;

        System.out.print("Enter weight: ");
        w = input.nextDouble();

        System.out.print("Enter height: ");
        h = input.nextDouble();

        bmi = w/(h*h);
        System.out.println("Your BMI: " + bmi);
    }
}