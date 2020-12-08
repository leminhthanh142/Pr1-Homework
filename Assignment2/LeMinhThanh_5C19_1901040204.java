package Assignment2;

import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

class Product implements Serializable {
    private String productId;
    private String productName;
    private double productPrice;
    private int productQuantity;

    public Product(String new_productId, String new_productName, double new_productPrice, int new_productQuantity) {
        this.productId = new_productId;
        this.productName = new_productName;
        this.productPrice = new_productPrice;
        this.productQuantity = new_productQuantity;
    }

    public String getId() {
        return this.productId;
    }

    public void setId(String new_productId) {
        this.productId = new_productId;
    }

    public String getName() {
        return this.productName;
    }

    public void setName(String new_productName) {
        this.productName = new_productName;
    }

    public double getPrice() {
        return this.productPrice;
    }

    public void setPrice(double new_ProductPrice) {
        this.productPrice = new_ProductPrice;
    }

    public int getQuantity() {
        return this.productQuantity;
    }

    public void setQuantity(int new_ProductQuantity) {
        this.productQuantity = new_ProductQuantity;
    }
}

class GeneratorID {
    final static String lowerCase = "abcdefghijklmnopqrstwxyz";
    final static String upperCase = "ABCDEFGHIJKLMNOPQRSTWXYZ";
    final static String symbols = "!@#$%^&*-_";
    final static String digits = "0123456789";

    public static String generate() {
        String productId = "";
        for (int j = 0; j < 3; j++) {
            productId += lowerCase.charAt((int) (Math.random() * lowerCase.length()));
            productId += upperCase.charAt((int) (Math.random() * upperCase.length()));
            productId += symbols.charAt((int) (Math.random() * symbols.length()));
            productId += digits.charAt((int) (Math.random() * digits.length()));
        }
        return productId;
    }
}

class Products {
    private static ArrayList<Product> ListOfProducts;

    public Products() {
        ListOfProducts = new ArrayList<>();
    }

    public ArrayList<Product> getList() {
        return ListOfProducts;
    }

    public Product add(Product product) {
        ListOfProducts.add(product);
        return product;
    }

    public void display() {
        System.out.printf("%-3s | %-13s | %-40s | %-10s | %s | %n", "STT", "Id", "Name", "Price", "Quantity");
        System.out.println("----------------------------------------------------------------------------------------");

        int i = 1;
        for (Product p : ListOfProducts) {
            System.out.printf("%-3d | %-13s | %-40s | %-10.2f | %-8d | %n", i,
                    p.getId(), p.getName(), p.getPrice(), p.getQuantity());
            i++;
        }
    }

    public void delete(String ID) {
        for (Product p : ListOfProducts) {
            if (p.getId().equals(ID)) {
                ListOfProducts.remove(p);
                break;
            }
        }
    }

    public Product edit(String ID, String Name, double Price, int Quantity) {
        Product editedProduct = null;
        for (Product p : ListOfProducts) {
            if (p.getId().equals(ID)) {
                p.setName(Name);
                p.setPrice(Price);
                p.setQuantity(Quantity);
                editedProduct = p;
                break;
            }
        }
        return editedProduct;
    }

    public ArrayList<Product> search(String key) {
        ArrayList<Product> searchList = new ArrayList<>();
        for (Product p : ListOfProducts) {
            if (p.getName().contains(key)) {
                searchList.add(p);
            }
        }
        return searchList;
    }

    public ArrayList<Product> sortByPrice() {
        Product temp;
        ArrayList<Product> sortedList = new ArrayList<>(ListOfProducts);
        for (int i = 0; i < sortedList.size(); i++) {
            for (int j = i + 1; j < sortedList.size(); j++) {
                if (sortedList.get(i).getPrice() > sortedList.get(j).getPrice()) {
                    // swap 2 elements
                    temp = sortedList.get(i);
                    sortedList.set(i, sortedList.get(j));
                    sortedList.set(j, temp);
                }
            }
        }
        return sortedList;
    }

}

class ProductsStorage {

    public void save(Products products) throws Exception {
        FileOutputStream fos = new FileOutputStream("src/Assignment2/products.txt");
        ObjectOutputStream oos = new ObjectOutputStream(fos);
        oos.writeObject(products);
        System.out.println("Successfully wrote to the file.");
        oos.close();
    }

    public ArrayList<Product> load() throws Exception {
        FileInputStream fis = new FileInputStream("src/Assignment2/products.txt");
        ObjectInputStream ois = new ObjectInputStream(fis);
        ArrayList<Product> loadProducts = (ArrayList<Product>) ois.readObject();
        ois.close();
        return loadProducts;
    }
}

class Assignment2 {
    private final Products products = new Products();
    private final ArrayList<Product> ListOfProducts = products.getList();
    private final ProductsStorage productsStorage = new ProductsStorage();
    Scanner input = new Scanner(System.in);

    public void displayMenu() {
        System.out.println("Choose one feature listed below: \n" +
                "- Feature 1: Add products \n" +
                "- Feature 2: Display products \n" +
                "- Feature 3: Delete a product \n" +
                "- Feature 4: Edit a product \n" +
                "- Feature 5: Search for products by name \n" +
                "- Feature 6: Sort products by price \n" +
                "- Feature 7: Save products to text file \n" +
                "- Feature 8: Load products from the saved file \n" +
                "- Feature 9: Exit program. \n" +
                "Option: ");
    }

    public void start() throws Exception {

        int option;

        do {
            displayMenu();
            option = input.nextInt();
            input.nextLine();
            switch (option) {
                case 1 -> {
                    String productName;
                    double productPrice;
                    int productQuantity;

                    System.out.print("Enter the number of product you want to add: ");
                    int numOfProducts = input.nextInt();
                    input.nextLine();

                    for (int i = 1; i <= numOfProducts; i++) {
                        System.out.println("-- Product " + i);
                        System.out.print("Enter product name: ");
                        productName = input.nextLine();

                        System.out.print("Enter product price: ");
                        productPrice = Double.parseDouble(input.nextLine());

                        System.out.print("Enter product quantity: ");
                        productQuantity = Integer.parseInt(input.nextLine());

                        products.add(new Product(GeneratorID.generate(), productName, productPrice, productQuantity));
                    }
                }

                case 2 -> products.display();

                case 3 -> {
                    System.out.print("Enter ID to delete: ");
                    String deleteID = input.nextLine();

                    boolean IdValidation = false;
                    for (Product p : ListOfProducts) {
                        if (p.getId().equals(deleteID)) {
                            IdValidation = true;
                            break;
                        }
                    }

                    if (IdValidation) {
                        products.delete(deleteID);
                    } else System.out.println("Invalid ID. Try again with an existed one!!");
                }

                case 4 -> {
                    boolean IdValidation = false;
                    System.out.print("Enter product ID: ");
                    String ID = input.nextLine();
                    for (Product p : ListOfProducts) {
                        if (p.getId().equals(ID)) {
                            IdValidation = true;
                            break;
                        }
                    }
                    if (IdValidation) {
                        System.out.print("Enter new name: ");
                        String new_productName = input.nextLine();

                        System.out.print("Enter new price: ");
                        double new_productPrice = Double.parseDouble(input.nextLine());

                        System.out.print("Enter new quantity: ");
                        int new_productQuantity = Integer.parseInt(input.nextLine());

                        products.edit(ID, new_productName, new_productPrice, new_productQuantity);
                    } else System.out.println("Invalid ID. Try again with an existed one!!");
                }

                case 5 -> {
                    System.out.print("Enter key name to search: ");
                    String keyName = input.nextLine();

                    boolean keyValidation = false;
                    for (Product p : ListOfProducts) {
                        if (p.getName().contains(keyName)) {
                            keyValidation = true;
                            break;
                        }
                    }

                    if (keyValidation) {
                        ArrayList<Product> searchList = products.search(keyName);
                        int i = 1;

                        System.out.println("Search result: ");
                        System.out.printf("%-3s | %-13s | %-40s | %-10s | %s | %n", "STT", "Id", "Name", "Price", "Quantity");
                        System.out.println("----------------------------------------------------------------------------------------");

                        for (Product p : searchList) {
                            System.out.printf("%-3d | %-13s | %-40s | %-10.2f | %-8d | %n", i,
                                    p.getId(), p.getName(), p.getPrice(), p.getQuantity());
                            i++;
                        }
                    } else System.out.println("Key doesn't match any name. Try again!!");
                }

                case 6 -> {
                    ArrayList<Product> sortedList = products.sortByPrice();

                    System.out.println("Sorted result: ");
                    System.out.printf("%-3s | %-13s | %-40s | %-10s | %s | %n", "STT", "Id", "Name", "Price", "Quantity");
                    System.out.println("----------------------------------------------------------------------------------------");

                    int i = 1;
                    for (Product p : sortedList) {
                        System.out.printf("%-3d | %-13s | %-40s | %-10.2f | %-8d | %n", i,
                                p.getId(), p.getName(), p.getPrice(), p.getQuantity());
                        i++;
                    }
                }

                case 7 -> productsStorage.save(products);

                case 8 -> {
                    ArrayList<Product> loadList = productsStorage.load();
                    System.out.println("File was loaded: ");
                    System.out.printf("%-3s | %-13s | %-40s | %-10s | %s | %n", "STT", "Id", "Name", "Price", "Quantity");
                    System.out.println("----------------------------------------------------------------------------------------");

                    int i = 1;
                    for (Product p : loadList) {
                        System.out.printf("%-3d | %-13s | %-40s | %-10.2f | %-8d | %n", i,
                                p.getId(), p.getName(), p.getPrice(), p.getQuantity());
                        i++;
                    }
                }

                case 9 -> System.out.println("Goodbye !!");

                default -> System.out.println("Invalid option. Try again!!");
            }
        }
        while (option != 9);
        System.exit(0);
    }
}

public class LeMinhThanh_5C19_1901040204 {
    public static void main(String[] args) throws Exception {
        final Assignment2 Assignment2 = new Assignment2();
        Assignment2.start();
    }
}