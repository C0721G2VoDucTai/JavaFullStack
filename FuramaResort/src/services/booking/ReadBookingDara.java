package services.booking;

import models.booking.Booking;
import models.facillity.Facility;
import models.person.Customer;

import java.util.*;

import static services.customer.CustomerServiceImpl.CUSTOMER_PATH;
import static services.customer.ReadCustomerData.readFileCustomer;
import static services.facility.FacilityServiceImpl.*;
import static services.facility.ReadFacilityData.readFileFacility;
import static utils.ReadAndWriterFIle.readFile;

public class ReadBookingDara {
    public static Set< Booking > readFileBooking(String path) {
        List< String > stringList = readFile(path);
        Set< Booking > bookingList = new TreeSet< Booking >(new BookingComparator());
        List< Customer > customerList = readFileCustomer(CUSTOMER_PATH);
        Map< Facility, Integer > facilityList = readFileFacility(FACILITY_PATH);
        for (String string : stringList) {
            String[] temp = string.split(",");
            Customer customer = new Customer();
            for (Customer customer1 : customerList) {
                if (customer1.getId() == Integer.parseInt(temp[3])) {
                    customer = customer1;
                }
            }
            Facility facility = new Facility();
            for (Map.Entry< Facility, Integer > map : facilityList.entrySet()) {
                if (map.getKey().getServiceName().equals(temp[4])) {
                    facility = map.getKey();
                }
            }
            Booking booking = new Booking(Integer.parseInt(temp[0]), temp[1], temp[2], customer, facility,
                    temp[5]);
            bookingList.add(booking);
        }
        return bookingList;
    }
}
