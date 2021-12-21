package furama_resort.repository.impl;

import furama_resort.bean.customer.Customer;
import furama_resort.bean.customer.CustomerType;
import furama_resort.bean.employee.Division;
import furama_resort.bean.employee.EducationDegree;
import furama_resort.bean.employee.Employee;
import furama_resort.bean.employee.Position;
import furama_resort.repository.ICustomerRepository;
import furama_resort.util.ConnectionData;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import static furama_resort.util.ConnectionData.close;
import static furama_resort.util.ConnectionData.getConnection;
import static furama_resort.util.GetInformationSQL.*;

public class CustomerRepository implements ICustomerRepository {
    @Override
    public List< Customer > selectAllCustomer() {
        List< Customer > customerList = new ArrayList<>();
        try {
            Statement statement = getConnection().createStatement();
            ResultSet resultSet = statement.executeQuery("select * from customer;");
            Customer customer = null;
            CustomerType customerType = null;
            while (resultSet.next()) {
                for (CustomerType customerType1 : selectCustomerType()) {
                    if (customerType1.getId() == resultSet.getInt("customer_type_id")) {
                        customerType = customerType1;
                    }
                }
                customer = new Customer();
                customer.setId(resultSet.getInt("customer_id"));
                customer.setCustomerType(customerType);
                customer.setName(resultSet.getString("customer_name"));
                customer.setIdCard(resultSet.getString("id_card"));
                customer.setBirthDay(resultSet.getString("birthday"));
                customer.setGender(resultSet.getString("gender"));
                customer.setPhone(resultSet.getString("phone"));
                customer.setEmail(resultSet.getString("email"));
                customer.setAddress(resultSet.getString("address"));
                customerList.add(customer);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return customerList;
    }

    @Override
    public Customer selectCustomer(int id) {
        List< Customer > customerList = selectAllCustomer();
        Customer customer = null;
        for (Customer customer1 : customerList) {
            if (customer1.getId() == id) {
                customer = customer1;
            }
        }
        return customer;
    }

    @Override
    public void insertCustomer(Customer customer) {
        try {
            PreparedStatement preparedStatement = getConnection().prepareStatement
                    ("insert into customer(customer_type_id,customer_name, birthday, gender,id_card,phone,email,address)" +
                            " values(?,?,?,?,?,?,?,?)");
//                    ("insert into employee values(?,?,?,?,?,?,?,?");
            preparedStatement.setString(1, String.valueOf(customer.getCustomerType().getId()));
            preparedStatement.setString(2, customer.getName());
            preparedStatement.setString(3, customer.getBirthDay());
            preparedStatement.setString(4, customer.getGender());
            preparedStatement.setString(5, customer.getIdCard());
            preparedStatement.setString(6, customer.getPhone());
            preparedStatement.setString(7, customer.getEmail());
            preparedStatement.setString(8, customer.getAddress());
            preparedStatement.executeLargeUpdate();
            System.out.println(customer.toString());
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void updateCustomer(Customer customer) {
        try {
            PreparedStatement preparedStatement = getConnection().prepareStatement
                    ("update customer set `customer_name` = ?,customer_type_id= ?, birthday=?, " +
                            " gender=?,id_card=?, email=?, address=?, phone=? where customer_id = ?;");
            preparedStatement.setString(1, customer.getName());
            preparedStatement.setInt(2, customer.getCustomerType().getId());
            preparedStatement.setString(3, customer.getBirthDay());
            preparedStatement.setString(4, customer.getGender());
            preparedStatement.setString(5, customer.getIdCard());
            preparedStatement.setString(6, customer.getPhone());
            preparedStatement.setString(7, customer.getEmail());
            preparedStatement.setString(8, customer.getAddress());
            preparedStatement.setInt(9, customer.getId());
            preparedStatement.executeLargeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void deleteCustomer(int id) {
        try {
            PreparedStatement preparedStatement = getConnection().prepareStatement
                    ("delete from customer where customer_id = ?;");
            preparedStatement.setInt(1, id);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public List< Customer > searchCustomer(String customerName, String customerTypeName,String address) {
        List< Customer > customerList = new ArrayList<>();
        try {
            PreparedStatement ps = getConnection().prepareStatement
                    ("select c.customer_id, ct.customer_type_id, c.customer_name, c.birthday, c.gender, c.id_card, c.phone\n" +
                            " , c.email, c.address\n" +
                            " from customer c\n" +
                            " join customer_type ct on ct.customer_type_id  =  c.customer_type_id\n" +
                            " where (c.customer_name  like concat('%',?,'%'))\n" +
                            " and (ct.customer_type_name like concat('%',?, '%'))\n" +
                            " and (c.address like concat('%',?,'%'));");
            ps.setString(1, customerName);
            ps.setString(2, customerTypeName);
            ps.setString(3, address);
            ResultSet resultSet = ps.executeQuery();
            Customer customer = null;
            CustomerType customerType = null;
            while (resultSet.next()) {
                customer = new Customer();
                customerType= new CustomerType();
                customerType.setId(resultSet.getInt("customer_type_id"));
                customer.setCustomerType(customerType);
                customer.setId(resultSet.getInt("customer_id"));
                customer.setName(resultSet.getString("customer_name"));
                customer.setIdCard(resultSet.getString("id_card"));
                customer.setBirthDay(resultSet.getString("birthday"));
                customer.setGender(resultSet.getString("gender"));
                customer.setPhone(resultSet.getString("phone"));
                customer.setEmail(resultSet.getString("email"));
                customer.setAddress(resultSet.getString("address"));
                customerList.add(customer);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return customerList;
    }

}
