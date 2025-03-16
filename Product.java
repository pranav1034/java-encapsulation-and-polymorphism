// Abstract Class Product
abstract class Product {
    private int productId;
    private String name;
    private double price;

    public Product(int productId, String name, double price) {
        this.productId = productId;
        this.name = name;
        this.price = price;
    }

    public int getProductId() { return productId; }
    public String getName() { return name; }
    public double getPrice() { return price; }

    public void setPrice(double price) { this.price = price; }

    public abstract double calculateDiscount();

    public void displayInfo() {
        System.out.println("Product ID: " + productId + ", Name: " + name + ", Price: $" + price);
    }
}

// Interface Taxable
interface Taxable {
    double calculateTax();
    String getTaxDetails();
}

// Subclass: Electronics
class Electronics extends Product implements Taxable {

    public Electronics(int productId, String name, double price) {
        super(productId, name, price);
    }

    @Override
    public double calculateDiscount() {
        return getPrice() * 0.10;
    }

    @Override
    public double calculateTax() {
        return getPrice() * 0.15;
    }

    @Override
    public String getTaxDetails() {
        return "15% GST applied on Electronics.";
    }

    @Override
    public void displayInfo() {
        super.displayInfo();
    }
}

// Subclass: Clothing
class Clothing extends Product implements Taxable {

    public Clothing(int productId, String name, double price) {
        super(productId, name, price);
    }

    @Override
    public double calculateDiscount() {
        return getPrice() * 0.20;
    }

    @Override
    public double calculateTax() {
        return getPrice() * 0.08;
    }

    @Override
    public String getTaxDetails() {
        return "8% Sales Tax applied on Clothing.";
    }

    @Override
    public void displayInfo() {
        super.displayInfo();
    }
}

// Subclass: Groceries (No Tax)
class Groceries extends Product {

    public Groceries(int productId, String name, double price) {
        super(productId, name, price);
    }

    @Override
    public double calculateDiscount() {
        return getPrice() * 0.05;
    }

    @Override
    public void displayInfo() {
        super.displayInfo();
    }

    public static void main(String[] args) {
        // Creating individual objects and displaying info
        Electronics e = new Electronics(1, "Laptop", 1000);
        e.displayInfo();
        System.out.println("Discount: $" + e.calculateDiscount());
        System.out.println("Tax: $" + e.calculateTax());
        System.out.println("Final Price: $" + (e.getPrice() + e.calculateTax() - e.calculateDiscount()));
        System.out.println();

        Clothing c = new Clothing(2, "Jeans", 40);
        c.displayInfo();
        System.out.println("Discount: $" + c.calculateDiscount());
        System.out.println("Tax: $" + c.calculateTax());
        System.out.println("Final Price: $" + (c.getPrice() + c.calculateTax() - c.calculateDiscount()));
        System.out.println();

        Groceries g = new Groceries(303, "Cereals", 5);
        g.displayInfo();
        System.out.println("Discount: $" + g.calculateDiscount());
        System.out.println("Tax: No tax on groceries");
        System.out.println("Final Price: $" + (g.getPrice() - g.calculateDiscount()));
        System.out.println();
    }
}
