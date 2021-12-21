package customer_management.repository;


import customer_management.model.Customer;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ICustomerRepository extends PagingAndSortingRepository< Customer, Long > {
    Page<Customer> findAllByFirstNameContaining(String firstName, Pageable pageable);
}