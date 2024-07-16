package pro.sky.Employee;

import java.util.Collection;
import java.util.List;
import java.util.Map;

public interface DepartmentService {
    Employee minSalary(int department);

    Employee maxSalary(int department);

    Collection<Employee> employeesDepartment(int department);

    Map<Integer, List<Employee>> allEmployeesDepartments();
}
