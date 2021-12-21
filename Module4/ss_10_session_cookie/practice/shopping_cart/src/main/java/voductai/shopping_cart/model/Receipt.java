package voductai.shopping_cart.model;

import javax.persistence.*;

//@Entity
public class Receipt {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

//    @OneToMany(targetEntity = Product.class)
    private Product product;
    private Integer unit;
    private Double total;

    public Receipt() {
    }

    public Receipt(Integer id, Product product, Integer unit, Double total) {
        this.id = id;
        this.product = product;
        this.unit = unit;
        this.total = total;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public Integer getUnit() {
        return unit;
    }

    public void setUnit(Integer unit) {
        this.unit = unit;
    }

    public Double getTotal() {
        return total;
    }

    public void setTotal(Double total) {
        this.total = total;
    }
}
