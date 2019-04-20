package Generic;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

import static org.junit.Assert.*;

public class KeyValueTest {
    @Test
    public void testKeyValue() {
        KeyValue<Integer, Integer> keyVal = new KeyValue<>(5, 6);
        assertEquals(5, keyVal.getKey().intValue());
        assertEquals(6, keyVal.getValue().intValue());

        List<KeyValue<Integer, Integer>> list = new ArrayList<>();
        list.add(new KeyValue<>(5, 6));
        list.add(new KeyValue<>(8, 1));
        list.add(new KeyValue<>(3, 22));
        list.add(new KeyValue<>(7, 5));

        ArrayList<Integer> keys = new ArrayList<>();
        keys.add(7);
        keys.add(9);
        keys.add(3);
        keys.add(1);

        ArrayList<Integer> values = keyVal.getValues(list, keys);
        assertEquals(2, values.size());

    }
}