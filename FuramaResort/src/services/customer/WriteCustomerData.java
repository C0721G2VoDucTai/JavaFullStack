package services.customer;

import models.person.Customer;

import java.util.LinkedList;
import java.util.List;

import static utils.ReadAndWriterFIle.writeFile;

public class WriteCustomerData {
    public static void writeFileCustomer(List< Customer > customerList, String path, boolean append) {
        List< String > stringList = new LinkedList<>();
        for (Customer customer : customerList) {
            stringList.add(customer.getInformationCustomer());
        }
        writeFile(stringList, path, append);
    }
}
