package voductai.furama_resort.service.employee.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import voductai.furama_resort.model.employee.Employee;
import voductai.furama_resort.repository.employee.IEmployeeRepository;
import voductai.furama_resort.service.employee.IEmployeeService;

import java.util.Optional;

@Service
public class EmployeeService implements IEmployeeService {
    @Autowired
    IEmployeeRepository employeeRepository;
    @Override
    public Iterable< Employee > findAll() {
        return employeeRepository.findAll();
    }
    @Override
    public Page<Employee> findAll(Pageable pageable){
       return employeeRepository.findAll(pageable);
    }

    @Override
    public Page< Employee > findAllEmployee(int page, int size, String sortField, String sortDirection) {
        Sort sort = sortDirection.equalsIgnoreCase(Sort.Direction.ASC.name()) ? Sort.by(sortField).ascending() :
                Sort.by(sortField).descending();
        Pageable pageable = PageRequest.of(page,size,sort);
        return employeeRepository.findAll(pageable);
    }

    @Override
    public Page< Employee > findEmployeeByKeyword(int page, int size, String sortField, String sortDirection, String keyword) {
        Sort sort = sortDirection.equalsIgnoreCase(Sort.Direction.ASC.name()) ? Sort.by(sortField).ascending() :
                Sort.by(sortField).descending();
        Pageable pageable = PageRequest.of(page,size,sort);
        return employeeRepository.findEmployeeByKeyword(pageable,keyword);
    }

    @Override
    public Page< Employee > findEmployeeByPositionId(int page, int size, String sortField, String sortDirection, int positionId) {
        Sort sort = sortDirection.equalsIgnoreCase(Sort.Direction.ASC.name()) ? Sort.by(sortField).ascending():
        Sort.by(sortField).ascending();
        Pageable pageable = PageRequest.of(page,size,sort);
        return employeeRepository.findEmployeeByPositionId(pageable,positionId);
    }


    @Override
    public Optional< Employee > findById(Integer id) {
        return employeeRepository.findById(id);
    }

    @Override
    public void save(Employee employee) {
        employeeRepository.save(employee);
    }

    @Override
    public void remove(Integer id) {
        employeeRepository.deleteById(id);
    }
}
