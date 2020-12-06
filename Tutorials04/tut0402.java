
package Tutorials04;
import java.util.Scanner;
public class tut0402 {
    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);

        System.out.print("Enter a: ");
        double a = input.nextDouble();
        System.out.print("Enter b: ");
        double b = input.nextDouble();
        System.out.print("Enter c: ");
        double c = input.nextDouble();

        double x1, x2;
        double delta = b*b - 4*a*c;

        if ( a == 0) {
            System.out.println("The equation has one root x: " + (-c/b));
        }
        else if (delta < 0) {
            System.out.println("There is no root !!");
        }
        else if (delta == 0) {
            x1 = -b/2*a;
            System.out.println("There is a double root: " + x1);
        }
        else {
            x1 = ((-b + Math.sqrt(delta)) / (2*a));
            x2 = ((-b - Math.sqrt(delta)) / (2*a));
            System.out.println("There are 2 roots");
            System.out.println("x1: "+x1);
            System.out.println("x2: "+x2);
        }

    }
}
