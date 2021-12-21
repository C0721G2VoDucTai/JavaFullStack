package _11_dsa_stack_queue.exercise.count_time_of_character_in_string_use_map;

import java.util.Iterator;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeMap;

// Dem tu
public class CountByTreeMap1< i > {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter String");
        String str = scanner.nextLine();
        String newStr = str.toLowerCase().replaceAll(",", "");
        String[] arr = newStr.split(" ");

        String key = "";
        Integer value =1;
        TreeMap< String, Integer > map = new TreeMap< String, Integer >();
        for (int i = 0; i < arr.length; i++) {
            key = arr[i];
            if (map.containsKey(key)) {
                map.put(key, map.get(key) + 1);
            } else {
                map.put(key, value);
            }
        }
        // Duyet dung keySet()
        Set<String> strings  = map.keySet(); // trả về tập key
        for(String stringS : map.keySet()) {
            System.out.println ("Key: " + stringS + " Value " + map.get(stringS));
        }
        System.out.println(map);
//        Set set = map.keySet(); // Duyet dung Iterator
//        Iterator iterator = set.iterator();
//        while (iterator.hasNext()) {
//            key = (String) iterator.next();
//            System.out.println("Từ '" + key + "' xuất hiện " + map.get(key) + " lần");
//        }
    }
}
