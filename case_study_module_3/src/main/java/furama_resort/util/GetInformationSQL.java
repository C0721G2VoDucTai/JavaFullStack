package furama_resort.util;

import furama_resort.bean.customer.CustomerType;
import furama_resort.bean.employee.Division;
import furama_resort.bean.employee.EducationDegree;
import furama_resort.bean.employee.Position;
import furama_resort.bean.service.RentalType;
import furama_resort.bean.service.ServiceType;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import static furama_resort.util.ConnectionData.getConnection;

public class GetInformationSQL {
    public static List< Position > selectPosition() {
        List< Position > positionList = new ArrayList<>();
        try {
            Statement statement = getConnection().createStatement();
            ResultSet resultSet = statement.executeQuery("select * from position ;");
            Position position = null;
            while (resultSet.next()) {
                position = new Position();
                position.setId(resultSet.getInt("position_id"));
                position.setName(resultSet.getString("position_name"));
                positionList.add(position);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return positionList;
    }

    public static List< EducationDegree > selectEducationDegree() {
        List< EducationDegree > degreeList = new ArrayList<>();
        try {
            Statement statement = getConnection().createStatement();
            ResultSet resultSet = statement.executeQuery("select * from education_degree ;");
            EducationDegree degree = null;
            while (resultSet.next()) {
                degree = new EducationDegree();
                degree.setId(resultSet.getInt("degree_id"));
                degree.setName(resultSet.getString("degree_name"));
                degreeList.add(degree);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return degreeList;
    }

    public static List< Division > selectDivision() {
        List< Division > divisionList = new ArrayList<>();
        try {
            Statement statement = getConnection().createStatement();
            ResultSet resultSet = statement.executeQuery("select * from division ;");
            Division division = null;
            while (resultSet.next()) {
                division = new Division();
                division.setId(resultSet.getInt("division_id"));
                division.setName(resultSet.getString("division_name"));
                divisionList.add(division);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return divisionList;
    }

    public static List< CustomerType > selectCustomerType() {
        List< CustomerType > customerTypeList = new ArrayList<>();
        try {
            Statement statement = getConnection().createStatement();
            ResultSet resultSet = statement.executeQuery("select * from customer_type ;");
            CustomerType customerType = null;
            while (resultSet.next()) {
                customerType = new CustomerType();
                customerType.setId(resultSet.getInt("customer_type_id"));
                customerType.setName(resultSet.getString("customer_type_name"));
                customerTypeList.add(customerType);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return customerTypeList;
    }

    public static List< RentalType > selectRentalType() {
        List< RentalType > rentalTypeList = new ArrayList<>();
        try {
            Statement statement = getConnection().createStatement();
            ResultSet resultSet = statement.executeQuery("select * from rental_type ;");
            RentalType rentalType = null;
            while (resultSet.next()) {
                rentalType = new RentalType();
                rentalType.setId(resultSet.getInt("rental_type_id"));
                rentalType.setName(resultSet.getString("rental_type_name"));
                rentalTypeList.add(rentalType);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return rentalTypeList;
    }

    public static List< ServiceType > selectServiceType() {
        List< ServiceType > serviceTypeList = new ArrayList<>();
        try {
            Statement statement = getConnection().createStatement();
            ResultSet resultSet = statement.executeQuery("select * from service_type;");
            ServiceType serviceType = null;
            while (resultSet.next()) {
                int id = resultSet.getInt("service_type_id");
                String name = resultSet.getString("service_type_name");
                serviceTypeList.add(new ServiceType(id,name));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return serviceTypeList;
    }
}
