package daric.collections;

import org.junit.Test;

import java.util.Iterator;
import java.util.Set;

import static java.util.Collections.addAll;
import static org.junit.Assert.*;

public abstract class SetTest {
    abstract Set<Integer> getSet();

    @Test
    public void testAdd() {
        Set<Integer> set = getSet();
        for (int i = 0; i < 10; i++) {
            assertTrue(set.add(i));
            assertTrue(set.contains(i));
        }
        assertEquals(10, set.size());
        assertFalse(set.add(2));
        assertEquals(10, set.size());
    }

    @Test
    public void testSize() {
        Set<Integer> set = getSet();
        assertEquals(0, set.size());
        addAll(set, 4, 6, 8);
        assertEquals(3, set.size());
        addAll(set, 4, 6, 8, 9);
        assertEquals(4, set.size());
    }

    @Test
    public void testClear() {
        Set<Integer> set = getSet();
        assertTrue(set.size() == 0 && set.isEmpty());
        addAll(set, 4, 6, 8);
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
        addAll(set, 4, 5, 6);
        assertTrue(set.contains(4));
        assertFalse(set.contains(7));
    }

    @Test
    public void testRemove() {
        Set<Integer> set = getSet();
        addAll(set, 4, 5, 6);
        int size = set.size();
        assertTrue(set.remove(4));
        assertTrue(!set.contains(4));
        assertEquals(size - 1, set.size());
    }
}
