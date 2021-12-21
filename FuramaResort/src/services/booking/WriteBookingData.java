package services.booking;

import models.booking.Booking;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import static utils.ReadAndWriterFIle.writeFile;

public class WriteBookingData {
    public static void writeFileBooking(Set< Booking > bookingList, String path, boolean append) {
        List< String > stringList = new ArrayList<>();
        for (Booking booking : bookingList) {
            stringList.add(booking.getInformationBooking());
        }
        writeFile(stringList, path, append);
    }
}
