package _24_practice.util;

import _24_practice.model.Receipt;

import java.util.ArrayList;
import java.util.List;

import static _24_practice.util.ReadAndWrite.writeFile;

public class WriteFileReceipt {
    public static void writeFileReceipt(List< Receipt > receiptList, String path, boolean append) {
        List< String > stringList = new ArrayList<>();
        for (Receipt receipt : receiptList) {
                stringList.add(receipt.getInformationReceipt());
        }
        writeFile(stringList, path, append);
    }
}
