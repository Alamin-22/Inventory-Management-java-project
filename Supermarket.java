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

            System.out.println("\n \n ===============Inventory management System=============");
            System.out.println("1. [Admin] Add New Product");
            System.out.println("2. [Admin] View Inventory");
            System.out.println("3. [User]  Checkout");
            System.out.println("4. Exit");
            System.out.print("Select Option => ");

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
                    viewInventory();
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

        System.out.println("\n --------------Add new product-------------- \n");

        if (productCount >= inventory.length) {
            System.out.println("Storage is full. make sure to update the capacity of static array \n");
            return;
        }

        System.out.print("Product Name => ");
        String name = scanner.nextLine();

        System.out.print("Product SKU => ");
        String sku = scanner.nextLine();

        System.out.print("Product price => ");
        double price = scanner.nextDouble();

        System.out.print("Product quantity => ");
        int quantity = scanner.nextInt();

        Product newProduct = new Product(name, price, sku, quantity);

        inventory[productCount] = newProduct;
        productCount++;
    }

    public static void viewInventory() {
        System.out.println("\n---------------------  current inventory ------------------- \n");

        if (productCount == 0) {
            System.out.println(" Inventory is empty. Please add products. \n");
            return;
        }

        // Header for the table
        /*
         * here we are using printf means print formatter using this we are basically
         * creating kind of table header
         * % means stat command
         * - means left align
         * 5s,10s,15s and so on,,, means those empty character . It just create a width
         */
        System.out.printf("%-2s | %-20s | %-30s | %-20s | %-5s\n", "ID", "SKU", "Name", "Price", "Stock");
        System.out.println("----------------------------------------------------------");

        for (int i = 0; i < productCount; i++) {
            Product p = inventory[i];
            System.out.printf("%-5d | %-10s | %-15s | %-9.2f Tk | %-5d\n",
                    p.getId(), p.getSku(), p.getName(), p.getPrice(), p.getStockQuantity());
        }
    }

}
