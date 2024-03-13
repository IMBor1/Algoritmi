import org.example.StringListImpl;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;


public class StringListImplTest {
    StringListImpl out = new StringListImpl();
    String[] stringsTest = {"s1", "s2", "s3"};

    @Test
    void add() {
        String result = out.add(0, "s1");
        assertEquals(stringsTest[0], result);
    }

    @Test
    void addItem() {
        String result = out.add("s1");
        assertEquals(stringsTest[0], result);
    }

    @Test
    void set() {
        String result = out.set(1, "s2");
        assertEquals(stringsTest[1], result);
    }

    @Test
    void removeByIndex() {
        out.add(0, "s1");
        out.add(1, "s2");
        String result = out.remove(1);
        assertEquals(stringsTest[1], result);
    }

    @Test
    void removeByItem() {
        out.add(0, "s1");
        out.add(1, "s2");
        String result = out.remove("s2");
        assertEquals(stringsTest[1], result);
    }

    @Test
    void contains() {
        out.add(0, "s1");
        out.add(1, "s2");
        Boolean result = out.contains("s2");
        assertTrue(result);
    }

    @Test
    void indexOf() {
        out.add(0, "s1");
        out.add(1, "s2");
        out.add(2, "s3");
        int result = out.indexOf("s2");
        assertEquals(1, result);
    }

    @Test
    void lastIndexOf() {
        out.add(0, "s0");
        out.add(1, "s1");
        out.add(2, "s2");
        out.add(3, "s3");
        out.add(4, "s4");
        out.add(5, "s5");
        out.add(6, "s6");
        out.add(7, "s7");
        out.add(8, "s8");
        out.add(9, "s9");
        int result = out.lastIndexOf("s2");
        assertEquals(2, result);
    }

    @Test
    void get() {
        out.add(0, "s1");
        out.add(1, "s2");
        out.add(2, "s3");
        String result = out.get(2);
        assertEquals("s3", result);
    }
}
