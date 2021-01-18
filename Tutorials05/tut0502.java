package Tutorials05;
import java.util.Scanner;
public class tut0502 {
    public static void main(String[] args) {
        Scanner input = new Scanner (System.in);
        String price = input.nextLine();

        if (price.length() < 4) System.out.println("invalid input");
        else {
            if(price.startsWith("$")) {
                double p1 = Double.parseDouble(price.substring(1, price.length())) * 23500;
                System.out.println("VND: " + p1);

            }

            if(price.endsWith(" EUR")) {
                double p2 = Double.parseDouble(price.substring(0, price.length() - 4)) * 27100;
                System.out.println("VND: " + p2);

            }

        }


        input.close();
    }
}
