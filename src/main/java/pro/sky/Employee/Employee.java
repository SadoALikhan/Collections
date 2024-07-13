package pro.sky.Employee;

import java.util.Objects;

public class Employee {
    private final String lastName;
    private final String firstName;
    private final int department;
    private final double salary;

    public Employee(String lastName, String firstName, int department, double salary) {
        this.lastName = lastName;
        this.firstName = firstName;
        this.department = department;
        this.salary = salary;
    }

    public String getLastName() {
        return lastName;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getFullName() {
        return lastName + " " + firstName;
    }

    public int getDepartment() {
        return department;
    }

    public double getSalary() {
        return salary;
    }

    @Override
    public String toString() {
        return "lastName: " + lastName +
                ", firstName: " + firstName +
                ", department: '" + department +
                ", salary: " + salary;
    }

    @Override
    public boolean equals(Object other) {
        if (this.getClass() != other.getClass()) {
            return false;
        }
        Employee employee = (Employee) other;
        return Objects.equals(firstName, employee.firstName)
                && Objects.equals(lastName, employee.lastName)
                && Objects.equals(department, employee.department)
                && Objects.equals(salary, employee.salary);
    }

    @Override
    public int hashCode() {
        return java.util.Objects.hash(lastName);
    }
}

