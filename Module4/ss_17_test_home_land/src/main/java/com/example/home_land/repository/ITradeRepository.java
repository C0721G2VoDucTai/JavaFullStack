package com.example.home_land.repository;

import com.example.home_land.model.Trade;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.sql.SQLTransactionRollbackException;

@Repository
public interface ITradeRepository extends JpaRepository< Trade, String > {

    @Query(value = "select *\n" +
            " from trade t\n" +
            " join customer c on t.customer_id = c.id\n" +
            " where c.`name` like concat('%',trim(:name),'%')", nativeQuery = true)
    Page< Trade > findAllByCustomerName(@Param("name") String name, Pageable pageable);

    //    @Query(value = "select *\n" +
//            " from trade t\n" +
//            " where t.customer_id = :customerId", nativeQuery = true)
//    Page<Trade> findAllByCustomer_Id(@Param("customerId")Integer customerId, Pageable pageable);
    Page< Trade > findAllByServiceTypeContaining(@Param("serviceType") String serviceType, Pageable pageable);

    @Query(value = "select *\n" +
            " from trade t\n" +
            " join customer c on c.id = t.customer_id\n" +
            " where (c.name like concat('%', trim(:name), '%')) " +
            " and (t.service_type like concat('%', trim(:serviceType),'%'))", nativeQuery = true)
    Page< Trade > findAllByCustomerNameAndServiceType(@Param("serviceType") String serviceType,
                                                    @Param("name") String name,
                                                    Pageable pageable);

//    @Query(value = "select *\n" +
//            " from trade t\n" +
//            " join customer c on t.customer_id = c.id\n" +
//            " where (c.`name` like concat('%',trim(:name),'%')) and (t.service_type = trim(:serviceType))", nativeQuery = true)
//    Page<Trade> findAllByCustomerNameAndService(@Param("name")String name,
//                                           @Param("serviceType")String serviceType,
//                                           Pageable pageable);
}
