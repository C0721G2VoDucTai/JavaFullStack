package services.facility;

import models.facillity.Facility;
import models.facillity.House;
import models.facillity.Room;
import models.facillity.Villa;
import utils.WrongFormatException;

import java.awt.*;
import java.io.File;
import java.util.*;
import java.util.List;

import static services.facility.WriteFacilityData.writeFileFacility;
import static services.facility.ReadFacilityData.readFileFacility;
import static utils.RegexCheck.*;

public class FacilityServiceImpl implements FacilityService {
    public static final String FACILITY_PATH = "src\\data\\facility_data.csv";
    private static final String REGEX_ID = "^SV(VL|HO|RO)\\d{4}$";
    private static final String REGEX_NAME = "^[A-Z](\\w+\\s?)*$";
    private static final String REGEX_AREA = "^([3-9][1-9]|[1-9]\\d{2,}).?\\d*$";
    private static final String REGEX_INT = "^[1-9]|[1][0-9]+$";
    private static final String REGEX_PERSON = "^[1-9]|[1][0-9]$";
    private static final String REGEX_CHOICE = "^[1-3]$";
    File file = new File(FACILITY_PATH);
    Map< Facility, Integer > facilityList = readFileFacility(FACILITY_PATH);
    Scanner scanner = new Scanner(System.in);

    @Override
    public void add() {

        System.out.println("Choice type of facility: " +
                " 1:Room,\n" +
                " 2: House,\n" +
                " 3: Villa");
        int choice = Integer.parseInt(inputChoice());
        switch (choice) {
            case 1:
                Facility facility1 = new Room(inputId(), inputServiceName(), Double.parseDouble(inputArea()),
                        Double.parseDouble(inputCostRent()), Integer.parseInt(inputPersonNumber()),
                        inputTypeRent(), inputFreeService());
                file.delete();
                facilityList.put(facility1, 0);
                writeFileFacility(facilityList, FACILITY_PATH, true);
                break;
            case 2:
                Facility facility2 = new House(inputId(), inputServiceName(), Double.parseDouble(inputArea()),
                        Double.parseDouble(inputCostRent()), Integer.parseInt(inputPersonNumber()),
                        inputTypeRent(), inputStandard(), Integer.parseInt(inputFloor()));
                file.delete();
                facilityList.put(facility2, 0);
                writeFileFacility(facilityList, FACILITY_PATH, true);
                break;
            case 3:
                Facility facility3 = new Villa(inputId(), inputServiceName(), Double.parseDouble(inputArea()),
                        Double.parseDouble(inputCostRent()), Integer.parseInt(inputPersonNumber()),
                        inputTypeRent(), inputStandard(), Double.parseDouble(inputPoolArea()), Integer.parseInt(inputFloor()));
                file.delete();
                facilityList.put(facility3, 0);
                writeFileFacility(facilityList, FACILITY_PATH, true);
        }
    }

    private String inputChoice() {
        System.out.println("Enter choice: ");
        String choice = scanner.nextLine();
        return checkRegex(choice, REGEX_CHOICE, "Only input 1 or 2 or 3");
    }

    private String inputId() {
        boolean check = true;
        String id;
        do {
            System.out.println("Enter facility id: ");
            id = scanner.nextLine();
            for (Map.Entry< Facility, Integer > map : facilityList.entrySet()) {
                if (!map.getKey().getIdFacility().equals(id)) {
                    check = false;
                } else {
                    check = true;
                    System.out.println("Id is duplicate , please input other id: ");
                    break;
                }
            }
        } while (check);
        return checkRegex(id, REGEX_ID, "Wrong format, please input like: SVVL1001/SVRO1000/SVHO1000");
    }

    private String inputServiceName() {
        System.out.println("Enter Service name: ");
        String serviceName = scanner.nextLine();
        return checkRegex(serviceName, REGEX_NAME, "Wrong format, first word is capital");
    }

    private String inputArea() {
        System.out.println("Enter area ");
        String area = scanner.nextLine();
        return checkRegex(area, REGEX_AREA, "Area >30");
    }

    private String inputPersonNumber() {
        System.out.println("Enter person number ");
        String personNumber = scanner.nextLine();
        return checkRegex(personNumber, REGEX_PERSON, "Area have to better than 20");
    }

    private String inputCostRent() {
        System.out.println("Enter cost rent ");
        String costRent = scanner.nextLine();
        return checkRegex(costRent, REGEX_INT, "Cost rent  have to positive");
    }

    private String inputTypeRent() {
        System.out.println("Enter cost type of rent ");
        String typeOfRent = scanner.nextLine();
        return checkRegex(typeOfRent, REGEX_NAME, "Wrong format, first word is capital");
    }

    private String inputStandard() {
        System.out.println("Enter add Standard: ");
        String standard = scanner.nextLine();
        return checkRegex(standard, REGEX_NAME, "Wrong format, first word is capital");
    }

    private String inputPoolArea() {
        System.out.println("Enter pool area: ");
        String poolArea = scanner.nextLine();
        return checkRegex(poolArea, REGEX_AREA, "Area >30");
    }

    private String inputFloor() {
        System.out.println("Enter number of floor: ");
        String numberOfFloor = scanner.nextLine();
        return checkRegex(numberOfFloor, REGEX_PERSON, " Number of floor have to positive");
    }

    private String inputFreeService() {
        System.out.println("Enter free service: ");
        String freeService = scanner.nextLine();
        return checkRegex(freeService, REGEX_NAME, "Wrong format, first word is capital");
    }

    @Override
    public void display() {
        for (Map.Entry< Facility, Integer > map : facilityList.entrySet()) {
            System.out.println(map.getKey().toString() + "," + map.getValue());
//            if (map.getKey() instanceof Room) {
//                System.out.println(((Room) map.getKey()).toString() + "," + map.getValue());
//            } else if (map.getKey() instanceof House) {
//                System.out.println(((House) map.getKey()).toString() + "," + map.getValue());
//            } else {
//                System.out.println(((Villa) map.getKey()).toString() + "," + map.getValue());
//            }
        }
    }

    @Override
    public void edit() {

    }

    @Override
    public void displayMaintenance() {
        List< Facility > listMaintenance = new ArrayList<>();
        System.out.println("***List facility must Maintenance***");
        for (Map.Entry< Facility, Integer > list : facilityList.entrySet()) {
            if (list.getValue() == 5) {
                listMaintenance.add(list.getKey());
            }
        }
        for (Facility facility : listMaintenance) {
            System.out.println(facility.toString());
        }
    }
}
