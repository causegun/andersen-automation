package lesson8;

import java.util.HashMap;
import java.util.HashSet;

public class PhoneBook {
    private final HashMap<String, HashSet<String>> phoneBook;

    public PhoneBook() {
        this.phoneBook = new HashMap<>();
    }

    public void add(String name, String phone) {
        HashSet<String> phoneSet = new HashSet<>();
        if (phoneBook.containsKey(name)) phoneSet.addAll(phoneBook.get(name));
        phoneSet.add(phone);
        phoneBook.put(name, phoneSet);
    }

    public HashSet<String> get(String name) {
        System.out.println(name + " " + phoneBook.get(name).toString());
        return phoneBook.get(name);
    }
}
