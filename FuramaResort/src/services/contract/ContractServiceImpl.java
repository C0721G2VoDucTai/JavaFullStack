package services.contract;

import models.booking.Booking;
import models.contract.Contract;
import services.booking.BookingComparator;

import java.io.File;
import java.util.*;

import static services.booking.BookingServiceImpl.BOOKING_PATH;
import static services.booking.ReadBookingDara.readFileBooking;
import static services.contract.ReadContractData.readFileContract;
import static services.contract.WriteContractData.writeFileContract;

public class ContractServiceImpl implements ContractService {
    File file = new File(CONTRACT_PATH);
    List< Contract > contractList = readFileContract(CONTRACT_PATH);
    public static final String CONTRACT_PATH = "src\\data\\contract_data.csv";
    Scanner scanner = new Scanner(System.in);
    @Override
    public void add() {
        Queue< Booking > newListBooking = new ArrayDeque<>();
        Set<Booking> bookingList = readFileBooking(BOOKING_PATH);
        newListBooking.addAll(bookingList);
//        System.out.println(newListBooking);
        while (newListBooking.size() >0) {
            if (newListBooking.peek().getTypeOfService().equals("Room")) {
                newListBooking.poll();
            }
            else {
                System.out.println(newListBooking.peek());
                System.out.println("Enter id contract");
                int idContract = Integer.parseInt(scanner.nextLine());
                int idBooking = newListBooking.peek().getIdBooking();
                System.out.println("Enter deposit");
                double deposit = Double.parseDouble(scanner.nextLine());
                System.out.println("Enter total pay");
                double totalPay = Double.parseDouble(scanner.nextLine());
                int idCustomer = newListBooking.poll().getCustomer().getId();
                Contract contract = new Contract(idContract, idBooking, deposit, totalPay, idCustomer);
                contractList.add(contract);
                file.delete();
                writeFileContract(contractList, CONTRACT_PATH, true);
            }
        }
    }

    @Override
    public void display() {
        for (Contract contracts : contractList) {
            System.out.println(contracts.toString());
        }
    }

    @Override
    public void edit() {
        List< Contract > contractList = readFileContract(CONTRACT_PATH);
        boolean flag = true;
        System.out.println("Enter id name of edit contract");
        int editId = Integer.parseInt(scanner.nextLine());
        for (Contract contracts : contractList) {
            if (contracts.getIdContract() == editId) {
                System.out.println("Enter new id contract");
                int idContract = Integer.parseInt(scanner.nextLine());
                System.out.println("Enter new id booking");
                int idBooking = Integer.parseInt(scanner.nextLine());
                System.out.println("Enter new deposit");
                double deposit = Double.parseDouble(scanner.nextLine());
                System.out.println("Enter new total pay");
                double totalPay = Double.parseDouble(scanner.nextLine());
                System.out.println("Enter new id customer");
                int idCustomer = Integer.parseInt(scanner.nextLine());
                contracts.setIdContract(idContract);
                contracts.setIdBooking(idBooking);
                contracts.setDeposit(deposit);
                contracts.setTotalPay(totalPay);
                contracts.setIdCostumer(idCustomer);
                contracts.toString();
                break;
            } else {
                flag = false;
            }
        }
        if (!flag) {
            System.out.println("Not find contract");
        }
    }
}
