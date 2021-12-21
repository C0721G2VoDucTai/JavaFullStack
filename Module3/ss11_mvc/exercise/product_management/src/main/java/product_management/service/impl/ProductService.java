package product_management.service.impl;

import product_management.bean.Product;
import product_management.respository.impl.ProductRepository;
import product_management.service.IProductService;
import product_management.respository.IProductRepository;

import java.util.List;

public class ProductService implements IProductService {
    IProductRepository productRepository = new ProductRepository();
    @Override
    public void save(Product product) {
        productRepository.save(product);
    }

    @Override
    public void update(int id, Product product) {
        productRepository.update(id, product);
    }

    @Override
    public void remove(int id) {
        productRepository.remove(id);
    }

    @Override
    public Product findById(int id) {
        return this.productRepository.findById(id);
    }

    @Override
    public List<Product> findByName(String name) {
        return this.productRepository.findByName(name);
    }

    @Override
    public List< Product > findAll() {
        return this.productRepository.findAll();
    }
}
