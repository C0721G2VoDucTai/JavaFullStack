package _11_dsa_stack_queue.exercise.count_time_of_character_in_string_use_map;

import java.util.Scanner;
import java.util.TreeMap;
// Dem Ky tu
public class CountByTreeMap {
    public static void main(String[] args) {
        TreeMap <String, Integer> map = new TreeMap();
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter String: ");
        String string = scanner.nextLine();
        string = string.toLowerCase();
        String key;
        int value =1;
        for(int i=0; i<string.length(); i++){
            key =string.substring(i,i+1);
            if((map.containsKey(key))) {
                map.put(key, map.get(key) +1);
            }
            else {
                map.put(key, value);
            }
        }
        System.out.println(map);
    }
}
