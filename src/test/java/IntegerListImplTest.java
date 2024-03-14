import org.example.IntegerListImpl;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;


public class IntegerListImplTest {
    IntegerListImpl out = new IntegerListImpl();
    Integer[] IntegersTest = {1, 2, 3};

    @Test
    void add() {
        Integer result = out.add(0, 1);
        assertEquals(IntegersTest[0], result);
    }

    @Test
    void addItem() {
        Integer result = out.add(1);
        assertEquals(IntegersTest[0], result);
    }

    @Test
    void set() {
        Integer result = out.set(1, 2);
        assertEquals(IntegersTest[1], result);
    }

    @Test
    void removeByIndex() {
        out.add(0, 1);
        out.add(1, 2);
        Integer result = out.remove(1);
        assertEquals(IntegersTest[1], result);
    }

    @Test
    void removeByItem() {
        out.add(0, 1);
        out.add(1, 2);
        Integer result = out.removeItem(2);
        assertEquals(IntegersTest[1], result);
    }

    @Test
    void contains() {
        out.add(0, 1);
        out.add(1, 2);
        boolean result = out.contains(2);
        assertTrue(result);
    }

    @Test
    void indexOf() {
        out.add(0, 1);
        out.add(1, 2);
        out.add(2, 3);
        int result = out.indexOf(2);
        assertEquals(1, result);
    }

    @Test
    void lastIndexOf() {
        out.add(0, 0);
        out.add(1, 1);
        out.add(2, 2);
        out.add(3, 3);
        out.add(4, 4);
        out.add(5, 5);
        out.add(6, 6);
        out.add(7, 7);
        out.add(8, 8);
        out.add(9, 9);
        int result = out.lastIndexOf(2);
        assertEquals(2, result);
    }

    @Test
    void get() {
        out.add(0, 1);
        out.add(1, 2);
        out.add(2, 3);
        Integer result = out.get(2);
        assertEquals(3, result);
    }
}
