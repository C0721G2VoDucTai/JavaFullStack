package _24_practice.util;

import _24_practice.model.Customer;
import _24_practice.model.Receipt;

import java.util.ArrayList;
import java.util.List;

import static _24_practice.management.CustomerManagement.CUS_PATH;
import static _24_practice.util.ReadAndWrite.readFile;
import static _24_practice.util.ReadFileCustomer.readFileCustomer;

public class ReadFileReceipt {
    public static List< Receipt > readFileReceipt(String  path) {
        List<String> stringList = readFile(path);
        List<Receipt> receiptList = new ArrayList<>();
        List<Customer> customerList = readFileCustomer(CUS_PATH);
        for(String string : stringList) {
            String [] temp = string.split(",");
            Customer customer1 = new Customer();
            for(Customer customer : customerList) {
                if(customer.getId().equals(temp[1])) {
                    customer1 = customer;
                }
            }
                Receipt receipt = new Receipt(temp[0],customer1, temp[2],
                        Double.parseDouble(temp[3]),Double.parseDouble(temp[4]));
            receiptList.add(receipt);
        }
        return receiptList;
    }
}
