package _24_practice.management;

import _24_practice.model.Customer;
import _24_practice.model.ForeignerCustomer;
import _24_practice.model.VietnameseCustomer;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import static _24_practice.util.CheckRegex.checkRegex;
import static _24_practice.util.ReadAndWrite.readFile;
import static _24_practice.util.ReadFileCustomer.readFileCustomer;
import static _24_practice.util.WriteFileCustomer.writeFileCustomer;

public class CustomerManagement implements Management {
    public static final String CUS_PATH = "src\\_24_practice\\data\\customer_data.csv";
    public static final String TYPE_PATH = "src\\_24_practice\\data\\type_of_customer_data.csv";
    public static final String ID_REGEX = "^KH(VN|NN)-\\d{5}$";
    public static final String NAME_REGEX = "([A-Z][a-z]+\\s?)+";
    public static final String INT_REGEX = "[1-9][0-9]*";
    public static final String CHOICE_REGEX = "[1-9][0-9]*";

    File fileCustomer = new File(CUS_PATH);
    static Scanner scanner = new Scanner(System.in);
    List< Customer > customerList = readFileCustomer(CUS_PATH);

    @Override
    public void add() {
        int choice;
        System.out.println("Choice type of customer: " +
                " 1:Vietnamese Customer: \n" +
                " 2: Foreigner Customer: ");
        choice = Integer.parseInt(inputChoice());
        switch (choice) {
            case 1:
                Customer customer1 = new VietnameseCustomer(inputId(), inputName(),
                        Integer.parseInt(inputUsageLevel()), getType());
                customerList.add(customer1);
                fileCustomer.delete();
                writeFileCustomer(customerList, CUS_PATH, true);
                break;
            case 2:
                Customer customer2 = new ForeignerCustomer(inputId(), inputName(), inputNational());
                customerList.add(customer2);
                fileCustomer.delete();
                writeFileCustomer(customerList, CUS_PATH, true);
                break;
        }
    }

    private String inputChoice() {
        System.out.println("Enter choice: ");
        String choice = scanner.nextLine();
        return checkRegex(choice, CHOICE_REGEX, "Only input 1 or 2 or 3");
    }

    private String inputId() {
        boolean check = true;
        String id;
        do {
            System.out.println("Enter customer id: ");
            id = scanner.nextLine();
            for(Customer list: customerList) {
                if(!id.equals(list.getId())) {
                    check = false;
                }
                else {
                    check = true;
                    System.out.println("Id is duplicate, please input other id: ");
                    break;
                }
            }
        } while (check);
        return checkRegex(id, ID_REGEX, "Wrong format," +
                "please input like form: KHVN-00000/KHNN-00000");
    }

    private String inputName() {
        System.out.println("Enter name: ");
        String name = scanner.nextLine();
        return checkRegex(name, NAME_REGEX, "Wrong format, first word is capital");
    }

    private String inputUsageLevel() {
        System.out.println("Enter getUsage");
        String usageLevel = scanner.nextLine();
        return checkRegex(usageLevel, INT_REGEX, "Please input positive");
    }

    public static String inputNational() {
        System.out.println("Enter national");
        String nation = scanner.nextLine();
        return checkRegex(nation, NAME_REGEX, "Wrong format, first word is capital");
    }

    public String getType() {
        int choice;
        String type = "";
        List< String > stringList = readFile(TYPE_PATH);
        System.out.println("Choice type of customer: " +
                " 1:LKH-001,Sinh Hoat \n" +
                " 2:LKH-002,Kinh doanh\n" +
                " 3:LKH-003,Sản xuất\n: ");
        choice = Integer.parseInt(inputChoice());
        switch (choice) {
            case 1:
                for (String string : stringList) {
                    String[] temp = string.split(",");
                    if (temp[0].contains("001")) {
                        type = temp[1];
                        break;
                    }
                }
                break;
            case 2:
                for (String string : stringList) {
                    String[] temp = string.split(",");
                    if (temp[0].contains("002")) {
                        type = temp[1];
                        break;
                    }
                }
                break;
            case 3:
                for (String string : stringList) {
                    String[] temp = string.split(",");
                    if (temp[0].contains("003")) {
                        type = temp[1];
                        break;
                    }
                }
                break;
        }
        return type;
    }

    @Override
    public void display() {
        for (int i = 0; i < customerList.size(); i++) {
            System.out.println((i + 1) + ";" + customerList.get(i).toString());
        }

    }

    @Override
    public void edit() {
    }

    @Override
    public void search() {
        System.out.println("Enter name search");
        String name = scanner.nextLine();
        List< Customer > list = new ArrayList<>();
        for (Customer customer : customerList) {
            if (customer.getName().contains(name)) {
                list.add(customer);
            }
        }
        if (list.size() == 0) {
            System.out.println("Not found");
        } else {
            for (Customer customer : list) {
                System.out.println(customer.toString());
            }
        }
    }
}
