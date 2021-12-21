package _25_practice2.management;

import _25_practice2.model.MovieShowTimes;

import java.io.File;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

import static _24_practice.util.CheckRegex.checkRegex;
import static _25_practice2.util.ReadAndWrite.readFile;
import static _25_practice2.util.ReadFilm.readFilm;
import static _25_practice2.util.WriteFilm.writeFilm;

public class Management {

    public static final String FILM_PATH = "src\\_25_practice2\\data\\film_data.csv";
    public static final String LIST_FILM_PATH = "src\\_25_practice2\\data\\list_film_data.csv";
    public static final String ID_FILM_REGEX = "^CI-\\d{4}$";
    public static final String NAME_REGEX = "([A-Z][a-z]+\\s?)+";
    public static final String DAY_REGEX = "\\d{1,2}/\\d{1,2}/\\d{4}";
    public static final String INT_REGEX = "[1-9][0-9]*";



    List< MovieShowTimes > movieShowTimesList = readFilm(FILM_PATH);
    Scanner scanner = new Scanner(System.in);
    File file = new File(FILM_PATH);
    List< String > listFilm = readFile(LIST_FILM_PATH);

    public void add() {

        for (int i = 0; i < listFilm.size(); i++) {
            System.out.println((i + 1) + "," + listFilm.get(i).toString());
        }
        MovieShowTimes movieShowTimes = new MovieShowTimes(inputId(), inputName(), inputDay(),
                Integer.parseInt(inputNumberTicket()));
        movieShowTimesList.add(movieShowTimes);
        file.delete();
        writeFilm(movieShowTimesList, FILM_PATH, true);
    }

    public void display() {
        for (int i = 0; i < movieShowTimesList.size(); i++) {
            System.out.println((i + 1) + "," + movieShowTimesList.get(i).toString());
        }
    }

    public void delete() {
        System.out.println("******List movie show times*****");
        display();
        System.out.println("Enter id you want to delete: ");
        String idDelete = scanner.nextLine();
        boolean check = true;
        while (check) {
            System.out.println("Do you want to delete this?" +
                    " 1. delete " +
                    " 2. return menu ");
            String choice = scanner.nextLine();
            switch (choice) {
                case "1":
                    for (int i = 0; i < movieShowTimesList.size(); i++) {
                        if (movieShowTimesList.get(i).getId().equals(idDelete)) {
                            movieShowTimesList.remove(movieShowTimesList.get(i));
                            file.delete();
                            writeFilm(movieShowTimesList, FILM_PATH, true);
                        }
                    }
                    break;
                case "2":
                    check = false;
                    break;
            }
            break;
        }
        display();
    }

    private String inputId() {
        boolean check = true;
        String id;
        do {
            System.out.println("Enter id: ");
            id = scanner.nextLine();
            for (MovieShowTimes list : movieShowTimesList) {
                if (!id.equals(list.getId())) {
                    check = false;
                } else {
                    check = true;
                    System.out.println("Id is duplicate, please input other id: ");
                    break;
                }
            }
        } while (check);
        return checkRegex(id, ID_FILM_REGEX, "Wrong format," +
                "please input like form: CI-1000");
    }

    private String inputName() {
        System.out.println("Enter index choice film: ");
        int index = Integer.parseInt(scanner.nextLine());
        String[] temp = listFilm.get(index - 1).split(",");
        return temp[1];
    }

    private String inputDay() {
        boolean check = true;
        String day;
        do {
            System.out.println("Enter day: ");
            day = scanner.nextLine();
            if (checkValidateDate(day)) {
                check = false;
            }
        } while (check);
        return day;

    }

    public static boolean checkValidateDate(String dateInput) {
        try {
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd/MM/yyyy");
            Date inputDate = simpleDateFormat.parse(dateInput);
            Date currentDate = new Date();
            return currentDate.before(inputDate);
        } catch (ParseException e) {
            System.out.println("Wrong input day, please input like format: dd/MM/yyyy");
        }
        return false;
    }

    private String inputNumberTicket() {
        System.out.println("Enter number of ticket: ");
        String numberTicket = scanner.nextLine();
        return checkRegex(numberTicket, INT_REGEX, "Wrong format," +
                "please input positive");
    }

}
