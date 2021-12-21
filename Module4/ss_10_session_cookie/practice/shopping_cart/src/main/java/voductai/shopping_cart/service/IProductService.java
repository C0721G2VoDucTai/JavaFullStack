package voductai.shopping_cart.service;

import org.springframework.stereotype.Service;
import voductai.shopping_cart.model.Product;

import java.util.Optional;
public interface IProductService {
    Iterable< Product > findAll();
    Optional<Product> findById(Long id);
}
