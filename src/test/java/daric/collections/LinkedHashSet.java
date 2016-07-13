package daric.collections;

import org.junit.Test;

import java.util.Set;

import static org.junit.Assert.*;

public class LinkedHashSet extends SetTest {
    @Override
    Set<Integer> getSet() {
        return new java.util.LinkedHashSet<>();
    }

    @Test
    public void testAddNull() {
        Set<Integer> set = getSet();
        assertTrue(set.add(null));
        assertTrue(set.contains(null));
    }

    @Test
    public void testRemoveNull() {
        Set<Integer> set = getSet();
        set.add(null);
        assertTrue(set.remove(null));
        assertFalse(set.contains(null));
    }

    @Test
    public void testOrder() {
        Set<Integer> set = getSet();
        for (int i = 0; i < 10; i++) {
            set.add(i);
        }
        int i = 0;
        for (Integer aSet : set) {
            assertEquals(Integer.valueOf(i), aSet);
            i++;
        }
    }
}
