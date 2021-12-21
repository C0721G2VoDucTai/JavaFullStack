package _24_practice.util;

import _24_practice.model.Customer;
import _24_practice.model.ForeignerCustomer;
import _24_practice.model.VietnameseCustomer;

import java.util.ArrayList;
import java.util.List;

import static _24_practice.util.ReadAndWrite.writeFile;
public class WriteFileCustomer {
    public static void writeFileCustomer(List< Customer > customerList, String path, boolean append) {
        List< String > stringList = new ArrayList<>();
        for (Customer customer : customerList) {
            if (customer instanceof VietnameseCustomer) {
                stringList.add(((VietnameseCustomer)customer).getInformation());
            } else {
                stringList.add(((ForeignerCustomer) customer).getInformation());
            }
        }
        writeFile(stringList, path, append);
    }
}