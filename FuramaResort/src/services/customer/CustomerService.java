package services.customer;

import models.person.Customer;
import models.person.Employee;
import services.Service;

import java.util.List;

public interface CustomerService extends Service {
    @Override
    void add();

    @Override
    void display();

    @Override
    void edit();
}
