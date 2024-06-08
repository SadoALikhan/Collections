package pro.sky.Employee;

import pro.sky.Employee.Exception.EmployeeAlreadyAddedException;
import pro.sky.Employee.Exception.EmployeeNotFoundException;
import pro.sky.Employee.Exception.EmployeeStorageIsFullException;
import pro.sky.Employee.Exception.WrongFormatException;

import java.util.*;

public class EmployeeServiceImpl implements EmployeeService {

    public String simbols = "абвгдеёжзийклмнопрстуфхцчшщъыьэюяАБВГДЕЁЖЗИЙКЛМНОПРСТУФХЦЧШЩЪЫЬЭЮЯ";

    private final int maxEmployee = 11;
    private List<Employee> employees = new ArrayList<>(List.of(
            new Employee("Иванов", "Иван"),
            new Employee("Леонов", "Никита"),
            new Employee("Степанов", "Алексей"),
            new Employee("Семёнов", "Ярослав"),
            new Employee("Максимов", "Николай"),
            new Employee("Степанов", "Ермак"),
            new Employee("Морозов", "Василий"),
            new Employee("Михайлов", "Артур"),
            new Employee("Кешелев", "Константин"),
            new Employee("Тихонов", "Вадим")
    ));

    public void addEmployee(String lastName, String firsName) {
        Employee employee = new Employee(lastName, firsName);
        char[] a = lastName.toCharArray();
        char[] b = firsName.toCharArray();
        if (employee.getLastName() == null || employee.getFirstName() == null) {
            throw new NullPointerException();
        }
        for (char d : a) {
            if (!simbols.contains(String.valueOf(d))) {
                throw new WrongFormatException();
            }
        }
        for (char d : b) {
            if (!simbols.contains(String.valueOf(d))) {
                throw new WrongFormatException();
            }
        }
        if (employees.size() == maxEmployee) {
            throw new EmployeeStorageIsFullException();
        } else if (employees.contains(employee)) {
            throw new EmployeeAlreadyAddedException();
        } else {
            employee.getLastName().toUpperCase();
            employee.getFirstName().toUpperCase();
            employees.add(employee);
        }
    }

    public void removeEmployee(Employee employee) {
        if (!employees.contains(employee)) {
            throw new EmployeeNotFoundException();
        }
    }
}