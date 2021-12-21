package _00_fix_bug.week_3;

public class BugWeek3 {

    public static void main(String[] args) {
        MyList< Integer > listInt = new MyList<>();
        listInt.add(7);
        listInt.add(19);
        listInt.add(3);
        listInt.add(20);
        MyList< Integer > newListInt = listInt.clone();
        listInt.clear();

        for (int i = 0; i < newListInt.size(); i++) {
            System.out.println(newListInt.get(i));
        }
    }
}
