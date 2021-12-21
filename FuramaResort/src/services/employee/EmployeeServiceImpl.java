package services.employee;

import models.person.Customer;
import models.person.Employee;
import java.awt.*;
import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import static services.employee.ReadEmployeeData.readFileEmployee;
import static services.employee.WriteEmployeeData.writeFileEmployee;
import static utils.ReadAndWriterFIle.readFile;
import static utils.ReadAndWriterFIle.writeFile;

public class EmployeeServiceImpl implements EmployeeService {
    public static final String EMPLOYEE_PATH = "src\\data\\employee_data.csv";
    List<Employee> employeeList = readFileEmployee(EMPLOYEE_PATH);
    @Override
    public void add() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter id");
        int id = Integer.parseInt(scanner.nextLine());
        System.out.println("Enter name");
        String name = scanner.nextLine();
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
        System.out.println("Enter education level");
        String educationLevel = scanner.nextLine();
        System.out.println("Enter position");
        String position = scanner.nextLine();
        System.out.println("Enter salary");
        Double salary = Double.valueOf(scanner.nextLine());
        Employee employee = new Employee(id, name, birthDay, sex, idCard,
                phoneNumber, email, educationLevel, position, salary);
        employeeList.add(employee);
        File file = new File(EMPLOYEE_PATH);
        file.delete();
        writeFileEmployee(employeeList, EMPLOYEE_PATH, true);
    }

    @Override
    public void display() {
        for (Employee employee : employeeList) {
            System.out.println(employee.toString());
        }
    }

    @Override
    public void edit() {
        display();
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter id of employee you want to edit");
        int editId = Integer.parseInt(scanner.nextLine());
        for (Employee employee : employeeList) {
            if ((employee.getId() == editId)) {
                System.out.println("Enter new id");
                int id = Integer.parseInt(scanner.nextLine());
                System.out.println("Enter new name");
                String name = scanner.nextLine();
                System.out.println("Enter new birthDay");
                String birthDay = scanner.nextLine();
                System.out.println("Enter new sex");
                String sex = scanner.nextLine();
                System.out.println("Enter new id Card");
                String idCard = scanner.nextLine();
                System.out.println("Enter new phone number");
                String phoneNumber = scanner.nextLine();
                System.out.println("Enter new email");
                String email = scanner.nextLine();
                System.out.println("Enter new education level");
                String educationLevel = scanner.nextLine();
                System.out.println("Enter new position");
                String position = scanner.nextLine();
                System.out.println("Enter new  salary");
                Double salary = Double.parseDouble(scanner.nextLine());
                employee.setId(id);
                employee.setName(name);
                employee.setBirthDay(birthDay);
                employee.setSex(sex);
                employee.setIdCard(idCard);
                employee.setPhoneNumber(phoneNumber);
                employee.setEmail(email);
                employee.setEducationLevel(educationLevel);
                employee.setPosition(position);
                employee.setSalary(salary);
            }
        }
        File file = new File(EMPLOYEE_PATH);
        file.delete();
        writeFileEmployee(employeeList,EMPLOYEE_PATH,true);
    }
}