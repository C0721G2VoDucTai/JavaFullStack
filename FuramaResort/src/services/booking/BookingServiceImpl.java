package services.booking;

import models.booking.Booking;
import models.facillity.Facility;
import models.person.Customer;
import services.customer.CustomerServiceImpl;
import services.facility.FacilityServiceImpl;

import java.io.File;
import java.util.*;

import static services.booking.ReadBookingDara.readFileBooking;
import static services.booking.WriteBookingData.writeFileBooking;
import static services.customer.CustomerServiceImpl.CUSTOMER_PATH;
import static services.customer.ReadCustomerData.readFileCustomer;
import static services.facility.FacilityServiceImpl.*;
import static services.facility.ReadFacilityData.readFileFacility;
import static services.facility.WriteFacilityData.writeFileFacility;

public class BookingServiceImpl implements BookingService {
    public static final String BOOKING_PATH = "src\\data\\booking_data.csv";
    File file = new File(BOOKING_PATH);
    File fileFacility = new File(FACILITY_PATH);
    Set< Booking > bookingList = readFileBooking(BOOKING_PATH);

    @Override
    public void add() {
        Scanner scanner = new Scanner(System.in);
        FacilityServiceImpl facilityService = new FacilityServiceImpl();
        facilityService.display();
        CustomerServiceImpl customerService = new CustomerServiceImpl();
        List< Customer > customerList = readFileCustomer(CUSTOMER_PATH);
        Map< Facility, Integer > facilityList = readFileFacility(FACILITY_PATH);
        System.out.println("Customer Service information and facility: ");
        customerService.display();
        System.out.println("Enter index Customer: ");
        int index = Integer.parseInt(scanner.nextLine());
        System.out.println("Enter id booking");
        int idBooking = Integer.parseInt(scanner.nextLine());
        System.out.println("Enter start day");
        String startDay = scanner.nextLine();
        System.out.println("Enter end day");
        String endDay = scanner.nextLine();
        Customer customer = customerList.get(index - 1);
        facilityService.display();
        System.out.println("Enter id facility ");
        String idFacility = scanner.nextLine();
        Facility facility = new Facility();
        for (Map.Entry< Facility, Integer > map : facilityList.entrySet()) {
            if (map.getKey().getIdFacility().equals(idFacility)) {
                facility = map.getKey();
                map.setValue(map.getValue() + 1);
                fileFacility.delete();
                writeFileFacility(facilityList, FACILITY_PATH, true);
            }
        }
        System.out.println("Enter type of service ");
        String typeOfService = scanner.nextLine();
        Booking booking = new Booking(idBooking, startDay, endDay, customer, facility, typeOfService);
        file.delete();
        bookingList.add(booking);
        writeFileBooking(bookingList, BOOKING_PATH, true);
        if (!idFacility.equals("RO")) {
            System.out.println("A new booking has created please creat new contract");
        }
    }

    @Override
    public void display() {
        for (Booking bookings : bookingList) {
            System.out.println(bookings.toString());
        }
    }

    @Override
    public void edit() {

    }
}
