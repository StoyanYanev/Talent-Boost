package HashMapImplementation;

import org.junit.Test;

import static org.junit.Assert.*;

public class HashMapTest {
    @Test
    public void testHashMap() {
        HashMap<String, String> m = new HashMap<>();
        m.put("USA", "Washington DC");
        m.put("Nepal", "Kathmandu");
        m.put("India", "New Delhi");
        m.put("Australia", "Sydney");
        assertNotNull(m);
        assertEquals(4, m.size());
        assertEquals("Kathmandu", m.get("Nepal"));
        assertEquals("Sydney", m.get("Australia"));

        assertEquals("New Delhi", m.remove("India"));
        assertEquals(null, m.get("India"));

        m.print();
    }
}