package _17_io_binary_file.exercise.product_management;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Management {
    Scanner scanner = new Scanner(System.in);

    public static void writeToFile(String pathFile, List< Product > list) {
        try {
            FileOutputStream fos = new FileOutputStream(pathFile);
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            oos.writeObject(list);
            oos.close();
            fos.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static List< Product > readToFile(String pathFile) {
        List< Product > list = new ArrayList<>();
        try {
            FileInputStream fis = new FileInputStream(pathFile);
            ObjectInputStream ois = new ObjectInputStream(fis);
            list = (List< Product >) ois.readObject();
            fis.close();
            ois.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }

    public void add() {
        System.out.println("Enter id");
        int id = Integer.parseInt(scanner.nextLine());
        System.out.println("Enter name");
        String name = scanner.nextLine();
        System.out.println("Enter brand");
        String brand = scanner.nextLine();
        System.out.println("Enter price");
        double price = Double.parseDouble(scanner.nextLine());
        System.out.println("Enter description");
        String description = scanner.nextLine();
        Product product = new Product(id, name, brand, price, description);
        List< Product > list = new ArrayList<>();
        list.add(product);
        writeToFile("src\\_17_io_binary_file\\exercise\\product_management\\data.dav", list);
    }

    public void display() {
        List< Product > list = new ArrayList<>();
        list = readToFile("src\\_17_io_binary_file\\exercise\\product_management\\data.dav");
        for (Product product : list) {
            System.out.println(product.toString());
        }
    }

    public void edit() {
        List< Product > list = new ArrayList<>();
        list = readToFile("src\\_17_io_binary_file\\exercise\\product_management\\data.dav");
        System.out.println("Enter edit id");
        int editId = Integer.parseInt(scanner.nextLine());
        System.out.println("Enter new id");
        int id = Integer.parseInt(scanner.nextLine());
        System.out.println("Enter new name");
        String name = scanner.nextLine();
        System.out.println("Enter new brand");
        String brand = scanner.nextLine();
        System.out.println("Enter new price");
        double price = Double.parseDouble(scanner.nextLine());
        System.out.println("Enter new description");
        String description = scanner.nextLine();
        for (Product product : list) {
            if (product.getId() == editId) {
                product.setId(id);
                product.setName(name);
                product.setBrand(brand);
                product.setPrice(price);
                product.setDescription(description);
//                writeToFile("src\\_17_io_binary_file\\exercise\\product_management\\data.dav", list);
            }
        }
    }

    public void search() {
        List< Product > list = new ArrayList<>();
        list = readToFile("src\\_17_io_binary_file\\exercise\\product_management\\data.dav");
        System.out.println("Enter name search");
        String name = scanner.nextLine();
        for (Product product : list) {
            if (product.getName().contains(name)) {
                System.out.println(product.toString());
            }
        }
    }
}
