package _24_practice.model;

import _24_practice.model.Customer;
import _24_practice.model.VietnameseCustomer;

public class Receipt {
    String Id;
    Customer customer;
    String startDay;
    double numberOfKW;
    double price;
    public Receipt(String id, Customer customer, String startDay,
                   double numberOfKW, double price) {
        this.Id = id;
        this.customer = customer;
        this.startDay = startDay;
        this.numberOfKW = numberOfKW;
        this.price = price;
    }

    public double getTotal() {
        if (customer.getId().contains("VN")) {
            if (numberOfKW <= ((VietnameseCustomer)customer).getUsageLevel()) {
                return this.numberOfKW * this.price;
            } else {
                return this.numberOfKW * this.price +
                        (this.numberOfKW - ((VietnameseCustomer)customer).getUsageLevel())
                                * 2.5;
            }
            }else {
            return this.numberOfKW * this.price;
        }
    }

    public String getId() {
        return Id;
    }

    public void setId(String id) {
        Id = id;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public String getStartDay() {
        return startDay;
    }

    public void setStartDay(String startDay) {
        this.startDay = startDay;
    }

    public double getNumberOfKW() {
        return numberOfKW;
    }

    public void setNumberOfKW(double numberOfKW) {
        this.numberOfKW = numberOfKW;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "Receipt{" +
                "Id='" + Id + '\'' +
                ", customer=" + customer +
                ", startDay='" + startDay + '\'' +
                ", numberOfKW=" + numberOfKW +
                ", price=" + price +
                ", total=" + getTotal() +
                '}';
    }
    public String toNewString() {
        return "Receipt{" +
                "Id='" + Id + '\'' +
                ", customer=" + customer.getName() +
                ", startDay='" + startDay + '\'' +
                ", numberOfKW=" + numberOfKW +
                ", price=" + price +
                ", total=" + getTotal() +
                '}';
    }

    public String getInformationReceipt() {
        return Id +","+ customer.getId()+","+ startDay+","+ numberOfKW+","+
                price +","+ getTotal();
    }
}

