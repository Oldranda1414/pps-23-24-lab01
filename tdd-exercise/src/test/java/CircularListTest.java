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
            () -> assertFalse(circularList.next().isPresent()),
            () -> assertFalse(circularList.previous().isPresent())
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
        this.addTwoValues();
        circularList.next();
        assertEquals(SECOND_TEST_VALUE ,circularList.next().get());
    }

    @Test
    void testPreviousFuncionality(){
        this.addTwoValues();
        circularList.next();
        assertEquals(TEST_VALUE, circularList.previous().get());
    }

    @Test
    void testListForwardCircularity(){
        this.addTwoValues();
        circularList.next();
        circularList.next();
        assertEquals(TEST_VALUE ,circularList.next().get());
    }

    @Test
    void testListBackwardCircularity(){
        this.addTwoValues();
        circularList.previous();
        circularList.previous();
        assertEquals(SECOND_TEST_VALUE, circularList.previous().get());
    }

    @Test
    void testResetIterator(){
        this.addTwoValues();
        circularList.next();
        circularList.reset();
        assertEquals(TEST_VALUE, circularList.next().get());
    }
    
    private void addTwoValues(){
        circularList.add(TEST_VALUE);
        circularList.add(SECOND_TEST_VALUE);
    }
}