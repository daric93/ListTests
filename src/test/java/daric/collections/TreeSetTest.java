package daric.collections;

import org.junit.Test;

import java.util.Set;
import java.util.TreeSet;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class TreeSetTest extends SetTest {
    @Override
    Set<Integer> getSet() {
        return new TreeSet<>();
    }

    @Override
    @Test(expected = NullPointerException.class)
    public void testAdd() {
        Set<Integer> set = getSet();
        for (int i = 0; i < 10; i++) {
            assertTrue(set.add(i) && set.contains(i));
        }
        assertTrue(set.size() == 10);
        assertFalse(set.add(2));
        assertTrue(set.size() == 10);
        set.add(null);
    }
}
