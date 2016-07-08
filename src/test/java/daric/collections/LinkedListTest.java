package daric.collections;

import java.util.LinkedList;
import java.util.List;

public class LinkedListTest extends ListTest {
    @Override
    public List<Integer> getList() {
        return new LinkedList<>();
    }
}
