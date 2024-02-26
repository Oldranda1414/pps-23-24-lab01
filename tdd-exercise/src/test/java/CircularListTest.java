import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import tdd.CircularList;
import tdd.CircularListImpl;

/**
 * The test suite for testing the CircularList implementation
 */
public class CircularListTest {

    private static final int TEST_VALUE = 1;
    private static final int SECOND_TEST_VALUE = 2;
    
    private CircularList circularList;

    @BeforeEach
    void BeforeEach(){
        circularList = new CircularListImpl();
    }

    @Test
    void testEmptyList(){
        assertAll(
            () -> assertTrue(circularList.isEmpty()),
            () -> assertEquals(0, circularList.size()),
            () -> assertFalse(circularList.next().isPresent())
        );
    }

    @Test
    void testAddValue(){
        circularList.add(TEST_VALUE);
        assertAll(
            () -> assertFalse(circularList.isEmpty()),
            () -> assertEquals(TEST_VALUE, circularList.next().get()),
            () -> assertEquals(1, circularList.size())
        );
    }

    @Test
    void testNextFunctionality(){
        circularList.add(TEST_VALUE);
        circularList.add(SECOND_TEST_VALUE);
        circularList.next();
        assertEquals(SECOND_TEST_VALUE ,circularList.next().get());
    }

    @Test
    void testListCircularity(){
        circularList.add(TEST_VALUE);
        circularList.add(SECOND_TEST_VALUE);
        circularList.next();
        circularList.next();
        assertEquals(TEST_VALUE ,circularList.next().get());
    }
}