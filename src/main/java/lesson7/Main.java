package lesson7;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {
    private static final String SEPARATOR = ";";
    private static final String FILE_PATH = "values.csv";

    public static void main(String[] args) {
        String[] header = new String[]{"value1", "value2", "value 3"};
        int[][] data = new int[][]{{100, 200, 123}, {300, 400, 500}};
        AppData appData = new AppData(header, data);
        save(appData);
        read(new File(FILE_PATH));
    }

    public static void save(AppData data) {
        try {
            PrintWriter writer = new PrintWriter(FILE_PATH);
            StringBuilder table = new StringBuilder();
            String[] headerArray = data.getHeader();
            int[][] dataArray = data.getData();
            for (int i = 0; i < headerArray.length; i++) {
                table.append(headerArray[i]);
                if (i < headerArray.length - 1) {
                    table.append(SEPARATOR);
                } else {
                    table.append("\n");
                }
            }
            for (int i = 0; i < dataArray.length; i++) {
                for (int j = 0; j < headerArray.length; j++) {
                    table.append(dataArray[i][j]);
                    if (j < headerArray.length - 1) {
                        table.append(SEPARATOR);
                    }
                }
                table.append("\n");
            }
            writer.write(String.valueOf(table));
            writer.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    public static void read(File file) {
        try {
            BufferedReader bufferedReader = new BufferedReader(new FileReader(file));
            String line = bufferedReader.readLine();
            List<List<String>> data = new ArrayList<>();
            while (line != null) {
                List<String> values = Arrays.asList(line.split(SEPARATOR));
                data.add(values);
                line = bufferedReader.readLine();
            }
            System.out.println(data.toString());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
