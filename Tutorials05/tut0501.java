package Tutorials05;
import java.util.Scanner;

public class tut0501 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        String[] usersName = {"andrew", "matt", "gary"};
        String[] passwords = {"5ecr3t", "goody2shoes", "mewtwo"};

        // ask users to enter their user-name
        System.out.print("Enter User Name: ");
        String name = input.nextLine();

        // create a variable to check if their user-name is valid or not
        boolean userValid = false;

        // create a for loop to run through the userNames to check if user-name is valid or not
        for (int i = 0; i < usersName.length; i++) {
            if (name.equals(usersName[i])) {

                // if user-name is valid then set the userValid to true
                userValid = true;

                // ask user to enter the password if the user-name is valid
                System.out.print("Enter password: ");
                String password = input.nextLine();

                // check for the password correction
                if (password.equals(passwords[i])) {
                    System.out.println("Welcome, " + name);
                } else System.out.println("Wrong password, " + name);
            }
        }

        // if user-name is not valid then print this
        if (!userValid) {
            System.out.println("I dont't know you, " + name);
        }
        input.close();
    }
}



/*        another way to solve this problem, i ask user to enter both their username and password
          then check it later

            System.out.print("Enter User Name: ");
            String name = input.nextLine();
            System.out.print("Enter password: ");
            String password = input.nextLine();
            boolean userValid = false;
            boolean passCorrect = false;

            for (String i : usersName) {
                if (name.equals(i)) {
                    userValid = true;
                    for (String j : passwords) {
                        if (password.equals(j)) {
                            passCorrect = true;
                        }
                    }
                }
            }
            if (userValid && passCorrect) {
                System.out.println("Welcome, " + name);
            }
            else if (userValid) {
                System.out.println("Wrong password, " + name);
            }
            if (!userValid) {
                System.out.println("I don't know you, " + name);
            }

        }
} */