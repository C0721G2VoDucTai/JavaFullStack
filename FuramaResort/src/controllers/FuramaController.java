package controllers;

import services.booking.BookingServiceImpl;
import services.contract.ContractServiceImpl;
import services.customer.CustomerServiceImpl;
import services.employee.EmployeeServiceImpl;
import services.facility.FacilityServiceImpl;
import services.promotion.PromotionServiceImpl;
import utils.WrongFormatException;

import java.util.Scanner;

public class FuramaController {
    public static void main(String[] args) {
        EmployeeServiceImpl employeeManagement = new EmployeeServiceImpl();
        CustomerServiceImpl customerService = new CustomerServiceImpl();
        FacilityServiceImpl facilityService = new FacilityServiceImpl();
        BookingServiceImpl bookingService = new BookingServiceImpl();
        ContractServiceImpl contactService = new ContractServiceImpl();
        PromotionServiceImpl promotionService = new PromotionServiceImpl();
        Scanner scanner = new Scanner(System.in);
        boolean flag = true;
        while (flag) {
            System.out.println("Menu:\n" +
                    "1. Employee Management " +
                    "2. Customer Management " +
                    "3. Facility Management " +
                    "4. Booking Management " +
                    "5. Promotion Management " +
                    "6. Exit ");
            int choice;
            try {
                System.out.println("Enter your choose: ");
                choice = Integer.parseInt(scanner.nextLine());
                switch (choice) {
                    case 1:
                        boolean flag1 = true;
                        while (flag1) {
                            System.out.println("Menu employees: " +
                                    "1. Display list employees " +
                                    "2. Add new employee " +
                                    "3. Edit employee " +
                                    "4	Return main menu ");
                                System.out.println("Enter your choose: ");
                                choice = Integer.parseInt(scanner.nextLine());
                                switch (choice) {
                                    case 1:
                                        employeeManagement.display();
                                        break;
                                    case 2:
                                        employeeManagement.add();
                                        break;
                                    case 3:
                                        employeeManagement.edit();
                                        break;
                                    case 4:
                                        flag1 = false;
                                        break;
                                }
                        }
                        break;
                    case 2:
                        boolean flag2 = true;
                        while (flag2) {
                            System.out.println("Menu customers:" +
                                    "1. Display list customers" +
                                    "2. Add new customer" +
                                    "3. Edit customer" +
                                    "4	Return main menu");
                            choice = Integer.parseInt(scanner.nextLine());
                            switch (choice) {
                                case 1:
                                    customerService.display();
                                    break;
                                case 2:
                                    customerService.add();
                                    break;
                                case 3:
                                    customerService.edit();
                                    break;
                                case 4:
                                    flag2 = false;
                                    break;
                            }
                        }
                        break;
                    case 3:
                        boolean flag3 = true;
                        while (flag3) {
                            System.out.println("Menu facility: " +
                                    "1. Display list facility " +
                                    "2. Add new facility " +
                                    "3. Display maintenance " +
                                    "4	Return main menu ");
                            choice = Integer.parseInt(scanner.nextLine());
                            switch (choice) {
                                case 1:
                                    facilityService.display();
                                    break;
                                case 2:
                                    facilityService.add();
                                    break;
                                case 3:
                                    facilityService.displayMaintenance();
                                    break;
                                case 4:
                                    flag3 = false;
                                    break;
                            }
                        }
                        break;
                    case 4:
                        boolean flag4 = true;
                        while (flag4) {
                            System.out.println("Menu booking: " +
                                    "1. Add new booking " +
                                    "2. Display list booking " +
                                    "3. Create new contracts " +
                                    "4. Display list contracts " +
                                    "5. Edit contracts " +
                                    "6	Return main menu ");
                          choice = Integer.parseInt(scanner.nextLine());
                            switch (choice) {
                                case 1:
                                    bookingService.add();
                                    break;
                                case 2:
                                    bookingService.display();
                                    break;
                                case 3:
                                    contactService.add();
                                    break;
                                case 4:
                                    contactService.display();
                                    break;
                                case 5:
                                    contactService.edit();
                                    break;
                                case 6:
                                    flag4 = false;
                                    break;
                            }
                        }
                        break;
                    case 5:
                        boolean flag5 = true;
                        while (flag5) {
                            System.out.println("Menu:" +
                                    "1. Display list customers use service " +
                                    "2. Display list customers get voucher " +
                                    "3	Return main menu ");
                            choice = Integer.parseInt(scanner.nextLine());
                            switch (choice) {
                                case 1:
                                    promotionService.display();
                                    break;
                                case 2:
                                    promotionService.presentVoucher();
                                    break;
                                case 3:
                                    flag5 = false;
                                    break;
                            }
                        }
                        break;
                    case 6:
                        flag = false;
                        break;
                }
            } catch (NumberFormatException e) {
                System.out.println("Please enter number like menu: ");
//            }catch (WrongFormatException e) {
//                System.out.println("Please enter like request: ");
            }
        }
    }
}
