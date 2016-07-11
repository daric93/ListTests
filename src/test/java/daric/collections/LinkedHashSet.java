package daric.collections;

import org.junit.Test;

import java.util.Set;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

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
}
