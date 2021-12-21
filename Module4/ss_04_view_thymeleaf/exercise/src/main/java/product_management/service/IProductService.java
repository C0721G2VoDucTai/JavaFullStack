package product_management.service;

import product_management.model.Product;

import java.util.List;

public interface IProductService {
    public List< Product > showListProduct();
    public Product showDetailProduct(String id);
    public void addProduct(Product product);
    public void editProduct(Product product);
    public void delete(String id);
    public List<Product> searchName(String name);
}
