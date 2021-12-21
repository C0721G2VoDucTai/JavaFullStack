package _24_practice.management;

import _24_practice.model.Customer;
import _24_practice.model.VietnameseCustomer;
import _24_practice.model.Receipt;

import java.io.File;
import java.util.List;
import java.util.Scanner;

import static _24_practice.management.CustomerManagement.CUS_PATH;
import static _24_practice.util.ReadFileCustomer.readFileCustomer;
import static _24_practice.util.ReadFileReceipt.readFileReceipt;
import static _24_practice.util.WriteFileReceipt.writeFileReceipt;

public class ReceiptManagement implements Management {
    public static final String RECEIPT = "src\\_24_practice\\data\\receipt_data.csv";
    public static final int BUSINESS = 3000;
    public static final int FAMILY = 1000;
    public static final int PRODUCT = 2500;
    public static final int FOREIGN = 3000;
    File fileReceipt = new File(RECEIPT);
    static Scanner scanner = new Scanner(System.in);
    List< Receipt > receiptList = readFileReceipt(RECEIPT);
    List< Customer > customerList = readFileCustomer(CUS_PATH);

    CustomerManagement customerManagement = new CustomerManagement();

    @Override
    public void add() {
        String[] temp = receiptList.get(receiptList.size() - 1).getId().split("-");
        int id = (Integer.parseInt(temp[1]) + 1);
        String idReceipt;
        if (id < 10) {
            idReceipt = "MHD-00" + (Integer.parseInt(temp[1]) + 1);
        } else if (id < 100) {
            idReceipt = "MHD-0" + (Integer.parseInt(temp[1]) + 1);
        } else {
            idReceipt = "MHD-" + (Integer.parseInt(temp[1]) + 1);
        }
        customerManagement.display();
        System.out.println("Enter index customer: ");
        int index = Integer.parseInt(scanner.nextLine());
        Customer customer = new Customer();
        customer = customerList.get(index - 1);
        System.out.println("Enter star day: ");
        String startDay = scanner.nextLine();
        System.out.println("Enter number KW: ");
        double numberOfKW = Double.parseDouble(scanner.nextLine());
        double price = 0.0;
        for (Receipt receipt : receiptList) {
            if (receipt.getCustomer().getId().equals("VN")) {
                if (((VietnameseCustomer) receipt.getCustomer()).getType().equals("Si")) {
                    price = FAMILY;
                } else if (((VietnameseCustomer) receipt.getCustomer()).getType().equals("Ki")) {
                    price = BUSINESS;
                } else {
                    price = PRODUCT;
                }
            } else {
                price = FOREIGN;
            }
        }
        Receipt receipt = new Receipt(idReceipt, customer, startDay, numberOfKW, price);
        fileReceipt.delete();
        receiptList.add(receipt);
        writeFileReceipt(receiptList, RECEIPT, true);
    }

    @Override
    public void display() {
        for (int i = 0; i < receiptList.size(); i++) {
            System.out.println((i + 1) + "," + receiptList.get(i).toString());
        }
        System.out.println("Enter index to know detail information");
        int index = Integer.parseInt(scanner.nextLine());
        System.out.println(receiptList.get(index - 1).toNewString());
    }

    @Override
    public void edit() {
        for (int i = 0; i < receiptList.size(); i++) {
            System.out.println((i + 1) + "," + receiptList.get(i).toString());
        }
        System.out.println("Enter index you want edit");
        int index = Integer.parseInt(scanner.nextLine());
        System.out.println(receiptList.get(index - 1).toString());
        boolean check = true;
        while (check) {
            System.out.println("Menu edit: 1. id - 2. customer - 3. start day - 4. number of KW - 5. return menu");
            int choice = Integer.parseInt(scanner.nextLine());
            switch (choice) {
                case 1:
                    System.out.println("Enter new id: ");
                    String id = scanner.nextLine();
                    receiptList.get(index - 1).setId(id);
                    break;
                case 2:
                    customerManagement.display();
                    System.out.println("Enter new index customer: ");
                    Customer customer = customerList.get(index - 1);
                    receiptList.get(index - 1).setCustomer(customer);
                    break;
                case 3:
                    System.out.println("Enter star day: ");
                    String startDay = scanner.nextLine();
                    receiptList.get(index - 1).setStartDay(startDay);
                    break;
                case 4:
                    double numberOfKW = Double.parseDouble(scanner.nextLine());
                    System.out.println("Enter number of KW: ");
                    receiptList.get(index - 1).setNumberOfKW(numberOfKW);
                    break;
                case 5:
                    check = false;
                    break;
            }
        }
        fileReceipt.delete();
        writeFileReceipt(receiptList, RECEIPT, true);
    }

    @Override
    public void search() {

    }
}
