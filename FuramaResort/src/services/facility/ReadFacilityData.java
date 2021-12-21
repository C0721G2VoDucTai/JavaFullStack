package services.facility;

import models.facillity.Facility;
import models.facillity.House;
import models.facillity.Room;
import models.facillity.Villa;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import static utils.ReadAndWriterFIle.readFile;

public class ReadFacilityData {
    public static Map< Facility, Integer > readFileFacility(String path) {
        List< String > stringList = readFile(path);
        Map< Facility, Integer > mapList = new LinkedHashMap<>();
        for (String string : stringList) {
            String[] temp = new String[1];
            temp = string.split(",");
            switch (temp.length) {
                case 8:
                    Facility facility = new Room(temp[0], temp[1], Double.parseDouble(temp[2]),
                            Double.parseDouble(temp[3]), Integer.parseInt(temp[4]), temp[5],
                            temp[6]);
                    mapList.put(facility, Integer.parseInt(temp[7]));
                    break;
                case 9:
                    Facility facility1 = new House(temp[0], temp[1], Double.parseDouble(temp[2]),
                            Double.parseDouble(temp[3]), Integer.parseInt(temp[4]), temp[5],
                            temp[6], Integer.parseInt(temp[7]));
                    mapList.put(facility1, Integer.parseInt(temp[8]));
                    break;
                case 10:
                    Facility facility2 = new Villa(temp[0], temp[1], Double.parseDouble(temp[2]),
                            Double.parseDouble(temp[3]), Integer.parseInt(temp[4]), temp[5], temp[6],
                            Double.parseDouble(temp[7]), Integer.parseInt(temp[8]));
                    mapList.put(facility2, Integer.parseInt(temp[9]));
                    break;
            }

        }
        return mapList;
    }
}

