package pro.sky.Employee;

import org.springframework.stereotype.Service;
import pro.sky.Employee.Exception.EmployeeAlreadyAddedException;
import pro.sky.Employee.Exception.EmployeeNotFoundException;
import pro.sky.Employee.Exception.EmployeeStorageIsFullException;
import pro.sky.Employee.Exception.WrongFormatException;

import javax.annotation.PostConstruct;
import java.util.*;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    private final String simbols = "абвгдеёжзийклмнопрстуфхцчшщъыьэюяАБВГДЕЁЖЗИЙКЛМНОПРСТУФХЦЧШЩЪЫЬЭЮЯ";

    private final int maxEmployee = 99;

    private final Map<String, Employee> employees = new HashMap<>();
    @PostConstruct
    private void init() {
        addEmployee("Иванов", "Иван", 2, 50_000);
        addEmployee("Леонов", "Никита", 3, 45_000);
        addEmployee("Степанов", "Алексей", 1, 60_000);
        addEmployee("Семёнов", "Ярослав", 3, 55_000);
        addEmployee("Максимов", "Николай", 4, 49_000);
        addEmployee("Степанов", "Ермак", 1, 62_000);
        addEmployee("Морозов", "Василий", 5, 59_000);
        addEmployee("Михайлов", "Артур", 2, 44_000);
        addEmployee("Кешелев", "Константин", 4, 63_000);
        addEmployee("Тихонов", "Вадим", 5, 53_000);
    }

    private String buildKey(String lastName, String firstName) {
        return lastName + firstName;
    }

    public void check(String lastName, String firstName, int department, double salary) {
        Employee employee = new Employee(lastName, firstName, department, salary);
        char[] a = lastName.toCharArray();
        char[] b = firstName.toCharArray();
        try {
            boolean check = employee.getLastName() == null || employee.getFirstName() == null;
        } catch (NullPointerException e) {
            System.out.println("Одно из полей не заполнено(проверьте поля фамилия/имя).");
        }
        for (char d : a) {
            try {
                boolean checkLastName = !simbols.contains(String.valueOf(d));
            } catch (WrongFormatException e) {
                System.out.println("Использован неподходящий символ(проверьте поля фамилия/имя).");
            }
        }
        for (char d : b) {
            try {
                boolean checkFirstName = !simbols.contains(String.valueOf(d));
            } catch (WrongFormatException e) {
                System.out.println("Использован неподходящий символ(проверьте поля фамилия/имя).");
            }
        }
    }

    @Override
    public Employee addEmployee(String lastName, String firstName, int department, double salary) {
        String key = buildKey(lastName, firstName);
        Employee employee = new Employee(lastName, firstName, department, salary);
        check(lastName, firstName, department, salary);
        if (employees.containsKey(key)) {
            throw new EmployeeAlreadyAddedException();
        }
        if (employees.size() >= maxEmployee) {
            throw new EmployeeStorageIsFullException();
        }
        employees.put(key, employee);
        return employee;
    }

    @Override
    public Employee removeEmployee(String lastName, String firstName) {
        String key = buildKey(lastName, firstName);
        if (!employees.containsKey(key)) {
            throw new EmployeeNotFoundException();
        }
        return employees.remove(key);
    }

    @Override
    public Employee findEmployee(String lastName, String firstName) {
        String key = buildKey(lastName, firstName);
        if (!employees.containsKey(key)) {
            throw new EmployeeNotFoundException();
        }
        return employees.get(key);
    }

    @Override
    public Collection<Employee> printList() {
        return employees.values();
    }
}