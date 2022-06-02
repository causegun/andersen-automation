package lesson5;

import java.util.ArrayList;

public class Box<T> {
    private ArrayList<T> list;

    public Box(ArrayList<T> list) {
        this.list = list;
    }

    public ArrayList<T> getList() {
        return list;
    }

    public double getWeight() {
        if (this.list.get(0).getClass().equals(Apple.class)) {
            double sum = 0;
            for (T apple : this.list) {
                sum += 1;
            }
            return sum;
        } else if (this.list.get(0).getClass().equals(Orange.class)) {
            double sum = 0;
            for (T orange : this.list) {
                sum += 1.5;
            }
            return sum;
        }
        return 0;
    }

    public boolean compare(Box<?> box) {
        return (this.getWeight() == box.getWeight());
    }

    public void addFruits(ArrayList<T> list) {
        this.list.addAll(list);
    }

    public void transferFruits(Box<T> box) {
        box.addFruits(this.list);
        this.list.clear();
    }
}
