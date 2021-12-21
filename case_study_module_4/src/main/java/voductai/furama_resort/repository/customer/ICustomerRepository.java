package voductai.furama_resort.repository.customer;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import voductai.furama_resort.dto.CustomerUseServiceDTO;
import voductai.furama_resort.model.customer.Customer;
import voductai.furama_resort.model.employee.Employee;

@Repository
public interface ICustomerRepository extends JpaRepository< Customer, String > {
    @Override
    Page< Customer > findAll(Pageable pageable);
    // Search by name
    @Query(value = "select * \n" +
            " from customer c\n" +
            " where c.name like concat('%',:name, '%')", nativeQuery = true)
    Page< Customer > searchByName(@Param("name") String name, Pageable pageable);
    // Show list customer using service
//    @Query(value="", nativeQuery=true);
// Task 6 - Hiển thị khách hàng sử dụng dịch vụ, nếu có dịch vụ đi kèm hiển thị ra
    @Query(value = "select c.id, c.`name`, c.id_card, att.service_attach, att.cost, att.unit, cd.quantity\n" +
            " from customer c\n" +
            " join contract ct on ct.customer_id = c.id\n" +
            " join contract_detail cd on cd.contract_id = ct.id\n" +
            " join attach_service att on att.id = cd.attach_service_id", nativeQuery = true)
    Page< CustomerUseServiceDTO > listCustomerUsingService(Pageable pageable);
    // Search many field
    @Query(value="select * from customer where match(`name`,id_card,phone, email, address) against(:keyword)",
            nativeQuery=true)
    Page<Customer> findCustomerByKeyword(@Param("keyword") String keyword, Pageable pageable);
    @Query(value="select * from customer where match(`name`,id_card,phone, email, address) against(:keyword)" +
            " and customer_type_id = :customer_type_id",
            nativeQuery=true)
    Page<Customer> findByKeywordAAndCustomerType(@Param("keyword") String keyword, @Param("customerTypeId")
            Integer customerTypeId, Pageable pageable);
    @Query(value="select * from employee where position_id = :positionId ", nativeQuery=true)
    Page<Employee> findEmployeeByPositionId(Pageable pageable, @Param("positionId") int positionId);
}
