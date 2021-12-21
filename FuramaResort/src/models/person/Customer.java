package models.person;

public class Customer extends Person implements Comparable <Customer>{
    private String typeCustomer;
    private String address;

    public Customer() {
    }

    public Customer(int id, String name, String birthDay, String sex, String idCard, String phoneNumber, String email, String typeCustomer, String address) {
        super(id, name, birthDay, sex, idCard, phoneNumber, email);
        this.typeCustomer = typeCustomer;
        this.address = address;
    }

    public String getTypeCustomer() {
        return typeCustomer;
    }

    public void setTypeCustomer(String typeCustomer) {
        this.typeCustomer = typeCustomer;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @Override
    public String toString() {
        return "Customer{" +
                "id=" + getId() +
                ", name='" + getName() +
                ", birthDay='" + getBirthDay() +
                ", sex='" + getSex() +
                ", idCard=" + getIdCard() +
                ", phoneNumber='" + getPhoneNumber() +
                ", email='" + getEmail() +
                "typeCustomer='" + typeCustomer +
                ", address='" + address +
                "}";
    }

    public String getInformationCustomer() {
        return super.getId() + "," + super.getName() + "," + super.getBirthDay() + "," + super.getSex() + ","
                + super.getIdCard() + "," + super.getPhoneNumber() + "," + super.getEmail() + "," + typeCustomer +
                "," + address;
    }
    @Override
    public int compareTo(Customer o) {
        return 0;
    }
}
