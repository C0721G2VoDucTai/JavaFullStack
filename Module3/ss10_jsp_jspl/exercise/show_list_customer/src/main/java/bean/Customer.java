package bean;

import java.util.Date;

public class Customer {
    private String name;
    private String birthOfDay;
    private String address;
    private String img;

    public Customer(String name, String birthOfDay, String address, String img) {
        this.name = name;
        this.birthOfDay = birthOfDay;
        this.address = address;
        this.img = img;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getBirthOfDay() {
        return birthOfDay;
    }

    public void setBirthOfDay(String birthOfDay) {
        this.birthOfDay = birthOfDay;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }
}

