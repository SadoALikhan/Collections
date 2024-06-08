package pro.sky.Employee;

public interface EmployeeService {
    void addEmployee(String lastName, String firsName);

    void removeEmployee(String lastName, String firsName);

    Employee findEmployee(String lastName, String firsName);
}
