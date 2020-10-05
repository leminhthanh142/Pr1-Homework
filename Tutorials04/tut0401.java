
package Tutorials04;
import java.util.Scanner;
public class tut0401 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int year = input.nextInt();
        boolean isLeap = false;

        if (year % 4 == 0) {
            // mod 4 == 0 is leap year
            if (year % 100 == 0) {
                // mod 4 == 0 and 100 != is not leap year
                if (year % 400 == 0) {
                    isLeap = true;
                }
                else isLeap = false;
            }
            else isLeap = true;
        }
        else isLeap = false;

        if (isLeap) {
            System.out.println(year + " is a leap year");
        }
        else System.out.println(year + " is not a leap year ");
    }
}
