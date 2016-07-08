package daric.collections;

import java.util.Comparator;

public interface MyList {
    void add(Integer elem);

    void add(int position, Integer elem);

    void clear();

    int get(int index);

    int indexOf(Integer elem);

    boolean isEmpty();

    int remove(int index);

    boolean remove(Integer elem);

    int set(int index, Integer elem);

    int size();

    void sort(Comparator<? super Object> c);
}
