package furama_resort.bean.service;

public class RentalType {
    private int id;
    private String name;

    public RentalType() {
    }

    public RentalType(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public RentalType(int id) {
        this.id = id;

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "RentalType{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
