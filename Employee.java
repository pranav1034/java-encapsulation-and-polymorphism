import java.util.ArrayList;
import java.util.List;

// Abstract Class: Employee
abstract class Employee {
    private int employeeId;
    private String name;
    private double baseSalary;

    public Employee(int employeeId, String name, double baseSalary) {
        this.employeeId = employeeId;
        this.name = name;
        this.baseSalary = baseSalary;
    }

    public int getEmployeeId() {
        return employeeId;
    }

    public String getName() {
        return name;
    }

    public double getBaseSalary() {
        return baseSalary;
    }

    public void setBaseSalary(double baseSalary) {
        this.baseSalary = baseSalary;
    }

    // Abstract method (Implemented in subclasses)
    public abstract double calculateSalary();

    // Concrete method
    public void displayDetails() {
        System.out.println("Employee ID: " + employeeId);
        System.out.println("Name: " + name);
        System.out.println("Base Salary: $" + baseSalary);
        System.out.println("Final Salary: $" + calculateSalary());
    }
}

// Interface: Department
interface Department {
    void assignDepartment(String departmentName);
    String getDepartmentDetails();
}

// Subclass: FullTimeEmployee
class FullTimeEmployee extends Employee implements Department {
    private String department;
    private double fixedSalary;

    public FullTimeEmployee(int employeeId, String name, double baseSalary, double fixedSalary) {
        super(employeeId, name, baseSalary);
        this.fixedSalary=fixedSalary;
    }

    @Override
    public double calculateSalary() {
        return getBaseSalary() + fixedSalary;
    }

    @Override
    public void assignDepartment(String departmentName) {
        this.department = departmentName;
    }

    @Override
    public String getDepartmentDetails() {
        return "Department: " + department;
    }
}

// Subclass: PartTimeEmployee
class PartTimeEmployee extends Employee implements Department {
    private String department;
    private int workHours;
    private double hourlyRate;

    public PartTimeEmployee(int employeeId, String name, double baseSalary, int workHours, double hourlyRate) {
        super(employeeId, name, baseSalary);
        this.workHours = workHours;
        this.hourlyRate = hourlyRate;
    }

    @Override
    public double calculateSalary() {
        return getBaseSalary() + (workHours * hourlyRate);
    }

    @Override
    public void assignDepartment(String departmentName) {
        this.department = departmentName;
    }

    @Override
    public String getDepartmentDetails() {
        return "Department: " + department;
    }

    public static void main(String[] args) {
        // Creating a list of Employee references
        List<Employee> employees = new ArrayList<>();

        // Adding FullTime and PartTime Employees
        FullTimeEmployee emp1 = new FullTimeEmployee(101, "Pranav", 30000, 20000);
        emp1.assignDepartment("HR");

        PartTimeEmployee emp2 = new PartTimeEmployee(102, "Bob", 30000, 20, 500);
        emp2.assignDepartment("IT");

        employees.add(emp1);
        employees.add(emp2);

        // Processing employees using polymorphism
        System.out.println("Employee Details: ");
        for (Employee emp : employees) {
            emp.displayDetails();
            if (emp instanceof Department) {
                System.out.println(((Department) emp).getDepartmentDetails());
                System.out.println();
            }
        }
    }
}
