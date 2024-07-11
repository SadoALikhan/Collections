import org.springframework.stereotype.Service;
import pro.sky.Employee.Employee;
import pro.sky.Employee.EmployeeService;
import pro.sky.Employee.Exception.EmployeeNotFoundException;

import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import static java.util.Comparator.comparingDouble;
import static java.util.stream.Collectors.groupingBy;

@Service
public class NewEmployeeServiceImpl {

    private final EmployeeService employeeService;

    public NewEmployeeServiceImpl(EmployeeService employeeServiceImpl) {
        this.employeeService = employeeServiceImpl;
    }

    public Employee minSalary(int department) {
        return employeeService.printList().stream()
                .filter(e -> e.getDepartment() == department)
                .min(comparingDouble(Employee::getSalary))
                .orElseThrow(EmployeeNotFoundException::new);
    }

    public Employee maxSalary(int department) {
        return employeeService.printList().stream()
                .filter(e -> e.getDepartment() == department)
                .max(comparingDouble(Employee::getSalary))
                .orElseThrow(EmployeeNotFoundException::new);
    }

    public Collection<Employee> employeesDepartment(int department) {
        return employeeService.printList().stream()
                .filter(e -> e.getDepartment() == department)
                .collect(Collectors.toList());
    }

    public Map<Integer, List<Employee>> allEmployeesDepartments() {
        return employeeService.printList().stream()
                .collect(groupingBy(Employee::getDepartment));
    }
}
