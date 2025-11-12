import java.util.*;
import java.util.stream.*;

class Employee {
    private String name;
    private int salary;

    // Constructor
    public Employee(String name, int salary) {
        this.name = name;
        this.salary = salary;
    }

    // Getters
    public String getName() {
        return name;
    }

    public int getSalary() {
        return salary;
    }

    // toString (for easy printing)
    @Override
    public String toString() {
        return name + " - ₹" + salary;
    }
}

public class Main {
    public static void main(String[] args) {
        List<Employee> employees = Arrays.asList(
            new Employee("Krishna", 50000),
            new Employee("Ravi", 65000),
            new Employee("Anjali", 70000),
            new Employee("Sita", 60000)
        );

        // TODO: Your stream logic here
    }
}
