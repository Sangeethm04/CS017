import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class BookStore {
    public static void main(String[] args) {
        Scanner keyboard = new Scanner(System.in);
        Product[] products = new Product[20];
        System.out.println("Reading the list of products from the file \"products.txt\"");
        int size = readProducts(products, "products.txt");
        if (size == 0) {
            System.out.println("No products read.");
        } else {
            System.out.println("The list of products read successfully.");
            printProducts(products, size);

            System.out.println("\nApplying a 5% sale on books:");
            applySale(products, size, "Book", 0.05);
            printProducts(products, size);

            System.out.println("\nApplying a 10% sale on magazines:");
            applySale(products, size, "Magazine", 0.1);
            printProducts(products, size);

            System.out.println("\nSorting the products by price");
            sortProducts(products, size);
            printProducts(products, size);

            System.out.println("\nEnter the id of a product");
            Long id = keyboard.nextLong();
            try {
                checkID(id);
                int index = findProduct(products, size, id);
                if (index == -1) {
                    System.out.println("Product with id " + id + " not found.");
                } else {
                    System.out.println("Product found: " + products[index]);
                }
            } catch (Exception e) {
                System.out.println(e);
            }

            System.out.println("Exiting the program.");
        }
    }
    // reads from filename the product information and 
    // stores it as Book, Magazine, or Gift objects in the array list
    // read the file line by line. Split each line to get the product attributes
    public static int readProducts(Product[] list, String filename) {
        File file = new File(filename);
        int count = 0;
        try {
            String[] attributes = new String[6];
            Scanner scan = new Scanner(file);
            while (scan.hasNextLine()) {
                String line = scan.nextLine();
                attributes = line.split("\\:");
                if (attributes[0].equals("Book")) {
                    list[count] = new Book(Long.valueOf(attributes[1]), attributes[2], Double.parseDouble(attributes[3]), Integer.parseInt(attributes[4]), attributes[5]);
                }
                if (attributes[0].equals("Gift")) {
                    list[count] = new Gift(Long.valueOf(attributes[1]), attributes[2], Double.parseDouble(attributes[3]), Integer.parseInt(attributes[4]), attributes[5]);
                }
                if (attributes[0].equals("Magazine")) {
                    list[count] = new Magazine(Long.valueOf(attributes[1]), attributes[2], Double.parseDouble(attributes[3]), Integer.parseInt(attributes[4]), Integer.parseInt(attributes[5]));
                }
                count++;
            }
        } catch (FileNotFoundException e) {
            System.out.println(e);
        }
        return count;
    }

    // Method to reduce the price of the products of type by percent
    // Use the operator instanceof to know the type of an object in the array list
    public static void applySale(Product[] list, int size, String type, double percent) {
        for (int i = 0; i < size; i++) {
            if (list[i] instanceof Book && type.equals("Book")) {
                list[i].setPrice(list[i].getPrice() - (list[i].getPrice() * percent));
            }
            if (list[i] instanceof Magazine && type.equals("Magazine")) {
                list[i].setPrice(list[i].getPrice() - (list[i].getPrice() * percent));
            }
            if (list[i] instanceof Gift && type.equals("Gift")) {
                list[i].setPrice(list[i].getPrice() - (list[i].getPrice() * percent));
            }
        }
    }

    // Method to check the id. The method declares throwing an Exception
    // The method throws an Exception if the id does include 10 digits
    public static void checkID(Long id) throws Exception {
        if (id.toString().length() != 10) {
            throw new Exception("ID must be 10 digits");
        }
    }

    // method to search for a product using a given id
    public static int findProduct(Product[] list, int size, Long id) {
        for (int i = 0; i < size; i++) {
            if (list[i].getID() == id)
                return i;
        }
        return -1;
    }
    // Method to print the list of products in the array list
    // size is the effective number of products stored in the array list
    public static void printProducts(Product[] list, int size) {
        System.out.printf("%-10s\t%-10s\t%-20s\t%-5s\t%-10s\t%s\n", "Type", "ID", "Name", "Price", "Quantity", "ISBN/Issue/Category");
        for (int i = 0; i < size; i++) {
            System.out.println(list[i]);
        }
    }

    // Method to sort the products by price using the sort method from the class Arrays
    public static void sortProducts(Product[] list, int size) {
        java.util.Arrays.sort(list, 0, size);
    }

}