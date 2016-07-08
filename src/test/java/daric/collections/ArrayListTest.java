package daric.collections;

import java.util.ArrayList;
import java.util.List;

public class ArrayListTest extends ListTest {
    @Override
    public List<Integer> getList() {
        return new ArrayList<>();
    }
}
