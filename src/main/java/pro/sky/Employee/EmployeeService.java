package pro.sky.Employee;

import org.springframework.stereotype.Service;
import pro.sky.Employee.Exception.EmployeeAlreadyAddedException;
import pro.sky.Employee.Exception.EmployeeNotFoundException;
import pro.sky.Employee.Exception.EmployeeStorageIsFullException;
import pro.sky.Employee.Exception.WrongFormatException;

import java.util.*;

@Service
public class EmployeeService {

    public String simbols = "абвгдеёжзийклмнопрстуфхцчшщъыьэюяАБВГДЕЁЖЗИЙКЛМНОПРСТУФХЦЧШЩЪЫЬЭЮЯ";

    private final int maxEmployee = 99;
    private Map<String, Employee> employees = new HashMap<>(Map.of(
            "Иванов Иван", new Employee("Иванов", "Иван"),
            "Леонов Никита", new Employee("Леонов", "Никита"),
            "Степанов Алексей", new Employee("Степанов", "Алексей"),
            "Семёнов Ярослав", new Employee("Семёнов", "Ярослав"),
            "Максимов Николай", new Employee("Максимов", "Николай"),
            "Степанов Ермак", new Employee("Степанов", "Ермак"),
            "Морозов Василий", new Employee("Морозов", "Василий"),
            "Михайлов Артур", new Employee("Михайлов", "Артур"),
            "Кешелев Константин", new Employee("Кешелев", "Константин"),
            "Тихонов Вадим", new Employee("Тихонов", "Вадим")
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
        } else if (employees.containsKey(employee.getFullName())) {
            throw new EmployeeAlreadyAddedException();
        } else {
            employees.put(employee.getFullName(), employee);
        }
    }

    public void removeEmployee(String lastName, String firsName) {
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
        if (!employees.containsKey(employee.getFullName())) {
            throw new EmployeeNotFoundException();
        } else {
            employees.remove(employee.getFullName());
        }
    }

    public Employee findEmployee(String lastName, String firsName) {
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
        if (!employees.containsKey(employee.getFullName())) {
            throw new EmployeeNotFoundException();
        }
        return employees.get(employee.getFullName());
    }

    public Collection<Employee> printList() {
        return employees.values();
    }
}