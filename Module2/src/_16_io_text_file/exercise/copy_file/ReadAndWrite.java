package _16_io_text_file.exercise.copy_file;

import java.io.*;
import java.util.List;
import java.util.Scanner;

public class ReadAndWrite {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter link of source  file");
        String text = scanner.nextLine();
        System.out.println("Enter link of copy  file");
        String copyText = scanner.nextLine();
        try {
            File file = new File(text);
            if (!file.exists()) {
                throw new FileNotFoundException();
            }
            FileReader read = new FileReader(file);
            BufferedReader br = new BufferedReader(read);
            String line = "";
            FileWriter writer = new FileWriter(copyText, true);
            BufferedWriter bufferedWriter = new BufferedWriter(writer);
            int count =0;
            while ((line = br.readLine()) != null) {
                System.out.println(line);
                bufferedWriter.write(line + "/n");
                for(int i=0; i<line.length(); i++) {
                    count ++;
                }
            }
            br.close();
            bufferedWriter.close();
            System.out.println(count);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
