package _11_dsa_stack_queue.optional.to_chuc_du_lieu_hop_ly;

import java.util.ArrayList;
import java.util.ArrayDeque;
import java.util.Queue;


public class Management {
    public static void main(String[] args) {
        ArrayList< Staff > staffList = new ArrayList();
        Staff staff1 = new Staff("Nguyen Van A", "Nam", "01/01/1995");
        Staff staff2 = new Staff("Nguyen Van B", "Nữ", "02/01/1995");
        Staff staff3 = new Staff("Nguyen Van C", "Nữ", "03/01/1995");
        Staff staff4 = new Staff("Nguyen Thi D", "Nam", "04/01/1995");
        Staff staff5 = new Staff("Nguyen Thi E", "Nữ", "05/01/1995");
        Staff staff6 = new Staff("Nguyen Thi F", "Nam", "05/01/1995");
        staffList.add(staff1);
        staffList.add(staff2);
        staffList.add(staff3);
        staffList.add(staff4);
        staffList.add(staff5);
        staffList.add(staff6);
        Queue< Staff > queueMale = new ArrayDeque();
        Queue< Staff > queueFemale = new ArrayDeque();
        for (int i = 0; i < staffList.size(); i++) {
            if ((staffList.get(i).getSex()).equals("Nam")) {
                queueMale.add(staffList.get(i));
            } else {
                queueFemale.add(staffList.get(i));
            }
        }
        for (int i = 0; i < staffList.size(); i++) {
            if (queueFemale.size() != 0) {
                staffList.set(i, queueFemale.poll());
            } else {
                staffList.set(i, queueMale.poll());
            }
        }
        for (int i = 0; i < staffList.size(); i++) {
            System.out.println(staffList.get(i));
        }
    }
}
