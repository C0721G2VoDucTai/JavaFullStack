package _26_practice_car.model;

public class Car extends Vehicle {
    private int numberSit;
    private String type;
    public static final String TRAVEL = "Travel";
    public static final String BUS = "Bus";

    public Car() {
    }

    public Car(String id, String brand, String yearProduct, String carOwner, int numberSit, String type) {
        super(id, brand, yearProduct, carOwner);
        this.numberSit = numberSit;
    }

    public int getNumberSit() {
        return numberSit;
    }

    public void setNumberSit(int numberSit) {
        this.numberSit = numberSit;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    @Override
    public String toString() {
        return "Car{" +
                "id='" + getId() + '\'' +
                ", brand='" + getBrand() + '\'' +
                ", yearProduct='" + getYearProduct() + '\'' +
                ", carOwner='" + getCarOwner() + '\'' +
                "numberSit=" + numberSit +
                "type=" + type +
                "} ";
    }
    public String getCar() {
        return getId() + "," + getBrand() + "," + getYearProduct() + "," + getCarOwner() + "," +
                numberSit + "," +type;
    }
}
