package com.example.homework.Service;

import com.example.homework.Employee;
import org.springframework.stereotype.Service;

import java.util.Comparator;
import java.util.stream.Stream;

@Service
public class DepartmentService {
    private final EmployeeService employeeService;

    public DepartmentService(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    public Employee maxSalary(int department) {
        return employeeService.getEmployees().stream()
                .filter(e->e.getDepartmentId()==department)
                .max(Comparator.comparingInt(Employee::getSalary))
                .orElse(null);
    }

    public Employee minSalary(int department) {
        return employeeService.getEmployees().stream()
                .filter(employee->employee.getDepartmentId()==department)
                .min(Comparator.comparingInt(Employee::getSalary))
                .orElse(null);
    }

   public Stream<Employee> departmentAll(int department) {
       return employeeService.getEmployees().stream()
               .filter(employee->employee.getDepartmentId()==department);
   }
   public Stream<Employee>all() {
        return employeeService.getEmployees().stream()
                .sorted(Comparator.comparing(Employee::getDepartmentId));
   }
}
