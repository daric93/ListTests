package daric.collections;

import java.util.AbstractList;
import java.util.Arrays;

public class MyArrayList<E> extends AbstractList<E> {
    private int size = 0;
    private Object[] arr = new Object[2];

    @SuppressWarnings("unchecked")
    @Override
    public E get(int index) {
        if (index < 0 || index >= size)
            throw new IndexOutOfBoundsException();
        return (E) arr[index];
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public void add(int index, E element) {
        if (index < 0 || index > size)
            throw new IndexOutOfBoundsException();
        if (size == arr.length)
            arr = Arrays.copyOf(this.arr, size * 2);
        System.arraycopy(arr, index, arr, index + 1, size - index);
        arr[index] = element;
        size++;
    }

    @SuppressWarnings("unchecked")
    @Override
    public E set(int index, E element) {
        E prev = (E) arr[index];
        arr[index] = element;
        return prev;
    }

    @SuppressWarnings("unchecked")
    @Override
    public E remove(int index) {
        if (index < 0 || index > size)
            throw new IndexOutOfBoundsException();
        E removed = (E) arr[index];
        System.arraycopy(arr, index + 1, arr, index, size - (index + 1));
        size--;
        return removed;
    }
}
