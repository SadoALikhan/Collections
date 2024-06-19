package pro.sky.Employee;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import pro.sky.Employee.Exception.EmployeeAlreadyAddedException;
import pro.sky.Employee.Exception.EmployeeNotFoundException;
import pro.sky.Employee.Exception.EmployeeStorageIsFullException;
import pro.sky.Employee.Exception.WrongFormatException;

import java.util.List;

@RestController
@RequestMapping("/employee")
public class EmployeeController {
    private final EmployeeService employeeService;

    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @GetMapping(path = "/add")
    public String add(@RequestParam(value = "lastName", required = false) String lastName,
                      @RequestParam(value = "firstName", required = false) String firstName) {
        try {
            employeeService.addEmployee(lastName, firstName);
            return "lastName: " + lastName + ", firstName: " + firstName;
        } catch ( NullPointerException e) {
            return "Одно из полей не заполнено(проверьте поля фамилия/имя).";
        } catch (WrongFormatException e) {
            return "Использован неподходящий символ(проверьте поля фамилия/имя).";
        } catch (EmployeeStorageIsFullException e) {
            return "Превышен лимит количества сотрудников в фирме.";
        } catch (EmployeeAlreadyAddedException e) {
            return "Сотрудник уже числится в списке.";
        }
    }

    @GetMapping(path = "/remove")
    public String remove(@RequestParam(value = "lastName", required = false) String lastName,
                         @RequestParam(value = "firstName", required = false) String firstName) {
        try {
            employeeService.removeEmployee(lastName, firstName);
            return "lastName: " + lastName + ", firstName: " + firstName;
        } catch (NullPointerException e) {
            return "Одно из полей не заполнено(проверьте поля фамилия/имя).";
        } catch (WrongFormatException e) {
            return "Использован неподходящий символ(проверьте поля фамилия/имя).";
        } catch (EmployeeNotFoundException e) {
            return "Сотрудник не найден.";
        }
    }

    @GetMapping(path = "/find")
    public String find(@RequestParam(value = "lastName", required = false) String lastName,
                       @RequestParam(value = "firstName", required = false) String firstName) {
        try {
            employeeService.findEmployee(lastName, firstName);
            return "lastName: " + lastName + ", firstName: " + firstName;
        } catch (NullPointerException e) {
            return "Одно из полей не заполнено(проверьте поля фамилия/имя).";
        } catch (WrongFormatException e) {
            return "Использован неподходящий символ(проверьте поля фамилия/имя).";
        } catch (EmployeeNotFoundException e) {
            return "Сотрудник не найден.";
        }
    }

    @GetMapping("/all")
    public List<Employee> print() {
        return employeeService.printList();
    }
}
