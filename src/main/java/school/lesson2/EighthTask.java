package school.lesson2;

public class EighthTask {
    int n = 10;
    int[][] array = new int[n][n];

    public void fillArray() {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (i == j) {
                    array[i][j] = 1;
                }
                if ((i + j) == (n - 1)) {
                    array[i][j] = 1;
                }
            }
        }
    }
}
