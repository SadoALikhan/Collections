package pro.sky.Employee;

import java.util.Collection;

public interface EmployeeService {
    Employee addEmployee(String lastName, String firstName, int department, double salary);

    Employee removeEmployee(String lastName, String firstName);

    Employee findEmployee(String lastName, String firstName);

    Collection<Employee> getEmployees();
}
