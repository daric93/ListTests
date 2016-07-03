import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class ListTest {
    public List<Integer> list = new ArrayList<>();

    public void addElem() {
        list.add(1);
        list.add(2);
        list.add(3);
    }

    @Test
    public void testCreation() {
        List<Object> list2 = new ArrayList<>();
        assertTrue(list.size() == 0);
    }

    @Test
    public void testAdd() {
        int sizeBefore = list.size();
        int elem = 4;
        list.add(elem);
        assertTrue((sizeBefore + 1) == list.size());
        assertEquals(list.get(list.size() - 1), Integer.valueOf(elem));
        int index = 2;
        elem = 6;
        list.add(index, elem);
        assertEquals(list.get(index), Integer.valueOf(elem));
    }


}
