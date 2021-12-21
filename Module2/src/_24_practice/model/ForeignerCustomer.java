package _24_practice.model;

public class ForeignerCustomer extends Customer{
    private String national;

    public ForeignerCustomer() {
    }

    public ForeignerCustomer(String id, String name, String national) {
        super(id, name);
        this.national = national;
    }

    public String getNational() {
        return national;
    }

    public void setNational(String national) {
        this.national = national;
    }

    @Override
    public String toString() {
        return  "ForeignerCustomer{" +
                "id=" + getId() +
                ", name=" + getName() +
                ", national=" + national +
                '}';
    }

    @Override
    public String getInformation() {
        return getId() +"," +getName() +","+ national;
    }
}
