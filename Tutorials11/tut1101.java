package Tutorials11;

import java.io.*;
import java.util.Scanner;

public class tut1101 {
    public static void main(String[] args) throws Exception {
        Scanner input = new Scanner(System.in);

        // create new file
        File myFile = new File("./src/Tutorials11/data.txt");
        if (myFile.createNewFile()) {
            PrintWriter pr = new PrintWriter(myFile);
            System.out.print("Enter your name: ");
            String name = input.nextLine();

            // add name to the file
            pr.println("Name: " + name);
            pr.close();
            System.out.println("Successfully wrote to the file.");
        } else {
            System.out.println("File already exists.");
        }
        input.close();
    }
}
