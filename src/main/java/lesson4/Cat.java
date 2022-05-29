package lesson4;

public class Cat extends Animal {
    private int appetite;
    private boolean isFull;

    public Cat(String name) {
        super(name);
    }

    public Cat(String name, int appetite) {
        super(name);
        this.appetite = appetite;
    }

    public void eat(Plate p) {
        isFull = p.decreaseFood(appetite);
    }

    @Override
    public void run(int distance) {
        if (distance <= 200) {
            super.run(distance);
        } else {
            System.out.println("Кошка не может пробежать больше 200 м");
        }
    }

    @Override
    public void swim(int distance) {
        System.out.println("Кошка не может плыть");
    }

    @Override
    public String toString() {
        return "Cat{" +
                "name='" + name + '\'' +
                ", appetite=" + appetite +
                ", isFull=" + isFull +
                '}';
    }
}
