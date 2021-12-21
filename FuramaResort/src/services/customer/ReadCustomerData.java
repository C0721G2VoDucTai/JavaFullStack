package services.customer;

import models.person.Customer;

import java.util.LinkedList;
import java.util.List;

import static utils.ReadAndWriterFIle.readFile;

public class ReadCustomerData {
    public static List< Customer > readFileCustomer(String path) {
        List< String > stringList = readFile(path);
        List< Customer > customerList = new LinkedList<>();
        for (String string : stringList) {
            String[] temp = string.split(",");
            Customer customer = new Customer(Integer.parseInt(temp[0]), temp[1], temp[2], temp[3], temp[4],
                    temp[5], temp[6], temp[7], temp[8]);
            customerList.add(customer);
        }
        return customerList;
    }
}
