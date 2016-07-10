package daric.collections;

import org.junit.Test;

import java.util.Collections;
import java.util.Iterator;
import java.util.Set;

import static org.junit.Assert.*;

public abstract class SetTest {
    abstract Set<Integer> getSet();

    private void add(Set<Integer> set, Integer... args) {
        Collections.addAll(set, args);
    }

    @Test
    public void testAdd() {
        Set<Integer> set = getSet();
        for (int i = 0; i < 10; i++) {
            assertTrue(set.add(i) && set.contains(i));
        }
        assertTrue(set.size() == 10);
        assertFalse(set.add(2));
        assertTrue(set.size() == 10);
        assertTrue(set.add(null) && set.contains(null));
    }

    @Test
    public void testSize() {
        Set<Integer> set = getSet();
        assertTrue(set.size() == 0);
        add(set, 4, 6, 8);
        assertTrue(set.size() == 3);
        add(set, 4, 6, 8, 9);
        assertTrue(set.size() == 4);
    }

    @Test
    public void testClear() {
        Set<Integer> set = getSet();
        assertTrue(set.size() == 0 && set.isEmpty());
        add(set, 4, 6, 8);
        assertFalse(set.size() == 0 && set.isEmpty());
    }

    @Test
    public void testIterator() {
        Set<Integer> set = getSet();
        for (int i = 0; i < 10; i++) {
            set.add(i);
        }
        Iterator<Integer> iterator = set.iterator();
        for (int i = 0; i < 10; i++) {
            assertEquals(iterator.next(), Integer.valueOf(i));
        }
    }

    @Test
    public void testContains() {
        Set<Integer> set = getSet();
        add(set, 4, 5, 6);
        assertTrue(set.contains(4));
        assertFalse(set.contains(7));
    }

    @Test
    public void testRemove() {
        Set<Integer> set = getSet();
        add(set, 4, 5, 6);
        int size = set.size();
        assertTrue(set.remove(4) && !set.contains(4));
        assertEquals(size - 1, set.size());
    }
}
