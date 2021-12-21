package _26_practice_car.service;

import _24_practice.management.Management;
import _24_practice.model.Customer;
import _24_practice.model.ForeignerCustomer;
import _26_practice_car.model.Car;
import _26_practice_car.model.Motorbike;
import _26_practice_car.model.Vans;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import static _24_practice.util.WriteFileCustomer.writeFileCustomer;
import static _25_practice2.management.Management.NAME_REGEX;
import static _25_practice2.util.ReadAndWrite.readFile;
import static _26_practice_car.model.Car.BUS;
import static _26_practice_car.model.Car.TRAVEL;
import static _26_practice_car.util.CheckRegexVehicle.*;
import static _26_practice_car.util.WriteReadVehicle.*;

public class ManagementVehicle implements Managements {
    public static final String VANS_PATH = "src\\_26_practice_car\\data\\vans_data.csv";
    public static final String CAR_PATH = "src\\_26_practice_car\\data\\car_data.csv";
    public static final String MOTOR_PATH = "src\\_26_practice_car\\data\\motor_bike_data.csv";
    public static final String BRAND_PATH = "src\\_24_practice\\data\\brand_data.csv";
    File fileVans = new File(VANS_PATH);
    File fileCar = new File(CAR_PATH);
    File fileMotor = new File(MOTOR_PATH);
    List<String> stringList = readFile(BRAND_PATH);
    List< Motorbike > motorbikeList = readMotorbike(MOTOR_PATH);
    List< Car > carList = readCar(CAR_PATH);
    List< Vans > vansList = readVans(VANS_PATH);
    Scanner sc = new Scanner(System.in);

    @Override
    public void add() {
        String choice;
        System.out.println("Choice type of vehicle: \n" +
                " 1: Vans: \n" +
                " 1: Car: \n" +
                " 2: Motorbike: \n");

        choice = sc.nextLine();
        switch (choice) {
            case "1":
                Vans vans = new Vans(getId(), getBrand(), getYearProduct(), getOwner(),
                        Integer.parseInt(getWeight()));

                vansList.add(vans);
                fileVans.delete();
                writeVans(vansList, VANS_PATH, true);
                break;
            case "2":
                Motorbike motorbike = new Motorbike(getId(), getBrand(), getYearProduct(), getOwner(),
                        Integer.parseInt(getWattage()));
                fileMotor.delete();
                writeMotorbike(motorbikeList, MOTOR_PATH, true);
                break;
            case "3":
                Car car = new Car(getId(), getBrand(), getYearProduct(), getOwner(),
                        Integer.parseInt(getNumberSeat()), getType());
                fileCar.delete();
                writeCar(carList, CAR_PATH, true);
                break;
        }
    }


    @Override
    public void display() {
        System.out.println("********List Vehicle*********");
        String choice;
        System.out.println("Choice list type of vehicle : \n" +
                " 1: Vans: \n" +
                " 1: Car: \n" +
                " 2: Motorbike: \n");
        choice = sc.nextLine();
        switch (choice) {
            case "1":
                displayVans();
                break;
            case "2":
                displayCar();
                break;
            case "3":
                displayMotor();
                break;
        }
    }

    @Override
    public void delete() {
        String choice;
        System.out.println("Choice delete type of vehicle : \n" +
                " 1: Vans: \n" +
                " 1: Car: \n" +
                " 2: Motorbike: \n");
        choice = sc.nextLine();
        switch (choice) {
            case "1":
                displayVans();
                System.out.println("Enter id delete:");
                String id = sc.nextLine();
                for (int i = 0; i < vansList.size(); i++) {
                    if (id.equals(vansList.get(i).getId())) {
                        String choiceDelete;
                        System.out.println("Do you want to delete? \n" +
                                "Choice 1. to delete\n" +
                                "Choice 2. to return menu");
                        choiceDelete = sc.nextLine();
                        if (choiceDelete.equals("1")) {
                            vansList.remove(vansList.get(i));
                            System.out.println("Delete success");
                            break;
                        } else {
                            break;
                        }
                    }
                }
                fileVans.delete();
                writeVans(vansList, VANS_PATH, true);
                break;
            case "2":
                displayCar();
                System.out.println("Enter id delete:");
                String idCar = sc.nextLine();
                for (int i = 0; i < carList.size(); i++) {
                    if (idCar.equals(carList.get(i).getId())) {
                        String choiceDelete;
                        System.out.println("Do you want to delete? \n" +
                                "Choice 1. to delete\n" +
                                "Choice 2. to return menu");
                        choiceDelete = sc.nextLine();
                        if (choiceDelete.equals("1")) {
                            carList.remove(carList.get(i));
                            System.out.println("Delete success");
                            break;
                        } else {
                            break;
                        }
                    }
                }
                fileCar.delete();
                writeCar(carList, CAR_PATH, true);
                break;
            case "3":
                displayMotor();
                System.out.println("Enter id delete:");
                String idMotor = sc.nextLine();
                for (int i = 0; i < motorbikeList.size(); i++) {
                    if (idMotor.equals(motorbikeList.get(i).getId())) {
                        String choiceDelete;
                        System.out.println("Do you want to delete? \n" +
                                "Choice 1. to delete\n" +
                                "Choice 2. to return menu");
                        choiceDelete = sc.nextLine();
                        if (choiceDelete.equals("1")) {
                            motorbikeList.remove(motorbikeList.get(i));
                            System.out.println("Delete success");
                            break;
                        } else {
                            break;
                        }
                    }
                }
                fileMotor.delete();
                writeMotorbike(motorbikeList, MOTOR_PATH, true);
                break;
            case "4":
        }

    }

    @Override
    public void edit() {

    }

    @Override
    public void search() {

    }

    private String getId() {
        System.out.println("Enter Id: ");
        String id = sc.nextLine();
        return id;
    }

    private String getBrand() {
        System.out.println("*********List brand name*******");
        for(String string : stringList) {
            System.out.println(string.toString());
        }
        System.out.println("Enter brand name form list: ");
        String brand = sc.nextLine();
        return checkRegex(brand, NAME_REGEX, "Wrong format");
    }

    private String getYearProduct() {
        System.out.println("Enter Year product: ");
        String year = sc.nextLine();
        return checkRegex(year, YEAR_RG, "Wrong format (YYYY)");
    }

    private String getOwner() {
        System.out.println("Enter owner name ");
        String owner = sc.nextLine();
        return checkRegex(owner, NAME_REGEX, "Wrong format");
    }

    private String getNumberSeat() {
        System.out.println("Enter number of seat: ");
        String numberSeat = sc.nextLine();
        return checkRegex(numberSeat, INT_REGEX, "Wrong format");
    }

    private String getWeight() {
        System.out.println("Enter weight: ");
        String weight = sc.nextLine();
        return checkRegex(weight, INT_REGEX, "Wrong format");
    }

    private String getWattage() {
        System.out.println("Enter wattage: ");
        String wattage = sc.nextLine();
        return checkRegex(wattage, INT_REGEX, "Wrong format");
    }

    private String getType() {
        String type = "";
        String choice;
        System.out.println("Choice type of car: \n" +
                " 1: travel: \n" +
                " 2: bus: \n");
        choice = sc.nextLine();
        switch (choice) {
            case "1":
                type = TRAVEL;
                break;
            case "2":
                type = BUS;
                break;
        }
        return type;
    }

    public void displayVans() {
        for (Vans vans : vansList) {
            System.out.println(vans.toString());
        }
    }

    public void displayCar() {
        for (Car car : carList) {
            System.out.println(car.toString());
        }
    }

    public void displayMotor() {
        for (Motorbike motorbike : motorbikeList) {
            System.out.println(motorbike.toString());
        }
    }

}
