package furama_resort.repository.impl;

import furama_resort.bean.employee.Division;
import furama_resort.bean.employee.EducationDegree;
import furama_resort.bean.employee.Employee;
import furama_resort.bean.employee.Position;
import furama_resort.bean.service.RentalType;
import furama_resort.bean.service.Service;
import furama_resort.bean.service.ServiceType;
import furama_resort.repository.IServiceRepository;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import static furama_resort.util.ConnectionData.close;
import static furama_resort.util.ConnectionData.getConnection;
import static furama_resort.util.GetInformationSQL.*;

public class ServiceRepository implements IServiceRepository {


    @Override
    public List< Service > selectAllService() {
        List< Service > serviceList = new ArrayList<>();
        try {
            Statement statement = getConnection().createStatement();
            ResultSet resultSet = statement.executeQuery("select \n" +
                    " sv.service_id,sv.service_name,sv.area,sv.cost,sv.number_of_person,sv.rental_type_id,\n" +
                    " rt.rental_type_name, sv.service_type_id,st.service_type_name,sv.standard_room,\n" +
                    " sv.description_other_convenience,sv.pool_area,sv.number_of_floors\n" +
                    " from service sv\n" +
                    " join rental_type rt on rt.rental_type_id =sv.rental_type_id\n" +
                    " join service_type st on st.service_type_id = sv.service_type_id;");
            Service service = null;
            while (resultSet.next()) {
                service = new Service();
                service.setId(resultSet.getInt("service_id"));
                service.setName(resultSet.getString("service_name"));
                service.setArea(resultSet.getInt("area"));
                service.setCost(resultSet.getInt("cost"));
                service.setNumberOfPerson(resultSet.getInt("number_of_person"));
                service.setStandardRoom(resultSet.getString("standard_room"));
                service.setDescription(resultSet.getString("description_other_convenience"));
                service.setPoolArea(resultSet.getInt("pool_area"));
                service.setNumberOfFloor(resultSet.getInt("number_of_floors"));
                int rentalTypeId = (resultSet.getInt("rental_type_id"));
                String rentalTypeName = (resultSet.getString("rental_type_name"));
                int serviceTypeId =(resultSet.getInt("service_type_id"));
                String serviceTypeName = (resultSet.getString("service_type_name"));
                service.setServiceType(new ServiceType(serviceTypeId,serviceTypeName));
                service.setRentalType(new RentalType(rentalTypeId,rentalTypeName));
                serviceList.add(service);
                System.out.println(service.toString());

            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            close();
        }
        return serviceList;
    }

    @Override
    public void insertService(Service service) {
        try {
            PreparedStatement preparedStatement = getConnection().prepareStatement
                    ("insert into service(service_name,area,cost,number_of_person,rental_type_id,service_type_id,\n" +
                            " standard_room,description_other_convenience,pool_area,number_of_floors)\n" +
                            " value(?,?,?,?,?,?,?,?,?,?);");
            preparedStatement.setString(1, service.getName());
            preparedStatement.setInt(2, service.getArea());
            preparedStatement.setInt(3, service.getCost());
            preparedStatement.setInt(4, service.getNumberOfPerson());
            preparedStatement.setInt(5, service.getRentalType().getId());
            preparedStatement.setInt(6, service.getServiceType().getId());
            preparedStatement.setString(7, service.getStandardRoom());
            preparedStatement.setString(8, service.getDescription());
            preparedStatement.setInt(9, service.getPoolArea());
            preparedStatement.setInt(10, service.getNumberOfFloor());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            close();
        }
    }
}
