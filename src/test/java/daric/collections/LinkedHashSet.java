package daric.collections;

import java.util.Set;

public class LinkedHashSet extends SetTest {
    @Override
    Set<Integer> getSet() {
        return new java.util.LinkedHashSet<>();
    }
}
