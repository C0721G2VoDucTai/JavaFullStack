package services.facility;

import models.facillity.Facility;
import models.facillity.House;
import models.facillity.Room;
import models.facillity.Villa;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import static utils.ReadAndWriterFIle.writeFile;

public class WriteFacilityData {
    public static void writeFileFacility(Map< Facility, Integer > facilityMap, String path, boolean append) {
        List< String > stringList = new ArrayList<>();
        for (Map.Entry< Facility, Integer > map : facilityMap.entrySet()) {
            if (map.getKey() instanceof Room) {
                stringList.add(((Room) map.getKey()).getInformationRoom() + "," + map.getValue());
            } else if (map.getKey() instanceof House) {
                stringList.add(((House) map.getKey()).getInformationHouse() + "," + map.getValue());
            } else {
                stringList.add(((Villa) map.getKey()).getInformationVilla() + "," + map.getValue());
            }
        }
        writeFile(stringList, path, append);
    }
}
