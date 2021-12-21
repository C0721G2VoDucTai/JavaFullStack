package _13_thuat_toan_tim_kiem.practice;

public class BN {
    static int[] list = {2, 4, 7, 10, 11, 45, 50, 59, 60, 66, 69, 70, 79};
    static int binarySearch(int[] list, int key) {
        int left =0;
        int right =list.length-1;
        while(left<=right) {
            int mid = (left+right)/2;
            if(key<list[mid]) {
                right =mid -1;
            }
            else if(key==list[mid]){
                return mid;
            }else{
                left =mid +1;
            }
        }
        return -1;
    }
    public static void main(String[] args) {
        System.out.println(binarySearch(list, 2));  /* 0 */
        System.out.println(binarySearch(list, 11)); /* 4 */
        System.out.println(binarySearch(list, 79)); /*12 */
        System.out.println(binarySearch(list, 1));  /*-1 */
        System.out.println(binarySearch(list, 5));  /*-1 */
        System.out.println(binarySearch(list, 80)); /*-1 */
    }
}
