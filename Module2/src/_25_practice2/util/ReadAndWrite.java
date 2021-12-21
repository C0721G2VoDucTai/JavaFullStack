package _25_practice2.util;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class ReadAndWrite {
    public static List< String > readFile(String path) {
        List< String > stringList = new ArrayList<>();
        try {
            FileReader fileReader = new FileReader(path);
            BufferedReader br = new BufferedReader(fileReader);
            String line = "";
            while ((line = br.readLine()) != null) {
                stringList.add(line);
            }
            br.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return stringList;
    }
    public static void writeFile(List< String > list, String path, boolean append) {
        File file = new File(path);
        try {
            FileWriter write = new FileWriter(file, append);
            BufferedWriter bw = new BufferedWriter(write);
            for (String string : list) {
                bw.write(string);
                bw.newLine();
            }
            bw.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
