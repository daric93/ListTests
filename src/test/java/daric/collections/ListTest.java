package daric.collections;

import org.junit.Test;

import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;

import static org.junit.Assert.*;

public abstract class ListTest {
    public abstract List<Integer> getList();

    public void addElem(List<Integer> list, Integer... numbers) {
        Collections.addAll(list, numbers);
    }

    @Test
    public void testCreation() {
        List<Integer> list = getList();
        assertTrue(list.size() == 0);
        assertTrue(list.isEmpty());
        list.add(0);
        assertTrue(list.size() == 1);
    }

    @Test
    public void testAdd() {
        List<Integer> list = getList();
        addElem(list, 1, 3, 7);
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
        List<Integer> list = getList();
        addElem(list, 1, 3, 7);
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
    public void testRemoveMethod() {
        List<Integer> list = getList();
        addElem(list, 4, 5, 6);
        int index = 1;
        int size = list.size();
        list.remove(index);
        assertTrue(list.size() == (size - 1) && !list.contains(5));
        list.remove(Integer.valueOf(6));
        assertTrue(list.size() == (size - 2) && !list.contains(6));
    }

    @Test
    public void testClearMethod() {
        List<Integer> list = getList();
        addElem(list, 4, 5, 6);
        list.clear();
        assertTrue(list.isEmpty());
    }

    @Test
    public void testEquals() {
        List<Integer> list = getList();
        addElem(list, 4, 5, 6);
        List<Integer> list2 = getList();
        addElem(list2, 4, 5);
        assertFalse(list.equals(list2));
        list2.add(6);
        assertTrue(list.equals(list2));
    }

    @Test
    public void testSort() {
        List<Integer> list = getList();
        addElem(list, 56, 78, 3, 4, 34, 12, 90, 76);
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
