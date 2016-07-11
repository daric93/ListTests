package daric.collections;

import org.junit.Test;

import java.util.Set;
import java.util.TreeSet;

import static org.junit.Assert.assertTrue;

public class TreeSetTest extends SetTest {
    @Override
    Set<Integer> getSet() {
        return new TreeSet<>();
    }

    @Test(expected = NullPointerException.class)
    public void testAddNull() {
        Set<Integer> set = getSet();
        set.add(null);
        assertTrue(set.contains(null));
    }
}
