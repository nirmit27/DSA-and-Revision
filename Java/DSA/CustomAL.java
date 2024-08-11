/* Making a CUSTOM generic data structure. */

import java.util.Arrays;

public class CustomAL<T extends Number> {
    private Object[] data;
    private static final int DEFAULT_SIZE = 10;
    private int size = 0;

    public CustomAL() {
        this.data = new Object[DEFAULT_SIZE];
    }

    public T get(int index) {
        if (index >= size || index < 0)
            throw new IndexOutOfBoundsException("Index: " + index + ", Size: " + size);

        return (T) data[index]; // Keep in mind that this is NOT a safe type conversion.
    }

    public void set(int index, T val) {
        this.data[index] = val;
    }

    private boolean isFull() {
        return size == data.length;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public int size() {
        return data.length;
    }

    private void resize() {
        Object[] temp = new Object[this.data.length * 2]; // DOUBLING the length of the list for resizing
        for (int i = 0; i < data.length; i++) {
            temp[i] = data[i];
        }
        this.data = temp;
    }

    public void add(T x) {
        if (isFull())
            resize();
        data[size++] = x;
    }

    public T remove() {
        if (size == 0)
            throw new IllegalStateException("Cannot remove an element from an empty list.");

        T removed = (T) data[size--];
        return removed;
    }

    @Override
    public String toString() {
        return "CustomAL{data=" + Arrays.toString(this.data) + ", size=" + size + "}";
    }

    public static void main(String[] args) {
        CustomAL<Integer> arr = new CustomAL<>();
        for (int i = 0; i < 14; i++)
            arr.add(i * 2);

        arr.remove();
        arr.remove();
        System.out.println(arr);
    }
}