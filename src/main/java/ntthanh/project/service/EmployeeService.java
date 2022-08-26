package ntthanh.project.service;

import ntthanh.project.dto.DtoEmployee;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import ntthanh.project.entity.Employee;


public interface EmployeeService {
    Page<Employee> finAll(Pageable pageable);
    Employee findById(String id);
    void saveEmployee(DtoEmployee employee);
    void updateEmployee(DtoEmployee employee);
    void delete(String id);
    Page<Employee> seacrhEmployee(String name, Pageable pageable);
}
