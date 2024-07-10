package pro.sky.Employee;

import java.util.Collection;

public interface EmployeeService {
    void addEmployee(String lastName, String firstName);

    void removeEmployee(String lastName, String firstName);

    Employee findEmployee(String lastName, String firstName);

    Collection<Employee> printList();
}
