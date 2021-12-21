package product_management.service;

import product_management.bean.Product;

import java.util.List;

public interface IProductService {
    void save(Product product);

    void update(int id, Product product);

    void remove(int id);

    Product findById(int id);
    List <Product> findByName(String name);

    List< Product > findAll();
}

