package lesson6;

public class Main {
    public static void main(String[] args) {
        SomeClass someClass = new SomeClass();
        String[][] hexArray = {{"1", "2", "3", "4"}, {"1", "2", "3", "4"}, {"1", "2", "3", "4"}, {"1", "2", "3", "4"}};
        String[][] notHexArray = {{"1", "2", "3", "4"}, {"1", "2", "3", "4"}, {"1", "2", "3", "4"}};
        String[][] hexArrayWithDataException = {{"1", "2", "3", "hello"}, {"1", "2", "3", "4"}, {"1", "2", "3", "4"}, {"1", "2", "3", "4"}};
        System.out.println(someClass.sumHexArray(hexArray));
        System.out.println(someClass.sumHexArray(notHexArray));
        System.out.println(someClass.sumHexArray(hexArrayWithDataException));
    }
}
