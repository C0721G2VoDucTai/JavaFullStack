package _25_practice2.util;

import _25_practice2.model.MovieShowTimes;

import java.util.ArrayList;
import java.util.List;

import static _24_practice.util.ReadAndWrite.writeFile;

public class WriteFilm {
    public static void writeFilm(List< MovieShowTimes > movieShowTimesList, String path, boolean append) {
        List< String > stringList = new ArrayList<>();
        for (MovieShowTimes movieShowTimes : movieShowTimesList) {
            stringList.add(movieShowTimes.getInformationFilm());
        }
        writeFile(stringList, path, append);
    }
}
