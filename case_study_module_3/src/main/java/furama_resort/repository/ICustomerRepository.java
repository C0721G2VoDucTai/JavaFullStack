package furama_resort.repository;

import furama_resort.bean.customer.Customer;

import java.util.List;

public interface ICustomerRepository {
    public List< Customer > selectAllCustomer();

    public Customer selectCustomer(int id);

    public void insertCustomer(Customer customer);

    public void updateCustomer(Customer customer);

    public void deleteCustomer(int id);

    public List< Customer > searchCustomer(String customerName, String customerTypeName,String address);
}
