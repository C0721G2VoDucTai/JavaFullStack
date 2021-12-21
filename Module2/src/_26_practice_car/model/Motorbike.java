package _26_practice_car.model;

public class Motorbike extends Vehicle{
    private int wattage;

    public Motorbike() {
    }

    public Motorbike(String id, String brand, String yearProduct, String carOwner, int wattage) {
        super(id, brand, yearProduct, carOwner);
        this.wattage = wattage;
    }

    public int getWattage() {
        return wattage;
    }

    public void setWattage(int wattage) {
        this.wattage = wattage;
    }

    @Override
    public String toString() {
        return "MotorBike{" +
                "id='" + getId() + '\'' +
                ", brand='" + getBrand() + '\'' +
                ", yearProduct='" + getYearProduct() + '\'' +
                ", carOwner='" + getCarOwner() + '\'' +
                "wattage=" + wattage +
                "} ";
    }
    public String getMotorBike() {
        return getId() + "," + getBrand() + "," + getYearProduct() + "," + getCarOwner() + "," + wattage;
    }
}
