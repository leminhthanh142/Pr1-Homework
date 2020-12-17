package assignment2;

import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

class Product implements Serializable {
    static Scanner input = new Scanner(System.in);
    private int ID;
    private String name;
    private double price;
    private int quantity;
    private static ArrayList<Product> Prod = new ArrayList<>();

    public Product (int ID, String name, double price, int quantity) {
        this.ID = ID;
        this.name = name;
        this.price = price;
        this.quantity = quantity;
    }

    public int getID() {
        return this.ID;
    }

    public String getname() {
        return this.name;
    }

    public double getprice() {
        return this.price;
    }

    public int getquantity() {
        return this.quantity;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public void setquantity(int quantity) {
        this.quantity = quantity;
    }

    public void setname(String name) {
        this.name = name;
    }

    public void setprice(Double price) {
        this.price = price;
    }

    public static class Assignment2 {
        public static void main(String[] args) throws Exception {
            Scanner sc = new Scanner(System.in);
            int choice;
            System.out.println("Enter options");
            do {
                System.out.println("Choose one feature listed below");
                System.out.println("1. Add products");
                System.out.println("2. Display products");
                System.out.println("3. Delete a product");
                System.out.println("4. Edit a product");
                System.out.println("5. Search for products by name");
                System.out.println("6. Sort products by price");
                System.out.println("7. Save products to text file");
                System.out.println("8. Load products from the saved file");
                System.out.println("9. Exit program.");
                choice = sc.nextInt();
                switch (choice) {
                    case 1:
                        addpr(sc);
                        break;
                    case 2:
                        displaypr(sc);
                        break;
                    case 3:
                        deletepr(sc);
                        break;
                    case 4:
                        editpr(sc);
                        break;
                    case 5:
                        searchpr(sc);
                        break;
                    case 6:
                        orderpr(sc);
                        break;
                    case 7:
                        savepr(sc);
                        break;
                    case 8:
                        loadpr(sc);
                        break;
                    case 9:
                        System.out.println("Good bye!!");
                    default:
                        System.out.println("Please try again !!");
                }
            }
            while (choice != 9);
            System.out.println("end program");
        }
    }
    public static int randomID () {
        int min = 100, max = 1000;
        int ID;
        ID = (int) (Math.random()*(max - min + 1) + min);
        return ID;
    }
    public static void addpr (Scanner sc) {
        System.out.print("Enter the number of product: ");
        int num = input.nextInt();
        input.nextLine();

        for (int a=1; a<=num; a++) {
            System.out.println("Product " + a + ":");

            System.out.print("Enter Name:  ");
            String name = input.nextLine();

            System.out.print("Enter Price:  ");
            double price = Double.parseDouble(input.nextLine());

            System.out.print("Enter Quantity:  ");
            int quantity = Integer.parseInt(input.nextLine());

            // create new instance of SanPham
            Product pr = new Product(randomID(), name, price, quantity);
            Prod.add(pr);
        }
    }
    public static void displaypr (Scanner sc) {
        System.out.printf("%-3s | %-40s | %-10s | %-10s", "ID", "Name", "Price", "Quantity");
        System.out.println();
        for (Product sp : Prod) {
            System.out.printf("%-3d | %-40s | %-10.2f | %-10d", sp.getID(), sp.getname(), sp.getprice(), sp.getquantity());
            System.out.println();
        }
    }
    public static void deletepr (Scanner sc) {
        System.out.print("Enter product ID tou want delete: ");
        int inputID = input.nextInt();
        for (Product sp : Prod) {
            if (sp.getID() == inputID) {
                Prod.remove(sp);
                break;
            }
        }
    }
    public static void editpr (Scanner sc) {
        System.out.print("Enter product ID: ");
        int inputID = input.nextInt();
        input.nextLine();

        for (Product sp : Prod) {
            if (sp.getID() == inputID) {
                System.out.print("Enter new name: ");
                String newname = input.nextLine();

                System.out.print("Enter new price: ");
                double newprice = input.nextDouble();

                System.out.print("Enter new quantity: ");
                int newquantity = input.nextInt();

                sp.setname(newname);
                sp.setprice(newprice);
                sp.setquantity(newquantity);
            }
        }
    }
    public static void searchpr (Scanner sc) {
        System.out.print("Enter key name: ");
        String keyName = input.nextLine();

        ArrayList<Product> dsTimKiem = new ArrayList<>();
        for (Product sp : Prod) {
            if (sp.getname().contains(keyName)) {
                dsTimKiem.add(sp);
            }
        }
        System.out.printf("%-3s | %-40s | %-10s | %-10s", "ID", "Name", "Price", "Quantity");
        System.out.println();
        for (Product sp : dsTimKiem) {
            System.out.printf("%-3d | %-40s | %-10.2f | %-10d", sp.getID(), sp.getname(), sp.getprice(), sp.getquantity());
            System.out.println();
        }
    }
    public static void orderpr (Scanner sc) {

        ArrayList<Product> danhSachSapXep = new ArrayList<>(Prod);

        Product temp;
        for (int a=0; a< danhSachSapXep.size() - 1; a++) {
            for (int b=a+1; b< danhSachSapXep.size(); b++) {
                if (danhSachSapXep.get(a).getprice() > danhSachSapXep.get(b).getprice()) {
                    temp = danhSachSapXep.get(a);
                    danhSachSapXep.set(a, danhSachSapXep.get(b));
                    danhSachSapXep.set(b, temp);
                }
            }
        }
        System.out.printf("%-3s | %-40s | %-10s | %-10s", "ID", "Name", "Price", "Quantity");
        System.out.println();
        for (Product sp : danhSachSapXep) {
            System.out.printf("%-3d | %-40s | %-10.2f | %-10d", sp.getID(), sp.getname(), sp.getprice(), sp.getquantity());
            System.out.println();
        }
    }
    public static void savepr (Scanner sc) throws Exception {
        File f = new File("src/Assignment2/products.txt");
        FileOutputStream fos = new FileOutputStream(f);
        ObjectOutputStream oos = new ObjectOutputStream(fos);
        oos.writeObject(Prod);
    }
    public static void loadpr (Scanner sc) throws Exception{
        ObjectInputStream ois = new ObjectInputStream(new FileInputStream("src/Tutorials12/products.txt"));
        ArrayList<Product> danhSach;

        danhSach = (ArrayList<Product>) ois.readObject();


        System.out.printf("%-3s | %-40s | %-10s | %-10s", "ID", "Name", "Price", "Quantity");
        System.out.println();
        for (Product sp : danhSach) {
            System.out.printf("%-3d | %-40s | %-10.2f | %-10d", sp.getID(), sp.getname(), sp.getprice(), sp.getquantity());
            System.out.println();
        }
    }
}








