package voductai.furama_resort.repository.employee;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import voductai.furama_resort.model.employee.Employee;
@Repository
public interface IEmployeeRepository extends JpaRepository< Employee, Integer > {
    @Query(value="select * from employee where match(address,email,`name`,id_card,phone) against(:keyword)",
            nativeQuery=true)
    Page<Employee> findEmployeeByKeyword(Pageable pageable, @Param("keyword") String keyword);
    @Query(value="select * from employee where position_id = :positionId ", nativeQuery=true)
    Page<Employee> findEmployeeByPositionId(Pageable pageable, @Param("positionId") int positionId);
}