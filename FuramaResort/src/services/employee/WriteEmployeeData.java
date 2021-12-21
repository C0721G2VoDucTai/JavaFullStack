package services.employee;

import models.person.Employee;

import java.util.ArrayList;
import java.util.List;

import static utils.ReadAndWriterFIle.writeFile;

public class WriteEmployeeData {
    public static void writeFileEmployee(List< Employee > employeeList, String path, boolean append) {
        List< String > stringList = new ArrayList<>();
        for (Employee employee : employeeList) {
            stringList.add(employee.getInformationEmployee());
        }
        writeFile(stringList, path, append);
    }
}
