package services.customer;

import models.person.Customer;

import java.io.File;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

import static services.customer.ReadCustomerData.readFileCustomer;
import static services.customer.WriteCustomerData.writeFileCustomer;

public class CustomerServiceImpl implements CustomerService {
    public static final String CUSTOMER_PATH = "src\\data\\customer_data.csv";
    List< Customer > customerList = (LinkedList< Customer >) readFileCustomer(CUSTOMER_PATH);
    Scanner scanner = new Scanner(System.in);

    @Override
    public void add() {
        System.out.println("Enter id");
        int id = Integer.parseInt(scanner.nextLine());
        System.out.println("Enter name");
        String name = String.valueOf(Integer.parseInt(scanner.nextLine()));
        System.out.println("Enter birthDay");
        String birthDay = scanner.nextLine();
        System.out.println("Enter sex");
        String sex = scanner.nextLine();
        System.out.println("Enter id Card");
        String idCard = scanner.nextLine();
        System.out.println("Enter phone number");
        String phoneNumber = scanner.nextLine();
        System.out.println("Enter email");
        String email = scanner.nextLine();
        System.out.println("Enter type of customer");
        String typeCustomer = scanner.nextLine();
        System.out.println("Enter address");
        String address = scanner.nextLine();
        Customer customer = new Customer(id, name, birthDay, sex, idCard,
                phoneNumber, email, typeCustomer, address);
        customerList.add(customer);
        File file = new File(CUSTOMER_PATH);
        file.delete();
        writeFileCustomer(customerList, CUSTOMER_PATH, true);
    }

    @Override
    public void display() {
        for (int i = 0; i < customerList.size(); i++) {
            System.out.println((i + 1) + " " + customerList.get(i).toString());
        }
    }

    @Override
    public void edit() {
        System.out.println("Enter id of employee you want to edit");
        int editId = Integer.parseInt(scanner.nextLine());
        for (Customer customer : customerList) {
            if (customer.getId() == editId) {
                System.out.println("Enter new id");
                int id = Integer.parseInt(scanner.nextLine());
                System.out.println("Enter new name");
                String name = String.valueOf(Integer.parseInt(scanner.nextLine()));
                System.out.println("Enter new birthDay");
                String birthDay = scanner.nextLine();
                System.out.println("Enter new sex");
                String sex = scanner.nextLine();
                System.out.println("Enter new id card");
                String idCard = scanner.nextLine();
                System.out.println("Enter new phone number");
                String phoneNumber = scanner.nextLine();
                System.out.println("Enter new email");
                String email = scanner.nextLine();
                System.out.println("Enter type of customer");
                String typeCustomer = scanner.nextLine();
                System.out.println("Enter address");
                String address = scanner.nextLine();
                customer.setId(id);
                customer.setName(name);
                customer.setBirthDay(birthDay);
                customer.setSex(sex);
                customer.setIdCard(idCard);
                customer.setPhoneNumber(phoneNumber);
                customer.setEmail(email);
                customer.setTypeCustomer(typeCustomer);
                customer.setAddress(address);
            }
        }
        File file = new File(CUSTOMER_PATH);
        file.delete();
        writeFileCustomer(customerList, CUSTOMER_PATH, true);
    }
}
