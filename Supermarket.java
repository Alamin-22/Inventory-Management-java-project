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

            switch (args) {
                case value:

                    break;

                default:
                    break;
            }

        }

    }

}
