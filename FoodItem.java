// Abstract Class
abstract class FoodItem {
    private String itemName;
    private double price;
    private int quantity;

    // Constructor
    public FoodItem(String itemName, double price, int quantity) {
        this.itemName = itemName;
        this.price = price;
        this.quantity = quantity;
    }

    // Abstract Method
    public abstract double calculateTotalPrice();

    // Concrete Method
    public void getItemDetails() {
        System.out.println("Item: " + itemName + ", Price: $" + price + ", Quantity: " + quantity);
    }

    // Getters
    public double getPrice() {
        return price;
    }

    public int getQuantity() {
        return quantity;
    }
}

// Interface
interface Discountable {
    double applyDiscount();
    void getDiscountDetails();
}

// Subclass for Veg Items
class VegItem extends FoodItem implements Discountable {
    public VegItem(String itemName, double price, int quantity) {
        super(itemName, price, quantity);
    }

    // Implementing abstract method
    @Override
    public double calculateTotalPrice() {
        return getPrice() * getQuantity();  // No extra charge for veg items
    }

    // Implementing interface methods
    @Override
    public double applyDiscount() {
        return calculateTotalPrice() * 0.10; // 10% discount on veg items
    }

    @Override
    public void getDiscountDetails() {
        System.out.println("Veg Item Discount: 10%");
    }
}

// Subclass for Non-Veg Items
class NonVegItem extends FoodItem implements Discountable {
    private static final double ADDITIONAL_CHARGE = 2.0;  // Extra charge for non-veg items

    public NonVegItem(String itemName, double price, int quantity) {
        super(itemName, price, quantity);
    }

    @Override
    public double calculateTotalPrice() {
        return (getPrice() + ADDITIONAL_CHARGE) * getQuantity(); // Extra charge per item
    }

    @Override
    public double applyDiscount() {
        return calculateTotalPrice() * 0.05; // 5% discount on non-veg items
    }

    @Override
    public void getDiscountDetails() {
        System.out.println("Non-Veg Item Discount: 5%");
    }

    public static void main(String[] args) {
        FoodItem item1 = new VegItem("Paneer", 9.0, 3);
        FoodItem item2 = new NonVegItem("Chicken", 15.0, 2);

        processOrder(item1);
        processOrder(item2);
    }

    // Polymorphism: Process different types of food items
    public static void processOrder(FoodItem item) {
        item.getItemDetails();
        System.out.println("Total Price: $" + item.calculateTotalPrice());

        if (item instanceof Discountable) {
            Discountable discountable = (Discountable) item;
            System.out.println("Discount Applied: $" + discountable.applyDiscount());
            discountable.getDiscountDetails();
            System.out.println();
        }
    }
}
