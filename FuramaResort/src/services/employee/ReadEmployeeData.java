package services.employee;

import models.person.Employee;

import java.util.ArrayList;
import java.util.List;

import static utils.ReadAndWriterFIle.readFile;

public class ReadEmployeeData {
    public static List< Employee > readFileEmployee(String path) {
        List< String > stringList = readFile(path);
        List< Employee > employeeList = new ArrayList<>();
        for (String string : stringList) {
            String[] temp  = string.split(",");
            Employee employee = new Employee(Integer.parseInt(temp[0]), temp[1], temp[2], temp[3], temp[4],
                    temp[5], temp[6], temp[7], temp[8], Double.parseDouble(temp[9]));
            employeeList.add(employee);
        }
        return employeeList;
    }
}
