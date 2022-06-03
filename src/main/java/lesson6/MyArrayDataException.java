package lesson6;

public class MyArrayDataException extends NumberFormatException {
    public MyArrayDataException(String message, int rowIndex, int columnIndex) {
        super(message + " [" + rowIndex + "]" + " [" + columnIndex + "]");
    }
}
