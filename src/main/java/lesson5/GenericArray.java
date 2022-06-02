package lesson5;

import java.util.Arrays;

public class GenericArray<T> {
    private T[] array;

    public GenericArray(T[] array) {
        this.array = array;
    }

    public T[] getArray() {
        return array;
    }

    public void switchElements(int firstElementIndex, int secondElementIndex) {
        T temp;
        temp = this.array[firstElementIndex];
        this.array[firstElementIndex] = this.array[secondElementIndex];
        this.array[secondElementIndex] = temp;
    }
}
