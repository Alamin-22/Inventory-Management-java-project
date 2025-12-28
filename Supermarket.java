import java.util.Scanner;

public class Supermarket {

    // this is my global storage ,, later I might replace this with actual db
    static Product[] inventory = new Product[100];
    static int productCount = 0;

    // this is also global scanner so that i dont need to crete it again
    // and the static keyword works as a global keyword here
    static Scanner scanner = new Scanner(System.in);

    public static void main(String args[]) {

        boolean isRunning = true;

        while (isRunning) {

            System.out.println("         Inventory management System       ");
            System.out.println("1. [Admin] Add New Product");
            System.out.println("2. [Admin] View Inventory");
            System.out.println("3. [User]  Checkout");
            System.out.println("4. Exit");
            System.out.print("Select Option: ");

            int choice = 0;

            /*
             * very important thing, before taking any input in java we need to be very
             * careful about the input , because in java when you type anything and then hit
             * entre it also inject a new line for that enter . So we must need to omit that
             * new line(\n) using scanner.nextLine() after taking the input.
             * 
             */
            if (scanner.hasNextInt()) { // here hasNextInt checks is the input contains valid integer input or not
                choice = scanner.nextInt();
                scanner.nextLine(); // and this omit the new line here
            } else {
                scanner.nextLine();
                System.out.println(" Please enter a number.");
                continue;
            }

            // this acts as my api routes
            switch (choice) {
                case 1:
                    addNewProduct();
                    break;
                case 2:
                    // viewInventory();
                    break;
                case 3:
                    System.out.println(" Billing System is Under Construction (Coming Day 2)");
                    break;
                case 4:
                    isRunning = false;
                    System.out.println("Exiting System... Goodbye!");
                    break;
                default:
                    System.out.println("❌ Invalid Option. Try again.");
            }

        }

    }

    // now these are my service layer style function

    public static void addNewProduct() {

        System.out.println("add new product");

        if (productCount >= inventory.length) {
            System.out.println("Storage is full. make sure to update the capacity of static array");
            return;
        }

        System.out.println("Product Name => ");
        String name = scanner.nextLine();

        System.out.println("Product SKU => ");
        String sku = scanner.nextLine();

        System.out.println("Product price => ");
        double price = scanner.nextInt();

        System.out.println("Product quantity => ");
        int quantity = scanner.nextInt();

        Product newProduct = new Product(name, price, sku, quantity);

        inventory[productCount] = newProduct;
        productCount++;
    }

}
