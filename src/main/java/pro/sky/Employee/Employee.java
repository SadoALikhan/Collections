package pro.sky.Employee;

public class Employee {
    private final String lastName;
    private final String firstName;

    public Employee(String lastName, String firstName) {
        this.lastName = lastName;
        this.firstName = firstName;
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

    @Override
    public String toString() {
        return lastName + firstName;
    }

    @Override
    public boolean equals(Object other) {
        if (this.getClass() != other.getClass()) {
            return false;
        }
        Employee employee = (Employee) other;
        return lastName.equals(employee.lastName) && firstName.equals(employee.firstName);
    }

    @Override
    public int hashCode() {
        return java.util.Objects.hash(lastName);
    }
}

