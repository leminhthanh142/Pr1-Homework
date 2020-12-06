package Tutorials11;

import java.io.*;
import java.util.Scanner;
import java.util.ArrayList;

public class tut1103 {
    public static void main(String[] args) throws Exception {
        Scanner input = new Scanner(System.in);

        // create data.bin file
        File myFile = new File("./src/Tutorials11/data.bin");
        FileOutputStream fos = new FileOutputStream(myFile);
        ObjectOutputStream oos = new ObjectOutputStream(fos);
        ArrayList<String> names = new ArrayList<>();

        // add user to names (ArrayList)
        System.out.println("Enter user name ");
        for (int i = 1; i <= 5; i++) {
            System.out.print("User " + i + ": ");
            String name = input.nextLine();
            names.add("User " + i + ": " + name + "\n");
        }

        // write names to file
        oos.writeObject(names);
        System.out.println("Successfully wrote to the file.");
        input.close();
        oos.close();
    }
}
