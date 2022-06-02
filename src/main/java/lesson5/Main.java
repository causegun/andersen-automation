package lesson5;

import java.util.ArrayList;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        GenericArray<Integer> genericArray1 = new GenericArray<>(new Integer[]{1, 2, 3, 4, 5});
        genericArray1.switchElements(1, 2);
        System.out.println(Arrays.toString(genericArray1.getArray()));
        GenericArray<String> genericArray2 = new GenericArray<>(new String[]{"one", "two", "three", "four", "five"});
        genericArray2.switchElements(0, 3);
        System.out.println(Arrays.toString(genericArray2.getArray()));

        ArrayList<Apple> appleList6 = new ArrayList<>();
        for (int i = 0; i < 6; i++) {
            appleList6.add(new Apple());
        }
        ArrayList<Apple> appleList10 = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            appleList10.add(new Apple());
        }
        ArrayList<Orange> orangeList4 = new ArrayList<>();
        for (int i = 0; i < 4; i++) {
            orangeList4.add(new Orange());
        }
        ArrayList<Orange> orangeList6 = new ArrayList<>();
        for (int i = 0; i < 6; i++) {
            orangeList6.add(new Orange());
        }

        Box<Apple> appleBox6 = new Box<>(appleList6);
        Box<Orange> orangeBox4 = new Box<>(orangeList4);
        System.out.println(appleBox6.compare(orangeBox4)); // 6 = 4*1.5
        Box<Apple> appleBox10 = new Box<>(appleList10);
        Box<Orange> orangeBox6 = new Box<>(orangeList6);
        System.out.println(appleBox10.compare(orangeBox6)); // 10 != 6*1.5

        System.out.println("sizes before apples transfer: " + appleBox6.getList().size() + " " + appleBox10.getList().size());
        System.out.println("sizes before oranges transfer: " + orangeBox4.getList().size() + " " + orangeBox6.getList().size());
        appleBox6.transferFruits(appleBox10);
        orangeBox4.transferFruits(orangeBox6);
        System.out.println("sizes after apples transfer: " + appleBox6.getList().size() + " " + appleBox10.getList().size());
        System.out.println("sizes after oranges transfer: " + orangeBox4.getList().size() + " " + orangeBox6.getList().size());
    }
}
