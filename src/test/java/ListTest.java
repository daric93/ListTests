import org.junit.Test;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;

import static org.junit.Assert.*;

public class ListTest {
    public List<Integer> list = new ArrayList<>();

    public void addElem(List<Integer> list) {
        list.add(1);
        list.add(2);
        list.add(3);
    }

    @Test
    public void testCreation() {
        List<Object> list2 = new ArrayList<>();
        assertTrue(list.size() == 0);
        assertTrue(list.isEmpty());
        list.add(0);
        assertTrue(list.size() == 1);
    }

    @Test
    public void testAdd() {
        int sizeBefore = list.size();
        int elem = 4;
        list.add(elem);
        assertTrue((sizeBefore + 1) == list.size());
        assertEquals(list.get(list.size() - 1), Integer.valueOf(elem));
        int index = 1;
        elem = 6;
        list.add(index, elem);
        assertEquals(list.get(index), Integer.valueOf(elem));
    }

    @Test
    public void testGetIndexSet() {
        Integer elem = 9;
        list.add(elem);
        int indexLast = list.size() - 1;
        assertEquals(list.get(indexLast), elem);
        assertEquals(list.indexOf(elem), indexLast);
        assertTrue(list.contains(elem));
        Integer newElem = 10;
        list.set(indexLast, newElem);
        assertEquals(list.get(indexLast), newElem);
    }

    @Test
    public void testRemoveClear() {
        list.add(5);
        list.clear();
        assertTrue(list.isEmpty());
        addElem(list);
        int index = 1;
        int size = list.size();
        list.remove(index);
        assertTrue(list.size() == (size - 1) && !list.contains(2));
        list.remove(Integer.valueOf(1));
        assertTrue(list.size() == (size - 2) && !list.contains(1));
    }

    @Test
    public void testEquals() {
        list.clear();
        addElem(list);
        List<Integer> list2 = new ArrayList<>();
        list2.add(1);
        list2.add(2);
        assertFalse(list.equals(list2));
        list2.add(3);
        assertTrue(list.equals(list2));
    }

    @Test
    public void testSort() {
        list.clear();
        list.add(1);
        list.add(3);
        list.add(2);
        list.sort(Comparator.naturalOrder());
        Iterator<Integer> iterator = list.iterator();
        if (iterator.hasNext()) {
            int current;
            int previous = iterator.next();
            while (iterator.hasNext()) {
                current = iterator.next();
                assertTrue(current >= previous);
                previous = current;
            }
        }
    }
}
