package _26_practice_car.model;

public class Vans extends Vehicle{
    private int weight;

    public Vans() {
    }

    public Vans(String id, String brand, String yearProduct, String carOwner, int weight) {
        super(id, brand, yearProduct, carOwner);
        this.weight = weight;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    @Override
    public String toString() {
        return "Vans{" +
                "id='" + getId() + '\'' +
                ", brand='" + getBrand() + '\'' +
                ", yearProduct='" + getYearProduct() + '\'' +
                ", carOwner='" + getCarOwner() + '\'' +
                "weight='" + weight + '\'' +
                "} " ;
    }
    public String getVan() {
        return getId() + "," + getBrand() + "," + getYearProduct() + "," + getCarOwner() + "," + weight;
    }
}
