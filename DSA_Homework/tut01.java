package DSA_Homework;

import java.util.Scanner;

public class tut01 {
    static Scanner input = new Scanner(System.in);
    public static void main(String[] args) {
        System.out.print("Enter your name: ");
        String userName = input.nextLine();
        System.out.println("Result: " + characterCount(userName) + " characters");
        System.out.println();

        System.out.print("How many number you want to add: ");
        int n = input.nextInt();
        System.out.println("Max value is: " + maxInteger(n));
        System.out.println();

        System.out.print("How many number of array: ");
        int num = input.nextInt();
        int [] arr = sortedArr(num);
        System.out.print("Sorted array: ");
        for (int i : arr) {
            System.out.print(i + " ");
        }
        System.out.println();

        System.out.print("How many name you want to add: ");
        int numOfNames = input.nextInt();
        input.nextLine();
        String [] names = new String[numOfNames];

        for (int i=0; i<names.length; i++) {
            names[i] = input.nextLine();
        }

        System.out.print("Enter name that you want to search for: ");
        String nameSearch = input.nextLine();
        System.out.println("Result: " + nameSearching(names, nameSearch));

    }

    public static int characterCount(String name) {
        int count = 0;
        for (int i=0; i<name.length(); i++) {
            if (name.charAt(i) != ' ') count++;
        }
        return count;
    }

    public static int maxInteger (int n) {
        int [] arr = new int[n];
        int max = arr[0];

        for (int i=0; i<arr.length; i++) {
            arr[i] = input.nextInt();
            if (arr[i] > max) max = arr[i];
        }

        return max;
    }

    public static int[] sortedArr (int n) {
        int [] arr = new int[n];
        int temp;

        for (int i=0; i<arr.length; i++) {
            arr[i] = input.nextInt();
        }

        for (int i=0; i<arr.length - 1; i++) {
            for (int j=i+1; j<arr.length; j++) {
                if (arr[i] > arr[j]) {
                    temp = arr[i];
                    arr[i] = arr[j];
                    arr[j] = temp;
                }
            }
        }
        return arr;
    }

    public static int nameSearching (String [] names, String name) {
        for (int i=0; i<names.length; i++) {
            if (name.equals(names[i])) return i;
        }
        return -1;
    }
}
