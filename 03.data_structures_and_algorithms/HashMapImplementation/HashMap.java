package HashMapImplementation;

import java.util.Map;

public class HashMap<K, V> {
    private Entry<K, V>[] buckets;
    private static final int INITIAL_CAPACITY = 16;
    private int currentSize;

    private int getIndex(K key) {
        return key.hashCode() % this.buckets.length;
    }

    private void rehash() {
        this.currentSize = 0;
        Entry<K, V>[] temp = this.buckets;
        this.buckets = new Entry[this.buckets.length * 2];
        for (Entry<K, V> e : temp) {
            this.put(e.key, e.value);
        }
    }

    HashMap() {
        this(INITIAL_CAPACITY);
    }

    HashMap(int capacity) {
        this.buckets = new Entry[capacity];
        this.currentSize = 0;
    }

    public V put(K k, V v) {
        if (k == null || v == null) {
            throw new NullPointerException();
        }
        if (this.size() >= this.buckets.length) {
            this.rehash();
        }
        Entry<K, V> newEntry = new Entry<>(k, v, null);
        int hash = this.getIndex(k);
        Entry<K, V> existing = this.buckets[hash];
        if (existing == null) {
            this.buckets[hash] = newEntry;
            currentSize++;
        } else {
            while (existing.next != null) {
                if (existing.key == k && getIndex(existing.key) == hash || existing.next.value.equals(newEntry.value) == true) {
                    V oldValue = existing.value;
                    existing.value = v;
                    return oldValue;
                }
                existing = existing.next;
            }
            existing.next = newEntry;
            this.currentSize++;
        }
        return null;
    }

    public V get(K k) {
        if (k == null) {
            throw new NullPointerException();
        }
        int hash = this.getIndex(k);
        Entry<K, V> current = this.buckets[hash];
        if (current != null) {
            while (current != null) {
                if (current.key.equals(k) == true) {
                    return current.value;
                }
                current = current.next;
            }
        }
        return null;
    }

    public V remove(K k) {
        if (k == null) {
            throw new NullPointerException();
        }
        if (isEmpty() == true) {
            return null;
        }
        int hash = this.getIndex(k);
        Entry<K, V> current = this.buckets[hash];
        if (current != null) {
            Entry<K, V> previous = null;
            while (current != null) {
                if (current.key.equals(k) == true) {
                    //int currentSize = this.currentSize;
                    V val = current.value;
                    if (previous == null) {
                        previous = this.buckets[hash].next;
                        this.buckets[hash] = previous;
                    } else {
                        previous.next = current.next;
                    }
                    this.currentSize--;
                    return val;
                }
                previous = current;
                current = current.next;
            }
        }
        return null;
    }

    public boolean isEmpty() {
        if (this.currentSize == 0) {
            return true;
        }
        return false;
    }

    public int size() {
        return this.currentSize;
    }

    public void print() {
        if (this.isEmpty() == false) {
            for (Entry<K, V> e : this.buckets) {
                if (e != null) {
                    System.out.println(e.key + " " + e.value);
                    if (e.next != null) {
                        Entry<K, V> current = e.next;
                        while (current != null) {
                            System.out.println(current.key + " " + current.value);
                            current = current.next;
                        }
                    }
                }
            }
        } else {
            System.out.println("The map is empty!");
        }
    }
}