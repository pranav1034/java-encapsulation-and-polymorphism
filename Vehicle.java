// Abstract Class Vehicle
abstract class Vehicle {
    private String vehicleNumber;
    private String type;
    private double rentalRate;

    public Vehicle(String vehicleNumber, String type, double rentalRate) {
        this.vehicleNumber = vehicleNumber;
        this.type = type;
        this.rentalRate = rentalRate;
    }

    public String getVehicleNumber() { return vehicleNumber; }
    public String getType() { return type; }
    public double getRentalRate() { return rentalRate; }

    public abstract double calculateRentalCost(int days);

    public void displayDetails() {
        System.out.println("Vehicle Number: " + vehicleNumber + ", Type: " + type + ", Rental Rate: $" + rentalRate);
    }
}

// Interface Insurable
interface Insurable {
    double calculateInsurance();
    String getInsuranceDetails();
}

// Subclass: Car
class Car extends Vehicle implements Insurable {

    public Car(String vehicleNumber, double rentalRate) {
        super(vehicleNumber, "Car", rentalRate);
    }

    @Override
    public double calculateRentalCost(int days) {
        return days * getRentalRate();
    }

    @Override
    public double calculateInsurance() {
        return getRentalRate() * 0.10;
    }

    @Override
    public String getInsuranceDetails() {
        return "Car Insurance Policy: Confidential";
    }

    @Override
    public void displayDetails() {
        super.displayDetails();
    }
}

// Subclass: Bike
class Bike extends Vehicle {

    public Bike(String vehicleNumber, double rentalRate) {
        super(vehicleNumber, "Bike", rentalRate);
    }

    @Override
    public double calculateRentalCost(int days) {
        return days * getRentalRate();
    }

    @Override
    public void displayDetails() {
        super.displayDetails();
    }
}

// Subclass: Truck
class Truck extends Vehicle implements Insurable {

    public Truck(String vehicleNumber, double rentalRate) {
        super(vehicleNumber, "Truck", rentalRate);
    }

    @Override
    public double calculateRentalCost(int days) {
        return days * getRentalRate();
    }

    @Override
    public double calculateInsurance() {
        return getRentalRate() * 0.15;
    }

    @Override
    public String getInsuranceDetails() {
        return "Truck Insurance Policy: Confidential";
    }

    @Override
    public void displayDetails() {
        super.displayDetails();
    }

    public static void main(String[] args) {
        Vehicle car = new Car("CAR123", 50);
        Vehicle bike = new Bike("BIKE456", 20);
        Vehicle truck = new Truck("TRUCK789", 80);

        // Array of Vehicles
        Vehicle[] vehicles = { car, bike, truck };

        // Iterate and Display Details
        for (Vehicle v : vehicles) {
            v.displayDetails();
            System.out.println("Rental Cost for 5 days: $" + v.calculateRentalCost(5));

            if (v instanceof Insurable) {
                Insurable insurableVehicle = (Insurable) v;
                System.out.println("Insurance Cost: $" + insurableVehicle.calculateInsurance());
                System.out.println(insurableVehicle.getInsuranceDetails());
                System.out.println();
            }
        }
    }
}
