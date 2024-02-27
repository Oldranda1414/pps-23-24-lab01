import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Collections;

import tdd2.CircularList2;
import tdd2.CircularList2Impl;

public class CircularList2Test {

    private CircularList2 circularList;

    @BeforeEach
    void beforeEach(){
        circularList = new CircularList2Impl();
    }

    @Test
    void testEmptyList(){
        assertAll(
            () -> assertTrue(circularList.isEmpty()),
            () -> assertEquals(0, circularList.size()),
            () -> assertEquals(Collections.emptyIterator(), circularList.forwardIterator()),
            () -> assertEquals(Collections.emptyIterator(), circularList.backwardIterator())
        );
    }
}
