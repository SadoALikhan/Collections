package pro.sky.Employee;

import org.springframework.web.bind.annotation.*;
import pro.sky.Employee.Exception.EmployeeAlreadyAddedException;
import pro.sky.Employee.Exception.EmployeeNotFoundException;
import pro.sky.Employee.Exception.EmployeeStorageIsFullException;
import pro.sky.Employee.Exception.WrongFormatException;

import java.util.Collection;

@RestController
@RequestMapping("/employee")
public class EmployeeController {
    private final EmployeeService employeeService;

    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @GetMapping(path = "/add")
    public Employee add(@RequestParam(value = "lastName", required = false) String lastName,
                        @RequestParam(value = "firstName", required = false) String firstName,
                        @RequestParam int department,
                        @RequestParam double salary) {
        return employeeService.addEmployee(lastName, firstName, department, salary);
    }

    @GetMapping(path = "/remove")
    public Employee remove(@RequestParam(value = "lastName", required = false) String lastName,
                         @RequestParam(value = "firstName", required = false) String firstName) {
        return employeeService.removeEmployee(lastName, firstName);
    }

    @GetMapping(path = "/find")
    public Employee find(@RequestParam(value = "lastName", required = false) String lastName,
                       @RequestParam(value = "firstName", required = false) String firstName) {
        return employeeService.findEmployee(lastName, firstName);
    }

    @GetMapping("/all")
    public Collection<Employee> print() {
        return employeeService.printList();
    }
}
