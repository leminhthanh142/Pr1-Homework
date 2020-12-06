package codewars;

import java.util.Scanner;

public class number {
    static Scanner input = new Scanner(System.in);

    public static void main(String[] args) {
        System.out.println("Result: " + add());
        System.out.println("Decimal number is: " + BinaryToDecimal());
    }

    public static String add() {

        System.out.print("Enter a: ");
        StringBuilder a = new StringBuilder(input.next());
        a.reverse();

        System.out.print("Enter b: ");
        StringBuilder b = new StringBuilder(input.next());
        b.reverse();

        int[] arrayA = new int[100];
        int[] arrayB = new int[100];
        String result = "";

        while (a.length() != b.length()) {
            if (a.length() > b.length()) {
                b.append("0");
            } else a.append("0");
        }

        int[] arr = new int[a.length()];

        for (int i = 0; i < a.length(); i++) {
            arrayA[i] = Integer.parseInt(String.valueOf(a.charAt(i)));
            arrayB[i] = Integer.parseInt(String.valueOf(b.charAt(i)));
            arr[i] = arrayA[i] + arrayB[i];
        }
        for (int i = arr.length - 1; i >= 0; i--) {
            result += Integer.toString(arr[i]);
        }
        return result;
    }

    public static int BinaryToDecimal() {
        int power = 0;
        int decimalNum = 0;
        System.out.print("Enter binary number: ");
        int binaryNum = input.nextInt();
        while (true) {
            if (binaryNum == 0) {
                break;
            } else {
                int temp = binaryNum % 10;
                decimalNum += temp * Math.pow(2, power);
                binaryNum = binaryNum / 10;
                power++;
            }
        }
        return decimalNum;
    }
}
