package _13_thuat_toan_tim_kiem.exercise.optional;

import java.util.Arrays;

public class BinarySearch {
    static  int[] list = {15, 3, 1, 9, 4, 19, 5, 7, 8, 10, 9};
    static {
        for (int i = 0; i < list.length; i++) {
            for(int j=0; j <list.length; j++) {
                if(list[j] > list[i]) {
                    int temp = list[j];
                    list[j] = list[i];
                    list[i] = temp;
                }
            }
        }
    }
    public static int binarySearch(int [] array, int left, int right, int value) {
        while(left<=right) {
            int mid = (right+left)/2;
            if(array[mid] == value) {
                return mid;
            }
            else if(array[mid]>value) {
                right = mid-1;
            }
            else{
                left = mid+1;
            }
        }
        return -1;
    }
    public static void main(String[] args) {

        System.out.println(Arrays.toString(list));
        System.out.println(binarySearch(list, 0, 9,5));
        System.out.println(binarySearch(list, 0, 9,6));
        System.out.println(binarySearch(list, 0, 9,12));
        System.out.println(binarySearch(list, 0, 9,8));
    }
}
