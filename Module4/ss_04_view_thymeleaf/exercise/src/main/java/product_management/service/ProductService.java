package product_management.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import product_management.model.Product;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
@Service
public class ProductService implements IProductService{
    private static final Map<String, Product> productList;
    static {
        productList = new HashMap<>();
        productList.put("01", new Product("01", "Iphone13", "Apple", 30000000));
        productList.put("02", new Product("02", "Iphone12", "Apple", 25000000));
        productList.put("03", new Product("03", "Samsung Galaxy", "Samsung", 20000000));
        productList.put("04", new Product("04", "Nokia ", "Nokia", 15000000));
        productList.put("05",  new Product("05", "Samsung Note 10", "Samsung", 25000000));
    }

    @Override
    public List< Product > showListProduct() {
        return new ArrayList<>(productList.values());
    }

    @Override
    public Product showDetailProduct(String id) {
        return productList.get(id);
    }

    @Override
    public void addProduct(Product product) {
        productList.put(product.getId(), product);
    }

    @Override
    public void editProduct(Product product) {
        productList.put(product.getId(), product);
    }

    @Override
    public void delete(String id) {
        productList.remove(id);
    }

    @Override
    public List< Product > searchName(String name) {
        List<Product> list = new ArrayList<>();
        for(Map.Entry<String, Product> map : productList.entrySet()){
            if(map.getValue().getName().contains(name)){
                list.add(map.getValue());
            }
        }
        return list;
    }
}
