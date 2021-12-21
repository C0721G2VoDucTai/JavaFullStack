package voductai.shopping_cart.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import voductai.shopping_cart.model.Product;
@Repository
public interface IProductRepository extends JpaRepository< Product, Long > {

}
