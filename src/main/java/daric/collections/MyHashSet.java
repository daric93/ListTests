package daric.collections;

import java.util.*;

public class MyHashSet<E> extends AbstractSet<E> {
    private static final double LOAD_FACTOR = 0.75;
    private int size;
    @SuppressWarnings("unchecked")
    private LinkedList<E>[] buckets = new LinkedList[8];

    public MyHashSet() {
        Arrays.setAll(buckets, i -> new LinkedList<>());
    }

    public boolean add(E e) {
        int hashCode = Objects.hashCode(e);
        int bucket = hashCode % buckets.length;
        if (buckets[bucket].contains(e))
            return false;
        else {
            boolean addRes = buckets[bucket].add(e);
            size++;
            if ((double) size / buckets.length > LOAD_FACTOR)
                moveToNewArray();
            return addRes;
        }
    }

    private void moveToNewArray() {
        @SuppressWarnings("unchecked")
        LinkedList<E>[] newBuckets = new LinkedList[buckets.length * 2];
        Arrays.setAll(newBuckets, i -> new LinkedList<>());
        for (LinkedList<E> list : buckets) {
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
        for (LinkedList<E> bucket : buckets) {
            bucket.forEach(keys::add);
        }
        return keys.iterator();
    }

    public int size() {
        return size;
    }

}
