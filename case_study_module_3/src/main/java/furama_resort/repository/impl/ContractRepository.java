package furama_resort.repository.impl;

import furama_resort.bean.contract.Contract;
import furama_resort.bean.customer.Customer;
import furama_resort.bean.customer.CustomerType;
import furama_resort.bean.employee.Employee;
import furama_resort.bean.service.RentalType;
import furama_resort.bean.service.Service;
import furama_resort.bean.service.ServiceType;
import furama_resort.repository.IContractRepository;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import static furama_resort.util.ConnectionData.close;
import static furama_resort.util.ConnectionData.getConnection;
import static furama_resort.util.GetInformationSQL.selectCustomerType;

public class ContractRepository implements IContractRepository {

    @Override
    public List< Contract > selectAllContract() {
        List< Contract > contractList = new ArrayList<>();
        try {
            Statement statement = getConnection().createStatement();
            ResultSet resultSet = statement.executeQuery
                    ("select ct.contract_id, e.employee_name, c.customer_name,s.service_name,\n" +
                    " ct.check_in,ct.check_out,ct.deposit,ct.total_money\n" +
                    " from contract ct\n" +
                    " join customer c on c.customer_id = ct.customer_id\n" +
                    " join service s on s.service_id = ct.service_id\n" +
                    " join employee e on e.employee_id = ct.employee_id;");
            Contract contract = null;
            Employee employee = null;
            Service service = null;
            Customer customer = null;
            while (resultSet.next()) {
                contract = new Contract();
                employee = new Employee();
                customer = new Customer();
                service = new Service();
                contract.setId(resultSet.getInt("contract_id"));
                employee.setName(resultSet.getString("employee_name"));
                customer.setName(resultSet.getString("customer_name"));
                customer.setName(resultSet.getString("service_name"));
                contract.setCheckIn(resultSet.getString("check_in"));
                contract.setCheckOut(resultSet.getString("check_out"));
                contract.setDeposit(resultSet.getInt("deposit"));
                contract.setTotalMoney(resultSet.getInt("total_money"));
                contract.setEmployee(employee);
                contract.setCustomer(customer);
                contract.setService(service);
                contractList.add(contract);
                System.out.println(contractList.toString());

            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            close();
        }
        return contractList;
    }

    @Override
    public void insertContract(Contract contract) {
        try {
            PreparedStatement preparedStatement = getConnection().prepareStatement
                    ("insert into customer(employee_id,customer_id, service_id, check_in, check_out,deposit,total_money)" +
                            " values(?,?,?,?,?,?,?)");
            preparedStatement.setString(1, contract.getEmployee().getId());
            preparedStatement.setInt(2, contract.getCustomer().getId());
            preparedStatement.setInt(3, contract.getService().getId());
            preparedStatement.setString(4, contract.getCheckIn());
            preparedStatement.setString(5, contract.getCheckOut());
            preparedStatement.setInt(6, contract.getDeposit());
            preparedStatement.setInt(7, contract.getTotalMoney());
            preparedStatement.executeLargeUpdate();
            System.out.println(contract.toString());
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
//    public void selectCustomerUseService(){
//        List< Customer > customerList = new ArrayList<>();
//        try {
//            Statement statement = getConnection().createStatement();
//            ResultSet resultSet = statement.executeQuery
//                    ("    join customer c on c.customer_id = ct.customer_id\n" +
//                    "  join customer_type ty on ty.customer_type_id = c.customer_type_id\n" +
//                    "  join service s on s.service_id = ct.service_id\n" +
//                    "  join detail_contract d on d.contract_id = ct.contract_id\n" +
//                    "  join attach_service a on a.a_id = d.a_id;");
//            Customer customer = null;
//            CustomerType customerType = null;
//            while (resultSet.next()) {
//                for (CustomerType customerType1 : selectCustomerType()) {
//                    if (customerType1.getId() == resultSet.getInt("customer_type_id")) {
//                        customerType = customerType1;
//                    }
//                }
//                customer = new Customer();
//                customer.setId(resultSet.getInt("customer_id"));
//                customer.setCustomerType(customerType);
//                customer.setName(resultSet.getString("customer_name"));
//                customer.setIdCard(resultSet.getString("id_card"));
//                customer.setBirthDay(resultSet.getString("birthday"));
//                customer.setGender(resultSet.getString("gender"));
//                customer.setPhone(resultSet.getString("phone"));
//                customer.setEmail(resultSet.getString("email"));
//                customer.setAddress(resultSet.getString("address"));
//                customerList.add(customer);
//            }
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
//        return customerList;
//    }

}
