package services.contract;

import models.contract.Contract;

import java.util.ArrayList;
import java.util.List;

import static utils.ReadAndWriterFIle.readFile;

public class ReadContractData {
    public static List< Contract > readFileContract(String path) {
        List< String > stringList = readFile(path);
        List< Contract > contractList = new ArrayList<>();
        for (String string : stringList) {
            String[] temp = new String[1];
            temp = string.split(",");
            Contract contract = new Contract(Integer.parseInt(temp[0]), Integer.parseInt(temp[1]),
                    Double.parseDouble(temp[2]), Double.parseDouble(temp[3]), Integer.parseInt(temp[4]));
            contractList.add(contract);
        }
        return contractList;
    }
}
