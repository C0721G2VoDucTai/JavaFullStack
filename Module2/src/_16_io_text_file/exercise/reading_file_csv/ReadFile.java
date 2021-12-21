package _16_io_text_file.exercise.reading_file_csv;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ReadFile {
    public static void main(String[] args) {
        Country country = new Country();
        ArrayList< Country > list = new ArrayList<>();
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter file path");
        String filePath = scanner.nextLine();
        try {
            File file = new File(filePath);
            if (!file.exists()) {
                throw new FileNotFoundException();
            }
            FileReader fileReader = new FileReader(filePath);
            String line = "";
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            while ((line = bufferedReader.readLine()) != null) {
                String[] temp = new String[1];
                temp = line.split(",");
                country = new Country(temp[0], temp[1], temp[2]);
                list.add(country);
            }
            bufferedReader.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println("Print csv file: ");
        for (Country countries : list) {
            System.out.println(countries.toString());
        }
    }
}
