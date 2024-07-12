package pro.sky.Employee;

import org.springframework.stereotype.Service;
import pro.sky.Employee.Exception.EmployeeAlreadyAddedException;
import pro.sky.Employee.Exception.EmployeeNotFoundException;
import pro.sky.Employee.Exception.EmployeeStorageIsFullException;
import pro.sky.Employee.Exception.WrongFormatException;

import java.util.*;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    private final String simbols = "абвгдеёжзийклмнопрстуфхцчшщъыьэюяАБВГДЕЁЖЗИЙКЛМНОПРСТУФХЦЧШЩЪЫЬЭЮЯ";

    private final int maxEmployee = 99;
    private final Map<String, Employee> employees = new HashMap<>(Map.of(
            "Иванов Иван", new Employee("Иванов", "Иван", 2, 50_000),
            "Леонов Никита", new Employee("Леонов", "Никита", 3, 45_000),
            "Степанов Алексей", new Employee("Степанов", "Алексей", 1, 60_000),
            "Семёнов Ярослав", new Employee("Семёнов", "Ярослав", 3, 55_000),
            "Максимов Николай", new Employee("Максимов", "Николай", 4, 49_000),
            "Степанов Ермак", new Employee("Степанов", "Ермак", 1, 62_000),
            "Морозов Василий", new Employee("Морозов", "Василий", 5, 59_000),
            "Михайлов Артур", new Employee("Михайлов", "Артур", 2, 44_000),
            "Кешелев Константин", new Employee("Кешелев", "Константин", 4, 63_000),
            "Тихонов Вадим", new Employee("Тихонов", "Вадим", 5, 53_000)
    ));

    @Override
    public void addEmployee(String lastName, String firstName) {
        int department = 0;
        double salary = 0;
        Employee employee = new Employee(lastName, firstName, department, salary);
        char[] a = lastName.toCharArray();
        char[] b = firstName.toCharArray();
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
        } else if (employees.containsKey(employee.getFullName())) {
            throw new EmployeeAlreadyAddedException();
        } else {
            employees.put(employee.getFullName(), employee);
        }
    }

    @Override
    public void removeEmployee(String lastName, String firstName) {
        int department = 0;
        double salary = 0;
        Employee employee = new Employee(lastName, firstName, department, salary);
        char[] a = lastName.toCharArray();
        char[] b = firstName.toCharArray();
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
        if (!employees.containsKey(employee.getFullName())) {
            throw new EmployeeNotFoundException();
        } else {
            employees.remove(employee.getFullName());
        }
    }

    @Override
    public Employee findEmployee(String lastName, String firstName) {
        int department = 0;
        double salary = 0;
        Employee employee = new Employee(lastName, firstName, department, salary);
        char[] a = lastName.toCharArray();
        char[] b = firstName.toCharArray();
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
        if (!employees.containsKey(employee.getFullName())) {
            throw new EmployeeNotFoundException();
        }
        return employees.get(employee.getFullName());
    }

    @Override
    public Collection<Employee> printList() {
        return employees.values();
    }
}