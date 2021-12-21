package _12_java_collection_framework.exercise.using_pratice_arraylist_linkedlist;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;


public class ProductsManagement {
    private static ArrayList< Products > productsList = new ArrayList();

    static {
        Products products1 = new Products(1001, 21000000, "Iphone 13 Mini", "128GB");
        Products products2 = new Products(1003, 25000000, "Iphone 13", "128GB");
        Products products3 = new Products(1002, 31000000, "Iphone 13 Pro", "128GB");
        Products products4 = new Products(1004, 34000000, "Iphone 13 Pro Max", "128GB");
        productsList.add(products1);
        productsList.add(products2);
        productsList.add(products3);
        productsList.add(products4);
    }

    public static void add() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter id");
        int id = Integer.parseInt(scanner.nextLine());
        System.out.println("Enter price");
        int price = Integer.parseInt(scanner.nextLine());
        System.out.println("Enter name");
        String name = scanner.nextLine();
        System.out.println("Enter information");
        String information = scanner.nextLine();
        Products products = new Products(id, price, name, information);
        productsList.add(products);
    }

    public static void showList() {
//        for (int i = 0; i < productsList.size(); i++) {
//            System.out.println(productsList.get(i));
//        }
        for (Products products : productsList) {
            System.out.println(products);
        }
    }

    public static void delete() {
        showList();
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter deleted id");
        int id = Integer.parseInt(scanner.nextLine());
        for (Products products : productsList) {
            if (products.getId() == id) {
                productsList.remove(products);
            }
        }
    }

    public static void edit() {
        showList();
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter id of products you want to edit");
        int idEdit = Integer.parseInt(scanner.nextLine());
        System.out.println("Enter new id");
        int id = Integer.parseInt(scanner.nextLine());
        System.out.println("Enter new price");
        int price = Integer.parseInt(scanner.nextLine());
        System.out.println("Enter new name");
        String name = scanner.nextLine();
        System.out.println("Enter new information");
        String information = scanner.nextLine();
        for (Products products : productsList) {
            if (products.getId() == id) {
                products.setId(id);
                products.setPrice(price);
                products.setName(name);
                products.setInformation(information);
            }
        }
    }

    public static void search() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter name your want to search");
        String name = scanner.nextLine();
        for (Products products : productsList) {
            if (products.getName().contains(name)) {
                System.out.println(products);
            }
        }
    }

    public static void sortUp() {
//        Collections.sort(productsList, new ComparatorByPriceUp());
        Collections.sort(productsList);
    }

    public static void sortDown() {
        Collections.sort(productsList, new ComparatorByPriceDown());
    }
}
