package _26_practice_car.model;

public abstract class Vehicle {
    private String id;
    private String brand;
    private String yearProduct;
    private String carOwner;

    public Vehicle(String id, String brand, String yearProduct, String carOwner) {
        this.id = id;
        this.brand = brand;
        this.yearProduct = yearProduct;
        this.carOwner = carOwner;
    }

    public Vehicle() {
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getYearProduct() {
        return yearProduct;
    }

    public void setYearProduct(String yearProduct) {
        this.yearProduct = yearProduct;
    }

    public String getCarOwner() {
        return carOwner;
    }

    public void setCarOwner(String carOwner) {
        this.carOwner = carOwner;
    }

    @Override
    public String toString() {
        return "Vehicle{" +
                "id='" + id + '\'' +
                ", brand='" + brand + '\'' +
                ", yearProduct='" + yearProduct + '\'' +
                ", carOwner='" + carOwner + '\'' +
                '}';
    }
}
