package Tutorials11;

import java.io.*;
import java.util.Scanner;

public class tut1102 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        // load file
        File myFile = new File("./src/Tutorials11/data.txt");

        // check if the file exists
        if (myFile.exists()) {
            System.out.println("File already exists.");
            System.out.println("Do you want to delete the file (yes/no) ?");
            char answer = input.next().charAt(0);
            if (answer == 'Y' || answer == 'y') {
                if (myFile.delete()) {
                    System.out.println("File was deleted!.");
                } else {
                    System.out.println("Failed to delete the file.");
                }
            }
        } else System.out.println("The file does not exists !!");
        input.close();
    }
}
