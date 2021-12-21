package services.promotion;

import models.person.Customer;

import java.util.List;
import java.util.Set;

public interface Promotion {
    void display();
    List<Customer> presentVoucher();
}
