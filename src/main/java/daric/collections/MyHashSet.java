package daric.collections;

import java.util.AbstractSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Objects;

public class MyHashSet<E> extends AbstractSet<E> {
    private static final double LOAD_FACTOR = 0.75;
    private int size;
    private LinkedList<Object>[] buckets = new LinkedList[8];

    public MyHashSet() {
        for (int i = 0; i < buckets.length; i++) {
            buckets[i] = new LinkedList<>();
        }
    }

    public boolean add(E e) {
        if (contains(e))
            return false;
        else {
            int hashCode = Objects.hashCode(e);
            int bucket = hashCode % buckets.length;
            boolean addRes = buckets[bucket].add(e);
            size++;
            if ((double) size / buckets.length > LOAD_FACTOR)
                moveToNewArray();
            return addRes;
        }
    }

    @SuppressWarnings("unchecked")
    private void moveToNewArray() {
        LinkedList<Object>[] newBuckets = new LinkedList[buckets.length * 2];
        for (int i = 0; i < newBuckets.length; i++) {
            newBuckets[i] = new LinkedList<>();
        }
        for (LinkedList<Object> list : buckets) {
            list.forEach(entry -> {
                int newBucket = Objects.hashCode(entry) % newBuckets.length;
                newBuckets[newBucket].add(entry);
            });
        }
        buckets = newBuckets;
    }

    @SuppressWarnings("unchecked")
    public void clear() {
        size = 0;
        buckets = new LinkedList[8];
    }

    public boolean remove(Object o) {
        int bucket = Objects.hashCode(o) % buckets.length;
        size--;
        return buckets[bucket].remove(o);
    }

    public boolean contains(Object o) {
        int bucket = Objects.hashCode(o) % buckets.length;
        return buckets[bucket].contains(o);
    }

    @Override
    public Iterator<E> iterator() {
        LinkedList<E> keys = new LinkedList<>();
        for (LinkedList bucket : buckets) {
            bucket.forEach(entry -> keys.add((E) entry));
        }
        return keys.iterator();
    }

    public int size() {
        return size;
    }

}
