package furama_resort.bean.contract;

import furama_resort.bean.customer.Customer;
import furama_resort.bean.employee.Employee;
import furama_resort.bean.service.Service;
import org.omg.PortableServer.Servant;

public class Contract {
    private int id;
    private Employee employee;
    private Customer customer;
    private Service service;
    private String checkIn;
    private String checkOut;
    private int deposit;
    private int totalMoney;

    public Contract() {
    }

    public Contract(int id, Employee employee, Customer customer, Service service, String checkIn,
                    String checkOut, int deposit, int totalMoney) {
        this.id = id;
        this.employee = employee;
        this.customer = customer;
        this.service = service;
        this.checkIn = checkIn;
        this.checkOut = checkOut;
        this.deposit = deposit;
        this.totalMoney = totalMoney;

    }

    public Contract(Employee employee, Customer customer, Service service, String checkIn, String checkOut,
                    int deposit, int totalMoney) {
        this.employee = employee;
        this.customer = customer;
        this.service = service;
        this.checkIn = checkIn;
        this.checkOut = checkOut;
        this.deposit = deposit;
        this.totalMoney = totalMoney;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public Service getService() {
        return service;
    }

    public void setService(Service service) {
        this.service = service;
    }

    public String getCheckIn() {
        return checkIn;
    }

    public void setCheckIn(String checkIn) {
        this.checkIn = checkIn;
    }

    public String getCheckOut() {
        return checkOut;
    }

    public void setCheckOut(String checkOut) {
        this.checkOut = checkOut;
    }

    public int getDeposit() {
        return deposit;
    }

    public void setDeposit(int deposit) {
        this.deposit = deposit;
    }

    public int getTotalMoney() {
        return totalMoney;
    }

    public void setTotalMoney(int totalMoney) {
        this.totalMoney = totalMoney;
    }
}
