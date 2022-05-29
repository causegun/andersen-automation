package lesson4;

public class Animal {
    static int animalCount;
    String name;

    public Animal(String name) {
        animalCount++;
        this.name = name;
    }

    public void run(int distance) {
        if (distance >= 0) {
            System.out.println(this.name + " пробежал(-а) " + distance + " м");
        } else {
            System.out.println("дистанция не может быть меньше нуля");
        }
    }

    public void swim(int distance) {
        if (distance >= 0) {
            System.out.println(this.name + " проплыл(-а) " + distance + " м");
        } else {
            System.out.println("дистанция не может быть меньше нуля");
        }
    }
}
