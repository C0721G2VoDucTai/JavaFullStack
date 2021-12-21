package services.employee;

import models.person.Employee;
import services.Service;

import java.util.List;

public interface EmployeeService extends Service {
    @Override
    void add();

    @Override
    void display();

    @Override
    void edit();
}
