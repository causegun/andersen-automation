package lesson6;

public class SomeClass {
    public int sumHexArray(String[][] array) {
        if (array.length != 4 || array[0].length != 4) {
            try {
                throw new MyArraySizeException("input array not 4x4");
            } catch (MyArraySizeException e) {
                e.printStackTrace();
            }
        }
        int sum = 0;
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[0].length; j++) {
                try {
                    sum += Integer.parseInt(array[i][j]);
                } catch (NumberFormatException e) {
                    throw new MyArrayDataException(e.getMessage(), i, j);
                }
            }
        }
        return sum;
    }
}
