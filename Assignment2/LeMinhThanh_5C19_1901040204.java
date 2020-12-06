//package Assignment2;
//
//import java.io.*;
//import java.util.ArrayList;
//import java.util.Scanner;
//
//public class Product {
//    private String productId;
//    private String productName;
//    private double productPrice;
//    private int productQuantity;
//
//    public Product(String new_productId, String new_productName, double new_productPrice, int new_productQuantity) {
//        this.productId = new_productId;
//        this.productName = new_productName;
//        this.productPrice = new_productPrice;
//        this.productQuantity = new_productQuantity;
//    }
//
//    public String getId() {
//        return this.productId;
//    }
//    public void setId(String new_productId) {
//
//        this.productId = new_productId;
//    }
//    public String getName() {
//        return this.productName;
//    }
//    public void setName(String new_productName) {
//        this.productName = new_productName;
//    }
//    public double getPrice() {
//        return this.productPrice;
//    }
//    public void setPrice(double new_ProductPrice) {
//        this.productPrice = new_ProductPrice;
//    }
//    public int getQuantity() {
//        return this.productQuantity;
//    }
//    public void setQuantity(int new_ProductQuantity) {
//        this.productQuantity = new_ProductQuantity;
//    }
//}
//
//public class Products {
//    static Scanner input = new Scanner(System.in);
//    private ArrayList<Product> ListOfProducts;
//
//    public Products() {
//        this.ListOfProducts = new ArrayList<>();
//    }
//
//    public static void displayMenu() {
//        System.out.println("Choose one feature listed below: \n" +
//                "- Feature 1: Add products \n" +
//                "- Feature 2: Display products \n" +
//                "- Feature 3: Delete a product \n" +
//                "- Feature 4: Edit a product \n" +
//                "- Feature 5: Search for products by name \n" +
//                "- Feature 6: Sort products by price \n" +
//                "- Feature 7: Save products to text file \n" +
//                "- Feature 8: Load products from the saved file \n" +
//                "- Feature 9: Exit program. \n" +
//                "Option: ");
//    }
//
//    public static void addProduct() {
//
//        System.out.print("Enter the number of product you want to add: ");
//        int numOfProducts = input.nextInt();
//        input.nextLine();
//
//        // for random id
//        String lowerCase = "abcdefghijklmnopqrstwxyz";
//        String upperCase = "ABCDEFGHIJKLMNOPQRSTWXYZ";
//        String symbols = "!@#$%^&*-_";
//        String digits = "0123456789";
//
//        for (int i = 1; i <= numOfProducts; i++) {
//            String productId = "";
//
//            // get random 3 characters from each string to form a random ID
//            for (int j=0; j<3; j++) {
//                productId += lowerCase.charAt((int) (Math.random() * lowerCase.length()));
//                productId += upperCase.charAt((int) (Math.random() * upperCase.length()));
//                productId += symbols.charAt((int) (Math.random() * symbols.length()));
//                productId += digits.charAt((int) (Math.random() * digits.length()));
//            }
//
//            System.out.println("-- Product " + i + " (id: " + productId + ")");
//            System.out.print("Enter product name: ");
//            String productName = input.nextLine();
//
//            System.out.print("Enter product price: ");
//            double productPrice = Double.parseDouble(input.nextLine());
//
//            System.out.print("Enter product quantity: ");
//            int productQuantity = Integer.parseInt(input.nextLine());
//
//            Products product = new Products(productId, productName, productPrice, productQuantity);
//            ListOfProducts.add(product);
//        }
//    }
//
//    public static void displayProduct() {
//        System.out.printf("%-3s | %-13s | %-40s | %-10s | %s | %n", "STT", "Id", "Name", "Price", "Quantity");
//        System.out.println("----------------------------------------------------------------------------------------");
//
//        int i=1;
//        for (Products p : ListOfProducts) {
//            System.out.printf("%-3d | %-13s | %-40s | %-10.2f | %-8d | %n", i,
//                    p.getId(), p.getName(), p.getPrice(), p.getQuantity());
//            i++;
//        }
//    }
//
//    public static void deleteProduct() {
//        System.out.print("Enter product ID that you want to remove: ");
//        String deleteID = input.nextLine();
//
//        boolean IdValidation = false;
//        Products productToDelete = null;
//        for (Products p : ListOfProducts) {
//            if (p.productId.equals(deleteID)) {
//                IdValidation = true;
//                productToDelete = p;
//                break;
//            }
//        }
//
//        if (IdValidation) {
//            ListOfProducts.remove(productToDelete);
//            System.out.println("Successfully delete product !!");
//        }
//        else System.out.println("Invalid ID. Try again with existed one!!");
//    }
//
//    public static void editProduct() {
//        System.out.print("Enter product ID that you want to edit: ");
//        String editID = input.nextLine();
//
//        boolean IdValidation = false;
//        Products productToEdit = null;
//        for (Products p : ListOfProducts) {
//            if (p.getId().equals(editID)) {
//                IdValidation = true;
//                productToEdit = p;
//                break;
//            }
//        }
//
//        if (IdValidation) {
//            System.out.print("Enter new name: ");
//            String new_productName = input.nextLine();
//
//            System.out.print("Enter new price: ");
//            double new_productPrice = Double.parseDouble(input.nextLine());
//
//            System.out.print("Enter new quantity: ");
//            int new_productQuantity = Integer.parseInt(input.nextLine());
//
//            // update product with new characteristics
//            ListOfProducts.get(ListOfProducts.indexOf(productToEdit)).setName(new_productName);
//            ListOfProducts.get(ListOfProducts.indexOf(productToEdit)).setPrice(new_productPrice);
//            ListOfProducts.get(ListOfProducts.indexOf(productToEdit)).setQuantity(new_productQuantity);
//        }
//        else System.out.println("Invalid ID. Try again with existed one!!");
//    }
//
//    public static void searchProduct() {
//        System.out.print("Enter key name to search: ");
//        String searchName = input.nextLine();
//
//        ArrayList<Products> searchProductList = new ArrayList<>();
//        boolean nameValidation = false;
//
//        for (Products p : ListOfProducts) {
//            if (p.getName().contains(searchName)) {
//                searchProductList.add(p);
//                nameValidation = true;
//            }
//        }
//
//        int i=1;
//        if (nameValidation) {
//            System.out.println("Search result: ");
//            System.out.printf("%-3s | %-13s | %-40s | %-10s | %s | %n", "STT", "Id", "Name", "Price", "Quantity");
//            System.out.println("----------------------------------------------------------------------------------------");
//            for (Products p : searchProductList) {
//                System.out.printf("%-3d | %-13s | %-40s | %-10.2f | %-8d | %n", i,
//                        p.getId(), p.getName(), p.getPrice(), p.getQuantity());
//                i++;
//            }
//        }
//        else System.out.println("Key doesn't match. Try again !!");
//    }
//
//    public static void sortProductByPrice() {
//        Products temp;
//        ArrayList<Products> Pds = new ArrayList<>(ListOfProducts);
//        for (int i=0; i<Pds.size(); i++) {
//            for (int j=i+1; j< Pds.size(); j++) {
//                if (Pds.get(i).productPrice > Pds.get(j).productPrice) {
//                    // swap 2 elements
//                    temp = Pds.get(i);
//                    Pds.set(i, Pds.get(j));
//                    Pds.set(j, temp);
//                }
//            }
//        }
//        System.out.println("Sorted result: ");
//        System.out.printf("%-3s | %-13s | %-40s | %-10s | %s | %n", "STT", "Id", "Name", "Price", "Quantity");
//        System.out.println("----------------------------------------------------------------------------------------");
//
//        int i=1;
//        for (Products p : Pds) {
//            System.out.printf("%-3d | %-13s | %-40s | %-10.2f | %-8d | %n", i,
//                    p.getId(), p.getName(), p.getPrice(), p.getQuantity());
//            i++;
//        }
//    }
//
//    public static void saveProductToFile() throws Exception {
//        FileOutputStream fos = new FileOutputStream("src/Assignment2/products.txt");
//        ObjectOutputStream oos = new ObjectOutputStream(fos);
//        oos.writeObject(ListOfProducts);
//        System.out.println("Successfully wrote to the file.");
//        oos.close();
//    }
//
//    public static void loadProducts() throws Exception {
//        FileInputStream fis = new FileInputStream("src/Assignment2/products.txt");
//        ObjectInputStream ois = new ObjectInputStream(fis);
//        ArrayList<Products> loadProducts = (ArrayList<Products>) ois.readObject();
//        ois.close();
//
//        System.out.println("File was loaded:  ");
//        System.out.printf("%-3s | %-13s | %-40s | %-10s | %s | %n", "STT", "Id", "Name", "Price", "Quantity");
//        System.out.println("----------------------------------------------------------------------------------------");
//
//        int i=1;
//        for (Products product : loadProducts) {
//            System.out.printf("%-4d | %-13s | %-40s | %-10.2f | %-8d | %n", i,
//                    product.getId(), product.getName(), product.getPrice(), product.getQuantity());
//            i++;
//        }
//    }
//}
//
//public class LeMinhThanh_5C19_1901040204 {
//
//    static Scanner input = new Scanner(System.in);
//
//    private Products products = new Products();
//
//    private Product product = new Product();
//
//    public static void main(String[] args) throws Exception {
//        int option;
//
//        do {
//            Products.displayMenu();
//            option = input.nextInt();
//            input.nextLine();
//            switch (option) {
//                case 1 -> Products.addProduct();
//                case 2 -> Products.displayProduct();
//                case 3 -> Products.deleteProduct();
//                case 4 -> Products.editProduct();
//                case 5 -> Products.searchProduct();
//                case 6 -> Products.sortProductByPrice();
//                case 7 -> Products.saveProductToFile();
//                case 8 -> Products.loadProducts();
//                default -> System.out.println("Invalid option. Try again!!");
//                case 9 -> System.out.println("Goodbye !!");
//            }
//        }
//        while (option != 9);
//        System.exit(0);
//    }
//}