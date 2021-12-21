package _24_practice.util;

import _24_practice.model.Customer;
import _24_practice.model.ForeignerCustomer;
import _24_practice.model.VietnameseCustomer;

import java.util.ArrayList;
import java.util.List;

import static _24_practice.util.ReadAndWrite.readFile;

public class ReadFileCustomer {
    public static List< Customer > readFileCustomer(String path) {
        List< String > stringList = readFile(path);
        List< Customer > customerList = new ArrayList<>();

        for (String string : stringList) {
            String[] temp = string.split(",");
            if (temp[0].contains("VN")) {
                Customer customer1 = new VietnameseCustomer(temp[0], temp[1],
                        Integer.parseInt(temp[2]), temp[3]);
                customerList.add(customer1);
            } else {
                Customer customer2 = new ForeignerCustomer(temp[0], temp[1],
                        temp[2]);
                customerList.add(customer2);
            }
        }
        return customerList;
    }

}
