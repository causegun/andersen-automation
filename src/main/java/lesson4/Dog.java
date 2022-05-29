package lesson4;

public class Dog extends Animal {
    public Dog(String name) {
        super(name);
    }

    @Override
    public void run(int distance) {
        if (distance <= 500) {
            super.run(distance);
        } else {
            System.out.println("Собака не может пробежать больше 500 м");
        }
    }

    @Override
    public void swim(int distance) {
        if (distance <= 10) {
            super.swim(distance);
        } else {
            System.out.println("Собака не может проплыть больше 10 м");
        }
    }
}
