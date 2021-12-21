package furama_resort.repository;

import furama_resort.bean.customer.Customer;
import furama_resort.bean.employee.Employee;

import java.util.List;

public interface IEmployeeRepository {
    public List< Employee > selectAllEmployee();
    public Employee selectEmployee(String id);
    public void insertEmployee(Employee employee);
    public void updateEmployee(Employee employee) ;
    public void deleteEmployee( String id) ;
    public List<Employee> searchEmployee(String employeeName);
}
