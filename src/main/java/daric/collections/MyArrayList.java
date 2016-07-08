package daric.collections;

import java.util.Arrays;
import java.util.Comparator;

public class MyArrayList implements MyList {
    private int size = 0;
    private Integer[] arr = new Integer[20];


    @Override
    public void add(Integer elem) {
        if (size == arr.length)
            arr = Arrays.copyOf(this.arr, size += 50);
        arr[size++] = elem;
    }

    @Override
    public void add(int index, Integer elem) {
        if (index < 0 || index > size)
            throw new IndexOutOfBoundsException();
        if (size == arr.length)
            arr = Arrays.copyOf(this.arr, size += 50);
        System.arraycopy(arr, index, arr, index + 1, size - index);
        arr[index] = elem;
        size++;
    }

    @Override
    public void clear() {
        size = 0;
    }

    @Override
    public int get(int index) {
        if (index < 0 || index >= size)
            throw new IndexOutOfBoundsException();
        return arr[index];
    }

    @Override
    public int indexOf(Integer elem) {
        for (int i = 0; i < size; i++) {
            if (arr[i].equals(elem))
                return i;
        }
        return -1;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public int remove(int index) {
        int removed = arr[index];
        System.arraycopy(arr, index + 1, arr, index, size - (index + 1));
        size--;
        return removed;
    }

    @Override
    public boolean remove(Integer elem) {
        int index = -1;
        for (int i = 0; i < size; i++) {
            if (arr[i].equals(elem)) {
                index = i;
                break;
            }
        }
        if (index >= 0) {
            System.arraycopy(arr, index + 1, arr, index, size - (index + 1));
            size--;
            return true;
        }
        return false;
    }

    @Override
    public int set(int index, Integer elem) {
        int prev = arr[index];
        arr[index] = elem;
        return prev;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public void sort(Comparator<? super Object> c) {
        Arrays.sort(arr, c);
    }
}
