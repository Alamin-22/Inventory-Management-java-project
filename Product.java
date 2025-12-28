
public class Product {

    private int id;
    private String name;
    private double price;
    private String productSKU;
    private int stockQuantity;

    private static int idCounter = 1;

    // this constructor acts as a createProduct function
    Product(int id, String name, double price, String productSKU, int stockQuantity) {
        this.id = idCounter;
        idCounter++;
        this.name = name;
        this.price = price;
        this.productSKU = productSKU;
        this.stockQuantity = stockQuantity;
    };

    public boolean sellProduct(int RequestedQuantity) {

        if (RequestedQuantity < 0) {
            System.out.println("RequestedQuantity Must be a Positive number");
            return false;
        }

        if (this.stockQuantity >= RequestedQuantity) {
            this.stockQuantity -= RequestedQuantity;
            return true;
        } else {

            System.out.println("We are sorry , insufficient Quantity");
            System.out.printf("Currently We have %d in stock but you demand %d ", this.stockQuantity,
                    RequestedQuantity);

            return false;

        }

    }

    public void getDetails() {
        System.out.printf("ID: %d | SKU: %s | Name: %s | Price: $%.2f | Stock: %d\n",
                id, productSKU, name, price, stockQuantity);
    }

    public int getId() {
        return id;
    }

    public String getSku() {
        return productSKU;
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }

    public int getStockQuantity() {
        return stockQuantity;
    }

}
