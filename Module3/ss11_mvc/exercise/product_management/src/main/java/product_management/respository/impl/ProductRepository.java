package product_management.respository.impl;

import product_management.bean.Product;
import product_management.respository.IProductRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class ProductRepository implements IProductRepository {
    static Map< Integer, Product > productMap = new TreeMap<>();

    static {
        productMap.put(1, new Product(1, "Iphone 13", 30000000, "512Mg", "Apple"));
        productMap.put(2, new Product(2, "Iphone 12", 25000000, "512Mg", "Apple"));
        productMap.put(4, new Product(4, "Iphone 11", 20000000, "256Mg", "Apple"));
        productMap.put(3, new Product(3, "Iphone X", 15000000, "128Mg", "Apple"));
        productMap.put(6, new Product(6, "Iphone 8", 10000000, "128Mg", "Apple"));

    }

    @Override
    public void save(Product product) {
        productMap.put(product.getId(), product);
    }

    @Override
    public void update(int id, Product product) {
        productMap.put(id, product);
    }

    @Override
    public void remove(int id) {
        productMap.remove(id);
    }

    @Override
    public Product findById(int id) {
        return productMap.get(id);
    }

    @Override
    public List< Product > findByName(String name) {
        ArrayList< Product > productList = new ArrayList();
        for (Map.Entry< Integer, Product > map : productMap.entrySet()) {
            if (map.getValue().getName().contains(name)) {
                productList.add(map.getValue());
            }
        }
        return productList;
    }

    @Override
    public List< Product > findAll() {
        return new ArrayList<>(productMap.values());
    }
}
