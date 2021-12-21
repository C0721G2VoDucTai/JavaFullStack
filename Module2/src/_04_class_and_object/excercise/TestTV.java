package _04_class_and_object.excercise;

public class TestTV {
    public static void main(String[] args) {
        TV tv1 = new TV();
        tv1.turnOn();
        tv1.setChannel(30);
        tv1.setVolume(3);
        TV tv2 = new TV();
        tv2.turnOn();
        tv2.channelUp();
        tv2.channelUp();
        tv2.volumeUp();
        System.out.println("Tv1's chanel is: " +  tv1.channel + " and volume leve is: " +
                tv1.volumeLevel);
        System.out.println("Tv2's chanel is: " +  tv2.channel + " and volume leve is: " +
                tv2.volumeLevel);


    }
}
