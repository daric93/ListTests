package daric.collections;

import org.junit.Test;

import java.util.HashSet;
import java.util.Set;

import static org.junit.Assert.assertTrue;

public class HashSetTest extends SetTest {
    @Override
    Set<Integer> getSet() {
        return new MyHashSet<>();
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
        set.add(4);
        assertTrue(set.add(null));
        assertTrue(set.contains(null));
        assertTrue(set.remove(null) && !set.contains(null));
    }
}
