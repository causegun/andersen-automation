package school.lesson2;

import java.util.Arrays;

public class ThreeStarTask {
    public void moveArrayElements(int[] array, int n) {
        if (n < 0) {
            for (int i = 0; i < -n; i++) {
                int tmp = array[0];
                for (int j = 0; j < array.length - 1; j++) {
                    array[j] = array[j + 1];
                }
                array[array.length - 1] = tmp;
            }
        }
        if (n > 0) {
            for (int i = 0; i < n; i++) {
                int tmp = array[array.length - 1];
                for (int j = array.length - 1; j > 0; j--) {
                    array[j] = array[j - 1];
                }
                array[0] = tmp;
            }
        }
    }

}
