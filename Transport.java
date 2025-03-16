// Abstract Class Transport (Renamed from Vehicle)
abstract class Transport implements GPS {
    private String transportId;
    private String driverName;
    protected double ratePerKm;
    private String location;

    public Transport(String transportId, String driverName, double ratePerKm) {
        this.transportId = transportId;
        this.driverName = driverName;
        this.ratePerKm = ratePerKm;
        this.location = "Unknown"; // Default location
    }

    // Abstract method for fare calculation
    public abstract double calculateFare(double distance);

    // Concrete method to display vehicle details
    public void getTransportDetails() {
        System.out.println("Transport ID: " + transportId);
        System.out.println("Driver Name: " + driverName);
        System.out.println("Rate per Km: $" + ratePerKm);
        System.out.println("Current Location: " + location);
    }

    // Implement GPS interface methods
    @Override
    public String getCurrentLocation() {
        return location;
    }

    @Override
    public void updateLocation(String newLocation) {
        this.location = newLocation;
        System.out.println("Updated Location: " + newLocation);
    }
}

// Interface GPS
interface GPS {
    String getCurrentLocation();
    void updateLocation(String newLocation);
}

// Subclass: Car
class Car2 extends Transport {
    public Car2(String transportId, String driverName) {
        super(transportId, driverName, 10.0); // Car rate per Km
    }

    @Override
    public double calculateFare(double distance) {
        return distance * ratePerKm;
    }
}

// Subclass: Bike
class Bike2 extends Transport {
    public Bike2(String transportId, String driverName) {
        super(transportId, driverName, 5.0); // Bike rate per Km
    }

    @Override
    public double calculateFare(double distance) {
        return distance * ratePerKm;
    }
}

// Subclass: Auto
class Auto extends Transport {
    public Auto(String transportId, String driverName) {
        super(transportId, driverName, 7.0); // Auto rate per Km
    }

    @Override
    public double calculateFare(double distance) {
        return distance * ratePerKm;
    }

    public static void main(String[] args) {
        // Creating objects of different transport types
        Transport myCar = new Car2("C1", "Pranav");
        Transport myBike = new Bike2("B2", "Alice");
        Transport myAuto = new Auto("A3", "Arun");

        // Display transport details
        myCar.getTransportDetails();
        System.out.println("Fare for 15 km: $" + myCar.calculateFare(15));
        myCar.updateLocation("Home");

        System.out.println();

        myBike.getTransportDetails();
        System.out.println("Fare for 15 km: $" + myBike.calculateFare(15));
        myBike.updateLocation("College");

        System.out.println();

        myAuto.getTransportDetails();
        System.out.println("Fare for 15 km: $" + myAuto.calculateFare(15));
        myAuto.updateLocation("Mall");
    }
}
