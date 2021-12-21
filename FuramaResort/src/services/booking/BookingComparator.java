package services.booking;

import models.booking.Booking;

import java.util.Comparator;

public class BookingComparator implements Comparator< Booking > {

    @Override
    public int compare(Booking o1, Booking o2) {
//        String [] temp1 = o1.getStartDay().split("/");
//        String [] temp2 = o2.getStartDay().split("/");
//        if(temp1[2].compareTo(temp2[2]) ==0) {
//            if(temp1[1].compareTo(temp2[1]) ==0) {
//                    return  temp1[0].compareTo(temp2[0]);
//                }
//            else {
//                return temp1[2].compareTo(temp2[2]);
//                }
//            }
//        else {
//            return temp1[2].compareTo(temp2[2]);
//        }
//        }
        if (o1.getStartDay().compareTo(o2.getStartDay()) == 0) {
            return o1.getEndDay().compareTo(o2.getEndDay());
        } else {
            return o1.getStartDay().compareTo(o2.getStartDay());
        }
    }
}
