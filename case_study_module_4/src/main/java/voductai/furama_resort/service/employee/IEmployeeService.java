package voductai.furama_resort.service.employee;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.query.Param;
import voductai.furama_resort.model.employee.Employee;
import voductai.furama_resort.service.IGeneralService;

public interface IEmployeeService extends IGeneralService< Employee > {
    Page< Employee > findAll(Pageable pageable);
    Page<Employee> findAllEmployee(int page, int size, String sortField, String sortDirection);
    Page<Employee> findEmployeeByKeyword(int page, int size, String sortField, String sortDirection, String keyword);
    Page<Employee> findEmployeeByPositionId(int page, int size, String sortField, String sortDirection, int positionId);
}

