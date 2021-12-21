package _25_practice2.util;

import _24_practice.model.Customer;
import _24_practice.model.Receipt;
import _25_practice2.model.MovieShowTimes;

import java.util.ArrayList;
import java.util.List;

import static _25_practice2.util.ReadAndWrite.readFile;

public class ReadFilm {
    public static List< MovieShowTimes > readFilm(String path) {
        List< String > stringList = readFile(path);
        List< MovieShowTimes > movieShowTimesList = new ArrayList<>();
        for (String string : stringList) {
            String[] temp = string.split(",");
            MovieShowTimes movieShowTimes = new MovieShowTimes(temp[0], temp[1], temp[2],
                    Integer.parseInt(temp[3]));

            movieShowTimesList.add(movieShowTimes);
        }
        return movieShowTimesList;
    }
}
