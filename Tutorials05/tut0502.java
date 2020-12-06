package Tutorials05;
import java.util.Scanner;
public class tut0502 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("Enter money: ");
        String money = input.nextLine();

         if (money.substring(0, 1).equals("$")) {
            double m1 = Double.parseDouble(money.substring(1));
            double m2 = m1 * 23500;
            System.out.println(money + " = " + Math.round(m2) + " VND");
        }

        else if (money.length() < 4){
            System.out.println("Invalid input!!");
        }

        else {
            if (money.substring(money.length() - 4).equals(" EUR")) {
                double m3 = Double.parseDouble(money.substring(0, money.length() - 4));
                double m4 = m3 * 27100;
                System.out.println(money + " = " + Math.round(m4) + " VND");
            }
            else System.out.println("Invalid input!!");
        }

        input.close();
    }
}
