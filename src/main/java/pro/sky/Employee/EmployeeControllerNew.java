package pro.sky.Employee;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/departments")
public class EmployeeControllerNew {
    private final NewEmployeeServiceImpl employeeService;

    public EmployeeControllerNew(NewEmployeeServiceImpl employeeService) {
        this.employeeService = employeeService;
    }

    @GetMapping("/max-salary")
    public String minSalaryDepartment(@RequestParam("department") int department) {
        employeeService.
    }
}
