package utill;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class GetData {
//    public static List< LandStatus > selectLandStatus() {
//        List< LandStatus > landStatusList = new ArrayList<>();
//        try {
//            Statement statement = getConnection().createStatement();
//            ResultSet resultSet = statement.executeQuery("select * from land_status ;");
//            LandStatus landStatus = null;
//            while (resultSet.next()) {
//                landStatus = new LandStatus();
//                landStatus.setId(resultSet.getInt("land_status_id"));
//                landStatus.setName(resultSet.getString("land_status_name"));
//                landStatusList.add(landStatus);
//            }
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
//        return landStatusList;
//    }
//    public static List< LandType > selectLandType() {
//        List< LandType > landTypeList = new ArrayList<>();
//        try {
//            Statement statement = getConnection().createStatement();
//            ResultSet resultSet = statement.executeQuery("select * from land_type ;");
//            LandType landType = null;
//            while (resultSet.next()) {
//                landType = new LandType();
//                landType.setId(resultSet.getInt("land_type_id"));
//                landType.setName(resultSet.getString("land_type_name"));
//                landTypeList.add(landType);
//            }
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
//        return landTypeList;
//    }
}
