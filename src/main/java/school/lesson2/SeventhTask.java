package school.lesson2;

public class SeventhTask {
    int[] array = {1, 5, 3, 2, 11, 4, 5, 2, 4, 8, 9, 1};

    public void doubleNumbersBelowSix() {
        for (int i = 0; i < array.length; i++) {
            if (array[i] < 6) {
                array[i] = array[i] * 2;
            }
        }
    }
}
