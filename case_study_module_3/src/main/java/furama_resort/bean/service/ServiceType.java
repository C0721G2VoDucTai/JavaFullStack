package furama_resort.bean.service;

public class ServiceType {
    private int id;
    private String name;

    public ServiceType() {
    }

    public ServiceType(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public ServiceType(int id) {
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
        return "ServiceType{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
