import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.function.Function;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import tdd3.CircularList3;
import tdd3.CircularList3Impl;

public class CircularList3Test {
    
    private CircularList3 circularList;
    private Function<Integer, Boolean> isEven = (value) -> value % 2 == 0;
    private int TEST_VALUE = 1;
    private int SECOND_TEST_VALUE = 2;

    @BeforeEach
    void BeforeAll(){
        circularList = new CircularList3Impl();
    }

    @Test
    void testEmptyList(){
        assertAll(
            () -> assertTrue(circularList.isEmpty()),
            () -> assertEquals(0, circularList.size()),
            () -> assertFalse(circularList.next().isPresent()),
            () -> assertFalse(circularList.previous().isPresent()),
            () -> assertFalse(circularList.filteredNext(isEven).isPresent())
        );
    }

    @Test
    void testAdd(){
        addTwoElements();
        assertAll(
            () -> assertFalse(circularList.isEmpty()),
            () -> assertEquals(circularList.size(), 2)
        );
    }

    private void addTwoElements(){
        circularList.add(TEST_VALUE);
        circularList.add(SECOND_TEST_VALUE);
    }
}
