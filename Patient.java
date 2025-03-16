// Abstract class Patient
abstract class Patient {
    private String patientId;
    private String name;
    private int age;

    // Constructor
    public Patient(String patientId, String name, int age) {
        this.patientId = patientId;
        this.name = name;
        this.age = age;
    }

    // Concrete method
    public void getPatientDetails() {
        System.out.println("Patient ID: " + patientId);
        System.out.println("Name: " + name);
        System.out.println("Age: " + age);
    }

    // Abstract method
    public abstract double calculateBill();
}

// Interface for Medical Records
interface MedicalRecord {
    void addRecord(String record);
    void viewRecords();
}

// InPatient class (Extends Patient and Implements MedicalRecord)
class InPatient extends Patient implements MedicalRecord {
    private int daysAdmitted;
    private double dailyCharge;
    private String medicalHistory;

    // Constructor
    public InPatient(String patientId, String name, int age, int daysAdmitted, double dailyCharge) {
        super(patientId, name, age);
        this.daysAdmitted = daysAdmitted;
        this.dailyCharge = dailyCharge;
        this.medicalHistory = "";
    }

    // Overriding abstract method
    @Override
    public double calculateBill() {
        return daysAdmitted * dailyCharge;
    }

    // Implementing MedicalRecord methods
    @Override
    public void addRecord(String record) {
        medicalHistory += record + "\n";
    }

    @Override
    public void viewRecords() {
        System.out.println("Medical History: " + medicalHistory);
    }
}

// OutPatient class (Extends Patient and Implements MedicalRecord)
class OutPatient extends Patient implements MedicalRecord {
    private double consultationFee;
    private String diagnosis;

    // Constructor
    public OutPatient(String patientId, String name, int age, double consultationFee,String diagnosis) {
        super(patientId, name, age);
        this.consultationFee = consultationFee;
        this.diagnosis = diagnosis;
    }

    // Overriding abstract method
    @Override
    public double calculateBill() {
        return consultationFee;
    }

    // Implementing MedicalRecord methods
    @Override
    public void addRecord(String record) {
        diagnosis = record;
    }

    @Override
    public void viewRecords() {
        System.out.println("Diagnosis: " + diagnosis);
    }

    public static void main(String[] args) {
        // Using polymorphism
        Patient inPatient = new InPatient("P1", "Pranav", 30, 5, 2000);
        Patient outPatient = new OutPatient("P2", "Nikhil", 25, 700,"Fever");

        // Using MedicalRecord interface reference
        MedicalRecord record1 = (MedicalRecord) inPatient;
        record1.addRecord("Admitted for surgery.");

        MedicalRecord record2 = (MedicalRecord) outPatient;
        record2.addRecord("Diagnosed with fever");
        // Display patient details and bill
        inPatient.getPatientDetails();
        System.out.println("Total Bill: $" + inPatient.calculateBill());
        record1.viewRecords();
        System.out.println();

        outPatient.getPatientDetails();
        System.out.println("Total Bill: $" + outPatient.calculateBill());
        record2.viewRecords();
        System.out.println();


    }
}
