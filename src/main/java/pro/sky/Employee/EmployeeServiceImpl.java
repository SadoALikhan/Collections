package pro.sky.Employee;

import java.util.*;

public class EmployeeServiceImpl implements EmployeeService {
    List<Employee> employees = List.of(
            new Employee("Иванов", "Иван"),
            new Employee("Леонов", "Никита"),
            new Employee("Степанов", "Алексей"),
            new Employee("Семёнов", "Ярослав"),
            new Employee("Максимов", "Николая")
    );
}