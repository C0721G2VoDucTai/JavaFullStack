package voductai.furama_resort.model.contract;

import voductai.furama_resort.model.customer.Customer;
import voductai.furama_resort.model.employee.Employee;
import voductai.furama_resort.model.service.Services;

import javax.persistence.*;
import java.util.List;

@Entity
public class Contract {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String checkin;
    private String checkout;
    private Double deposit;
    private Double totalMoney;
    @ManyToOne(targetEntity = Employee.class)
    private Employee employee;
    @ManyToOne(targetEntity = Customer.class)
    private Customer customer;
    @ManyToOne(targetEntity = Services.class)
    private Services services;
    @OneToMany(targetEntity = ContractDetail.class, mappedBy = "contract")
    List<ContractDetail> contractDetailList;
    public Contract() {
    }

    public Contract(Integer id, String checkin, String checkout, Double deposit, Double totalMoney, Employee employee,
                    Customer customer, Services services) {
        this.id = id;
        this.checkin = checkin;
        this.checkout = checkout;
        this.deposit = deposit;
        this.totalMoney = totalMoney;
        this.employee = employee;
        this.customer = customer;
        this.services = services;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCheckin() {
        return checkin;
    }

    public void setCheckin(String checkin) {
        this.checkin = checkin;
    }

    public String getCheckout() {
        return checkout;
    }

    public void setCheckout(String checkout) {
        this.checkout = checkout;
    }

    public Double getDeposit() {
        return deposit;
    }

    public void setDeposit(Double deposit) {
        this.deposit = deposit;
    }

    public Double getTotalMoney() {
        return totalMoney;
    }

    public void setTotalMoney(Double totalMoney) {
        this.totalMoney = totalMoney;
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

    public Services getServices() {
        return services;
    }

    public void setServices(Services services) {
        this.services = services;
    }
}
