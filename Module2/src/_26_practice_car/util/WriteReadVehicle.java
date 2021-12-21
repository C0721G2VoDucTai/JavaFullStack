package _26_practice_car.util;

import _25_practice2.model.MovieShowTimes;
import _26_practice_car.model.Car;
import _26_practice_car.model.Motorbike;
import _26_practice_car.model.Vans;
import _26_practice_car.model.Vehicle;

import java.util.ArrayList;
import java.util.List;

import static _25_practice2.util.ReadAndWrite.readFile;
import static _26_practice_car.util.WriteAndRead.writeFile;

public class WriteReadVehicle {
    public static void writeVans(List< Vans > vansList, String path, boolean append) {
        List< String > stringList = new ArrayList<>();
        for (Vans vans : vansList) {
            stringList.add(vans.getVan());
        }
        writeFile(stringList, path, append);
    }

    public static void writeMotorbike(List< Motorbike > motorbikeList, String path, boolean append) {
        List< String > stringList = new ArrayList<>();
        for (Motorbike motorbike : motorbikeList) {
            stringList.add(motorbike.getMotorBike());
        }
        writeFile(stringList, path, append);
    }

    public static void writeCar(List< Car > carList, String path, boolean append) {
        List< String > stringList = new ArrayList<>();
        for (Car car : carList) {
            stringList.add(car.getCar());
        }
        writeFile(stringList, path, append);
    }

    public static List< Motorbike > readMotorbike(String path) {
        List< String > stringList = readFile(path);
        List< Motorbike > motorbikeList = new ArrayList<>();
        for (String string : stringList) {
            String[] temp = string.split(",");
            Motorbike motorbike = new Motorbike(temp[0], temp[1], temp[2], temp[3],
                    Integer.parseInt(temp[4]));
            motorbikeList.add(motorbike);
        }
        return motorbikeList;
    }
    public static List< Car > readCar(String path) {
        List< String > stringList = readFile(path);
        List< Car > carList = new ArrayList<>();
        for (String string : stringList) {
            String[] temp = string.split(",");
            Car car = new Car(temp[0], temp[1], temp[2], temp[3],
                    Integer.parseInt(temp[4]), temp[5]);
            carList.add(car);
        }
        return carList;
    }
    public static List< Vans > readVans(String path) {
        List< String > stringList = readFile(path);
        List< Vans > vansList = new ArrayList<>();
        for (String string : stringList) {
            String[] temp = string.split(",");
            Vans vans = new Vans(temp[0], temp[1], temp[2], temp[3],
                    Integer.parseInt(temp[4]));
            vansList.add(vans);
        }
        return vansList;
    }


}

