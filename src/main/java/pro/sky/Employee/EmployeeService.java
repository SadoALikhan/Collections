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
        if (!employees.contains(employee)) {
            throw new EmployeeNotFoundException();
        } else {
            employee.getLastName().toUpperCase();
            employee.getFirstName().toUpperCase();
            employees.remove(employee);
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
        if (!employees.contains(employee)) {
            throw new EmployeeNotFoundException();
        }
        employee.getLastName().toUpperCase();
        employee.getFirstName().toUpperCase();
        return employee;
    }
}