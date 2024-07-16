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

    private void checkName(String name) {
        if ("".equals(name)) {
            throw new WrongFormatException("Одно из полей не заполнено(проверьте поля фамилия/имя).");
        }
        for (char d : name.toCharArray()) {
            boolean checkName = !simbols.contains(String.valueOf(d));
            if (checkName) {
                throw new WrongFormatException("Использован неподходящий символ(проверьте поля фамилия/имя).");
            }
        }
    }

    public void check(String lastName, String firstName, int department, double salary) {
        if (salary < 0) {
            throw new WrongFormatException("ЗП не может быть отрицательной");
        }
        if (department < 1 || department > 6) {
            throw new WrongFormatException("департамент должен быть от 1 до 5");
        }
        checkName(lastName);
        checkName(firstName);
    }

    @Override
    public Employee addEmployee(String lastName, String firstName, int department, double salary) {
        check(lastName, firstName, department, salary);
        String key = buildKey(lastName, firstName);
        if (employees.containsKey(key)) {
            throw new EmployeeAlreadyAddedException();
        }
        if (employees.size() >= maxEmployee) {
            throw new EmployeeStorageIsFullException();
        }
        Employee employee = new Employee(lastName, firstName, department, salary);
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
    public Collection<Employee> getEmployees() {
        return employees.values();
    }
}