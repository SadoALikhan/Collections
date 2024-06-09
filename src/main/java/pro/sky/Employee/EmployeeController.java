package pro.sky.Employee;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import pro.sky.Employee.Exception.EmployeeAlreadyAddedException;
import pro.sky.Employee.Exception.EmployeeNotFoundException;
import pro.sky.Employee.Exception.EmployeeStorageIsFullException;
import pro.sky.Employee.Exception.WrongFormatException;

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
        employeeService.addEmployee(lastName, firstName);
        try {
            employeeService.addEmployee(lastName, firstName);
        } catch (NullPointerException e) {
            System.out.println("Одно из полей не заполнено(проверьте поля фамилия/имя).");
        } catch (WrongFormatException e) {
            System.out.println("Использован неподходящий символ(проверьте поля фамилия/имя).");
        } catch (EmployeeStorageIsFullException e) {
            System.out.println("Превышен лимит количества сотрудников в фирме.");
        } catch (EmployeeAlreadyAddedException e) {
            System.out.println("Сотрудник уже числится в списке.");
        }
        return "lastName: " + lastName.toUpperCase() + ", firstName: " + firstName.toUpperCase();
    }

    @GetMapping(path = "/remove")
    public String remove(@RequestParam(value = "lastName", required = false) String lastName,
                         @RequestParam(value = "firstName", required = false) String firstName) {
        employeeService.removeEmployee(lastName, firstName);
        try {
            employeeService.removeEmployee(lastName, firstName);
        } catch (NullPointerException e) {
            System.out.println("Одно из полей не заполнено(проверьте поля фамилия/имя).");
        } catch (WrongFormatException e) {
            System.out.println("Использован неподходящий символ(проверьте поля фамилия/имя).");
        } catch (EmployeeNotFoundException e) {
            System.out.println("Сотрудник не найден.");
        }
        return "lastName: " + lastName.toUpperCase() + ", firstName: " + firstName.toUpperCase();
    }

    @GetMapping(path = "/find")
    public String find(@RequestParam(value = "lastName", required = false) String lastName,
                       @RequestParam(value = "firstName", required = false) String firstName) {
        employeeService.findEmployee(lastName, firstName);
        try {
            employeeService.findEmployee(lastName, firstName);
        } catch (NullPointerException e) {
            System.out.println("Одно из полей не заполнено(проверьте поля фамилия/имя).");
        } catch (WrongFormatException e) {
            System.out.println("Использован неподходящий символ(проверьте поля фамилия/имя).");
        } catch (EmployeeNotFoundException e) {
            System.out.println("Сотрудник не найден.");
        }
        return "lastName: " + lastName.toUpperCase() + ", firstName: " + firstName.toUpperCase();
    }
}
