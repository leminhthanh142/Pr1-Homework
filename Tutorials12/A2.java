package Tutorials12;

import java.util.Scanner;
import java.util.ArrayList;
import java.io.*;


class product implements Serializable {
    private String ID;
    private String userName;
    private double price;
    private int Quantity;

    //    Create a constructor
    public product(String nID, String nName, double nPrice, int nQuantity) {
        this.ID = nID;
        this.userName = nName;
        this.price = nPrice;
        this.Quantity = nQuantity;
    }

    public String getID() {
        return ID;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getQuantity() {
        return Quantity;
    }

    public void setQuantity(int quantity) {
        Quantity = quantity;
    }

}

//GENERATE RANDOM ID
class ID_generator {
    public static String numbers = "0123456789";

    public static String generateID() {
        String ID = "";
        for (int i = 0; i < 4; i++) {
            ID += numbers.charAt((int) (Math.random() * numbers.length()));
        }
        return ID;
    }
}

class Functions {
    static Scanner sc = new Scanner(System.in);
    public static ArrayList<product> productList;

    public Functions() {
        productList = new ArrayList<>();
    }

    public static void Add() {
        String Name;
        double price;
        int Quantity;

        System.out.println("Enter the number of products: ");
        int productNumber = sc.nextInt();
        sc.nextLine();

//        Create a for loop to set properties as many times as the number of products
        for (int i = 0; i < productNumber; i++) {
            System.out.print("Enter product name:");
            Name = sc.nextLine();
            System.out.print("Enter product price:");
            price = Double.parseDouble(sc.nextLine());
            System.out.print("Enter product quantity:");
            Quantity = Integer.parseInt(sc.nextLine());
            productList.add(new product(ID_generator.generateID(), Name, price, Quantity));
        }

    }

    public static void Display() {
//        Print out table
        System.out.printf("%-3s | %-13s | %-40s | %-10s | %s | %n", "STT", "Id", "Name", "Price", "Quantity");
        System.out.println("========================================================================================");
//        Display object's properties
        int i = 1;
        for (product arr : productList) {
            System.out.printf("%-3d | %-13s | %-40s | %-10.2f | %-8d | %n", i,
                    arr.getID(), arr.getUserName(), arr.getPrice(), arr.getQuantity());
            i++;
        }
    }

    public static void Delete() {
        System.out.println("Please enter the ID that you want to remove:");
        String remover = sc.nextLine();

        for (product p : productList) {
            if (p.getID().equals(remover)) {
                productList.remove(p);
                System.out.println("Product is deleted");
                break;
            }
        }
    }


    public static void Edit() {
        System.out.println("Please enter the ID that you want to edit:");
        String userInput = sc.nextLine();
        for (product p : productList) {
            if (p.getID().equals(userInput)) {
                System.out.print("New name: ");
                String nName = sc.nextLine();

                System.out.print("New price: ");
                double nPrice = sc.nextDouble();

                System.out.print("New quantity: ");
                int nQuantity = sc.nextInt();

//            REPLACE THE PREVIOUS INFORMATION
                p.setUserName(nName);
                p.setPrice(nPrice);
                p.setQuantity(nQuantity);
                break;
            }

        }

    }

    public static void Search() {
        System.out.print("Search here: ");
        String userInput = sc.nextLine();
//        sc.nextLine();
        ArrayList<product> productSearch = new ArrayList<>();

//        A LOOP FOR SEARCHING AN APPROPRIATE STRING AMONG THE EXISTED PRODUCTS
        for (product p : productList) {
            if (p.getUserName().contains(userInput)) {
                productSearch.add(p);
            }
        }
//        PRINT OUT RESULT
        System.out.printf("%-3s | %-13s | %-40s | %-10s | %s | %n", "STT", "Id", "Name", "Price", "Quantity");
        System.out.println("----------------------------------------------------------------------------------------");
        int i = 1;
        for (product arr : productSearch) {
            System.out.printf("%-3d | %-13s | %-40s | %-10.2f | %-8d | %n", i,
                    arr.getID(), arr.getUserName(), arr.getPrice(), arr.getQuantity());
            i++;
        }
    }

    public static void SortProducts() {

//        Create a temporary variable to swap elements
        product c;
        ArrayList<product> arrangment = new ArrayList<>(productList);
        for (int i = 0; i < arrangment.size(); i++) {
            for (int k = i + 1; k < arrangment.size(); k++) {
                if (arrangment.get(i).getPrice() > arrangment.get(k).getPrice()) {
                    c = arrangment.get(i);
                    arrangment.set(i, arrangment.get(k));
                    arrangment.set(k, c);
                }
            }
        }
//            Print out table
        System.out.printf("%-3s | %-13s | %-40s | %-10s | %s | /n", "STT", "ID", "Name", "Price", "Quantity");
        System.out.println("----------------------------------------------------------------------------------------");
        int j = 1;
        for (product arr : arrangment) {
            System.out.printf("%-3d | %-13s | %-40s | %-10.2f | %-8d | /n", j,
                    arr.getID(), arr.getUserName(), arr.getPrice(), arr.getQuantity());
            j++;
        }
    }


    public static void saveFile() throws Exception {
        ObjectOutputStream oos;
        oos = new ObjectOutputStream(new FileOutputStream("C:/Users/dongo/Desktop/file.txt"));
        oos.writeObject(productList);
        System.out.println("File saved");
        oos.close();
    }

    public static void loadFile() throws Exception {

//       READ AND LOAD SAVED FILE
        ObjectInputStream ois = new ObjectInputStream(new FileInputStream("C:/Users/dongo/Desktop/file.txt"));
        ArrayList<product> loadProducts = (ArrayList<product>) ois.readObject();
        ois.close();

//       PRINTED OUT THE SAVED FILE
        System.out.println("File was loaded !");
        System.out.printf("%-3s | %-13s | %-40s | %-10s | %s | %n", "STT", "Id", "Name", "Price", "Quantity");
        int i = 1;
        for (product p : loadProducts) {
            System.out.printf("%-4d | %-13s | %-40s | %-10.2f | %-8d | %n", i,
                    p.getID(), p.getUserName(), p.getPrice(), p.getQuantity());
            i++;
        }
    }

    public static void Menu() {
        System.out.println("SELECT ONE FEATURE: \n" +
                "================================================\n" +
                "| Feature 1: Add products                      |\n" +
                "| Feature 2: Display products                  |\n" +
                "| Feature 3: Delete a product                  |\n" +
                "| Feature 4: Edit a product                    |\n" +
                "| Feature 5: Search for products by name       |\n" +
                "| Feature 6: Sort products by price            |\n" +
                "| Feature 7: Save products to text file        |\n" +
                "| Feature 8: Load products from the saved file |\n" +
                "| Feature 9: Exit program.                     |\n" +
                "Option: ");
    }
}


public class A2 {
    static Scanner sc = new Scanner(System.in);
    private static final Functions product = new Functions();

    public static void main(String[] args) throws Exception {
        int option = 0;
        while (option != 9) {
            Functions.Menu();
            option = sc.nextInt();
            sc.nextLine();
            switch (option) {
                case 1 -> Functions.Add();
                case 2 -> Functions.Display();
                case 3 -> Functions.Delete();
                case 4 -> Functions.Edit();
                case 5 -> Functions.Search();
                case 6 -> Functions.SortProducts();
                case 7 -> Functions.saveFile();
                case 8 -> Functions.loadFile();
                default -> System.out.println("Invalid option. Try again!!");
                case 9 -> System.out.println("Goodbye !!");
            }
        }
    }
}
