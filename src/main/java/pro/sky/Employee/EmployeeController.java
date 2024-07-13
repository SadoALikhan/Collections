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
    public String add(@RequestParam("lastName") String lastName,
                      @RequestParam("firstName") String firstName,
                      @RequestParam("department") int department,
                      @RequestParam("salary") double salary) {
        Employee employee = employeeService.addEmployee(lastName, firstName, department, salary);
        return employee.toString();
    }

    @GetMapping(path = "/remove")
    public String remove(@RequestParam(value = "lastName", required = false) String lastName,
                           @RequestParam(value = "firstName", required = false) String firstName) {
        return employeeService.removeEmployee(lastName, firstName).toString();
    }

    @GetMapping(path = "/find")
    public String find(@RequestParam(value = "lastName", required = false) String lastName,
                         @RequestParam(value = "firstName", required = false) String firstName) {
        return employeeService.findEmployee(lastName, firstName).toString();
    }

    @GetMapping("/all")
    public Collection<Employee> print() {
        return employeeService.printList();
    }
}
