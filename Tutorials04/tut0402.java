
package Tutorials04;
import java.util.Scanner;
public class tut0402 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("Nhap he so a: ");
        double a = input.nextDouble();
        System.out.print("Nhap he so b: ");
        double b = input.nextDouble();
        System.out.print("Nhap he so c: ");
        double c = input.nextDouble();
        double x1, x2;
        double delta = b*b - 4*a*c;

        if (delta < 0) {
            System.out.println("Phuong trinh vo nghiem !!");
        }
        else if (delta == 0) {
            x1 = -b/2*a;
            System.out.println("Phuong trinh co nghiem kep: " + x1);
        }
        else {
            x1 = (-b + Math.sqrt(delta)/2*a);
            x2 = (-b - Math.sqrt(delta)/2*a);
            System.out.println("Phuong trinh co 2 nghiem: x1: " + x1 + "x2: " + x2);
        }

    }
}
