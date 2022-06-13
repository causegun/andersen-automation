package lesson8;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;

public class Main {
    public static void main(String[] args) {
        String[] words = new String[]{"never", "gonna", "give", "you", "up", "never", "gonna", "let", "you", "down", "never"};
        System.out.println(words.length);
        HashSet<String> set = new HashSet<>(Arrays.asList(words));
        System.out.println(set.toString());
        HashMap<String, Integer> valuesTimes = new HashMap<>();
        for (String word : words) {
            if (!valuesTimes.containsKey(word)) {
                valuesTimes.put(word, 1);
            } else {
                valuesTimes.put(word, valuesTimes.get(word) + 1);
            }
        }
        System.out.println(valuesTimes.toString());

        PhoneBook phoneBook = new PhoneBook();
        phoneBook.add("Elvis", "77010001122");
        phoneBook.add("Michael", "77010001123");
        phoneBook.add("Elvis", "77010001124");
        phoneBook.add("John", "77010001125");
        phoneBook.add("George", "77010001126");
        phoneBook.add("Calvin", "77010001127");
        phoneBook.add("Joseph", "77010001128");
        phoneBook.add("Elvis", "77010001129");
        phoneBook.add("John", "77010001130");
        phoneBook.get("Elvis");
        phoneBook.get("John");
        phoneBook.get("Michael");
    }
}
