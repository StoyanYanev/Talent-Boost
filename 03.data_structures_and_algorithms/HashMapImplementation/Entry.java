package HashMapImplementation;

public class Entry<K, V> {
    final K key;
    V value;
    Entry<K, V> next;

    Entry(K k, V v, Entry<K, V> next) {
        this.key = k;
        this.value = v;
        this.next = next;
    }
}