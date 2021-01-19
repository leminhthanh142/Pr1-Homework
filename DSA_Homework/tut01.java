package DSA_Homework;

import java.util.Scanner;

public class tut01 {
    static Scanner input = new Scanner(System.in);
    public static void main(String[] args) {

        // exercise 1
        System.out.print("Enter your name: ");
        String userName = input.nextLine();
        System.out.println("Result: " + characterCount(userName) + " characters");
        System.out.println();


        // exercise 2
        System.out.print("How many number you want to add: ");
        int n = input.nextInt();
        int [] arr= new int[n];

        for (int i=0; i<n; i++)
            arr[i] = input.nextInt();

        System.out.println("Max value is: " + maxInteger(arr));
        System.out.println();


        // exercise 3
        System.out.print("How many number of array: ");
        int num = input.nextInt();
        int [] arr1 = new int[num];
        for (int i=0; i<num; i++)
            arr1[i] = input.nextInt();

        int [] arr2 = sortedArr(arr1);
        System.out.print("Sorted array: ");
        for (int i : arr2) {
            System.out.print(i + " ");
        }
        System.out.println();


        // exercise 4
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


    // exercise 1
    public static int characterCount(String name) {
        int count = 0;
        for (int i=0; i<name.length(); i++) {
            if (name.charAt(i) != ' ') count++;
        }
        return count;
    }


    // exercise 2
    public static int maxInteger (int [] arr) {
        int max = arr[0];

        for (int j : arr)
            if (j > max) max = j;

        return max;
    }


    // exercise 3
    public static int[] sortedArr (int [] arr) {

        // selection sort algorithm
        for (int i=0; i<arr.length - 1; i++) {
            int minIndex = i;
            for (int j=i+1; j<arr.length; j++)
                if (arr[j] < arr[minIndex])
                    minIndex = j;

            int temp = arr[minIndex];
            arr[minIndex] = arr[i];
            arr[i] = temp;
        }
        return arr;
    }


    // exercise 4
    public static int nameSearching (String [] names, String name) {
        for (int i=0; i<names.length; i++) {
            if (name.equals(names[i])) return i;
        }
        return -1;
    }
}