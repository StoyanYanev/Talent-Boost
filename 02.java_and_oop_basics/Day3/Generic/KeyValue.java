package Generic;

import java.sql.Array;
import java.util.*;

public class KeyValue<K, V> {
    private K key;
    private V value;

    KeyValue(K key, V value) {
        this.key = key;
        this.value = value;
    }

    public K getKey() {
        return this.key;
    }

    public V getValue() {
        return this.value;
    }

    public ArrayList<V> getValues(Collection<KeyValue<K, V>> listOfKeysValues, ArrayList<K> keys) {
        ArrayList<V> values = new ArrayList<>();
        Map<K, V> map = new HashMap<>();

        for (KeyValue<K, V> keyValue : listOfKeysValues) {
            map.put(keyValue.getKey(), keyValue.getValue());
        }

        for (K key : keys) {
            if (map.containsKey(key)) {
                values.add(map.get(key));
            }
        }

        return values;
    }
}